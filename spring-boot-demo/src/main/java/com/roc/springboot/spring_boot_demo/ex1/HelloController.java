package com.roc.springboot.spring_boot_demo.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Value(value="${my.name}")
	private String name;
	
	@Value(value="${my.age}")
	private int age;
	
	@Autowired
	private MyInformation myInformation;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "hello world";
	}
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return myInformation.getGreeting()+">>>>"+myInformation.getMax()+">>>>>"+myInformation.getUid();
	}
}
