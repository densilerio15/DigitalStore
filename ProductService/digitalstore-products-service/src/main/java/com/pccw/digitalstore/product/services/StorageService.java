package com.pccw.digitalstore.product.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.pccw.digitalstore.product.models.Product;

public interface StorageService {
	
	String store(MultipartFile file, Product product) throws IOException;
	
	Path load(String fileName);
	
	Resource loadAsResouce(Long productId, String fileName) throws MalformedURLException;
	
	void deleteAll() throws IOException ;
}
