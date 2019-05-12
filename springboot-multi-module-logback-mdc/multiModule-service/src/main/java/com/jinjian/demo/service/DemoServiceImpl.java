package com.jinjian.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements  DemoService {
	private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
    @Override
    public String test() {
    	logger.info("DemoServiceImpl.test()");
        return "hello world";
    }
}
