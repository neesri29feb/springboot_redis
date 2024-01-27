package com.neesri.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRedisApplication {

	public static void main(String[] args) {
		System.out.println("Spring data redis example --------------------------");
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

}
