package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("in product controller!!");
	}
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody ProductDto dto){
		try {
			System.out.println("1 ");
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProductDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
		}
	}
	
	@GetMapping
	public List<Product> getAllProductDetails(){
		return productService.getAllProductDetails();
	}
}
