package com.app.services;

import java.util.List;

import com.app.dto.ProductDto;
import com.app.entities.Product;

public interface ProductService {
	ProductDto addProductDetails(ProductDto dto);
	List<Product> getAllProductDetails();
}
