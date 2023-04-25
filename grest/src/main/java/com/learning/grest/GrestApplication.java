package com.learning.grest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class GrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrestApplication.class, args);
	}

}
