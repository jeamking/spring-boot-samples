package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/hello")
@SpringBootApplication
public class HelloController  implements EmbeddedServletContainerCustomizer {
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home() {
		return "Hello, world.";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}	

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// TODO Auto-generated method stub
		container.setPort(8808);
	}

}
