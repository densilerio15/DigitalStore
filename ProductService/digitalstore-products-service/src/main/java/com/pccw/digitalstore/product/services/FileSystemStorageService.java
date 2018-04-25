package com.pccw.digitalstore.product.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pccw.digitalstore.product.exception.FilePermissionException;
import com.pccw.digitalstore.product.exception.ImageNotFoundException;
import com.pccw.digitalstore.product.models.Product;

@Service("fileSystemStroageService")
public class FileSystemStorageService implements StorageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemStorageService.class);
	
	@Value("${file.system.base.path}")
	private String productsPath;
	
//	ApplicationHome home = new ApplicationHome(DigitalstoreProductsServiceApplication.class);
	
	//Will get the path where the jar file is deployed
	private final String BASE_PATH = new File(".").getAbsolutePath();

	@Override
	public String store(MultipartFile file, Product product) throws IOException {
		if(file == null || file.isEmpty()) {
			throw new ImageNotFoundException("File given is empty.");	
		}
		String originalFileName = file.getOriginalFilename();
		
		LOGGER.debug("Start storing file process");
		LOGGER.debug("File details: ");
		LOGGER.debug("File content type: " + file.getContentType());
		LOGGER.debug("File name : " + file.getName());
		LOGGER.debug("File original name : " + originalFileName);
		LOGGER.debug("File size : " + file.getSize());

		String pathToImage = BASE_PATH.concat(productsPath).concat(String.valueOf(product.getId())).concat(File.separator)
				.concat(file.getOriginalFilename());
		Path directory = Paths.get(pathToImage);
		
		LOGGER.debug("Real Path: {}", pathToImage);

		if (!directory.toFile().exists()) {
			LOGGER.debug("File path does not exist will create new directory at {}", directory.getParent());
			Files.createDirectories(directory.getParent());
			checkFilePathPermission(directory.getParent().toFile());
        }
		file.transferTo(directory.toFile());
		return file.getOriginalFilename();
	}

	@Override
	public Path load(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource loadAsResouce(Long productId, String fileName) throws MalformedURLException {
		//Search within the product IS as the folder then search the filename given
		Path imagePath = Paths.get(BASE_PATH.concat(productsPath)).resolve(String.valueOf(productId)).resolve(fileName);
		LOGGER.debug("Will get resource at path {}", imagePath);
		Resource resource = new UrlResource(imagePath.toUri());
		
		if(resource.exists() || resource.isReadable()) {
			return resource;
		} else {
			throw new ImageNotFoundException("Could not read file: " + fileName);
		}
	}

	private boolean checkFilePathPermission(File file){
		if(file != null && file.canExecute() && file.canRead() && file.canWrite()) {
			return true;
		}
		throw new FilePermissionException("Cannot Read/Create file, Please see permission rules");
	}

	@Override
	public void deleteAll() throws IOException {
		FileSystemUtils.deleteRecursively(Paths.get(BASE_PATH.concat(productsPath)));
	}

}
