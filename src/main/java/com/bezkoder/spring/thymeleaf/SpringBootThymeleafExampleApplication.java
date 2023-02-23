package com.bezkoder.spring.thymeleaf;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootThymeleafExampleApplication {

	public static void main(String[] args) {
		
		//ClassLoader cl = ClassLoader.getSystemClassLoader();
		//URL[] urls = ((URLClassLoader) cl).getURLs();
		//Arrays.stream(urls).filter(u -> !u.getfile())
		SpringApplication.run(SpringBootThymeleafExampleApplication.class, args);
	}

}
