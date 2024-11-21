package com.karan.redis.cach.optimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCachOptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCachOptimizationApplication.class, args);
	}

}
