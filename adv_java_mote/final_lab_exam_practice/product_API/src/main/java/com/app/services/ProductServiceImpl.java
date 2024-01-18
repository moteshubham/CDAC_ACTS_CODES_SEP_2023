package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.dto.ProductDto;
import com.app.entities.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto addProductDetails(ProductDto dto) {
		System.out.println("2");
		Product product = mapper.map(dto, Product.class);
		System.out.println("DTO : "+dto);
		return mapper.map(productDao.save(product),ProductDto.class);
	}

	@Override
	public List<Product> getAllProductDetails() {
		
		return productDao.findAll();
	}
}
