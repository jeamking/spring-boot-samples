package com.jinjian.demo.web.controller;

import com.jinjian.demo.aop.SpringAOP;
import com.jinjian.demo.service.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
    @Autowired
    private DemoService demoService;

    @GetMapping("test")
    public String test() {
        return demoService.test();
    }
    
    @RequestMapping("/")
    public String hello(){
    	logger.info("IndexController.hello()begin");
    	demoService.test();
    	logger.info("IndexController.hello()end");
        return "Greetings from Spring Boot!";
    }    
}
