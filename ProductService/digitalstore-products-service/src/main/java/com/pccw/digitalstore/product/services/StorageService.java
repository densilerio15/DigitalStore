package com.pccw.digitalstore.product.services;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.pccw.digitalstore.product.models.Product;

public interface StorageService {
	
	public String store(MultipartFile file, Product product) throws Exception;
	
	public Path load(String fileName);
	
	public Resource loadAsResouce(String fileName);

}
