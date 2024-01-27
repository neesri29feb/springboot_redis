package com.neesri.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neesri.redis.entity.Product;
import com.neesri.redis.repository.ProductDao;

@RestController
@RequestMapping("/product")

public class ProductController {

	@Autowired
	ProductDao productDao;

	@PostMapping
	public Product save(@RequestBody Product product) {

		return productDao.save(product);

	}

	@GetMapping
	public List<Object> getAllProducts() {

		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {

		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {

		return productDao.deleteProduct(id);
	}

}
