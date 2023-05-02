package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class RestfulWebServicesApplication {

//    @PostConstruct
//    public void init() {
//        Logger logger = (Logger) LoggerFactory.getLogger("org.springframework");
//        logger.setLevel(Level.DEBUG);
//    }
//	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
