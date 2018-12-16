package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Application {
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
}
