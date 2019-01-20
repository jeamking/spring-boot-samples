package com.jinjian.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements  DemoService {
    @Override
    public String test() {
        return "hello world";
    }
}
