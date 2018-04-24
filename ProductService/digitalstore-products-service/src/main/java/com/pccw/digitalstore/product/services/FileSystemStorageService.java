package com.pccw.digitalstore.product.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pccw.digitalstore.product.DigitalstoreProductsServiceApplication;
import com.pccw.digitalstore.product.exception.FilePermissionException;
import com.pccw.digitalstore.product.exception.ImageNotFoundException;
import com.pccw.digitalstore.product.models.Product;

@Service("fileSystemStroageService")
public class FileSystemStorageService implements StorageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemStorageService.class);
	
	@Value("${file.system.base.path}")
	private String BASE_PATH;
	
	ApplicationHome home = new ApplicationHome(DigitalstoreProductsServiceApplication.class);

	@Override
	public String store(MultipartFile file, Product product) throws Exception {
		if(file == null || file.isEmpty()) {
			throw new ImageNotFoundException();	
		}
		String originalFileName = file.getOriginalFilename();

		LOGGER.debug("Start storing file process");
		LOGGER.debug("File details: ");
		LOGGER.debug("File content type: " + file.getContentType());
		LOGGER.debug("File name : " + file.getName());
		LOGGER.debug("File original name : " + originalFileName);
		LOGGER.debug("File size : " + file.getSize());

		String pathToImages = home.getDir().getCanonicalPath().concat(BASE_PATH).concat(String.valueOf(product.getId()))
				.concat(File.separator).concat(file.getOriginalFilename());
		Path directory = Paths.get(pathToImages);
		LOGGER.debug("Real Path: {}", pathToImages);
		// Check if file directory exist
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
	public Resource loadAsResouce(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkFilePathPermission(File file) throws Exception {
		if(file != null && file.canExecute() && file.canRead() && file.canWrite()) {
			return true;
		}
		throw new FilePermissionException();
	}

}
