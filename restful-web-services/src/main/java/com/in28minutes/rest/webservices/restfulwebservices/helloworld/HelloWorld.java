package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("/hello-world")
	public String hellowWorld() {
		return "hello World ";
	}
	
	@GetMapping("/hello-world-bean")
	public helloWorldBean hellowWorldBean() {
		return new helloWorldBean("hello World from spring");
	}
	
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public helloWorldBean hellowWorldPathVeriable(@PathVariable String name) {
		return new helloWorldBean("hello World "+name);
	}

}
