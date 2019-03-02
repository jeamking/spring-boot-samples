package com.jinjian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jinjian.demo.service.MyService;
import com.jinjian.demo.service2.MyService2;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired private MyService myService;
  @Autowired private MyService2 myService2;

  public static void main(String args[]) {
    SpringApplication.run(Application.class);
  }

  @Override
	public void run(final String args[]) {
		myService.printLog("value");
		myService2.printLog("va2");
	}
}
