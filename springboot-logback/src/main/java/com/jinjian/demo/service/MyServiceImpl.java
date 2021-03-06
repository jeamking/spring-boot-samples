package com.jinjian.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

  private static final Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

  @Override
  public void printLog(final String value) {
		logger.trace("doStuff needed more information - {}", value);
		logger.debug("doStuff needed to debug - {}", value);
		logger.info("doStuff took input - {}", value);
		logger.warn("doStuff needed to warn - {}", value);
		logger.error("doStuff encountered an error with value - {}", value);
/*		try {
			int i = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}*/
  }
}
