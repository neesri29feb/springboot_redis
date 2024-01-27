package com.neesri.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.neesri.redis.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final String HASH_KEY = "Product";

	public Product save(Product product) {

		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Object> findAll() {

		return redisTemplate.opsForHash().values(HASH_KEY);

	}

	public Product findProductById(int id) {
		return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		
		 redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "Product Deleted !!";
	}
	

}
