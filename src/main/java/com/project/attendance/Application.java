package com.project.attendance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Application {
	@Autowired
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		LOG.info("Starting.....");
		SpringApplication.run(Application.class, args);
		
		
	}

}
