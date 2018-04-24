package com.roc.springboot.spring_boot_demo.ex7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roc.springboot.spring_boot_demo.ex6.RedisDAO;

@RestController
@RequestMapping("/hello-test")
public class HelloTestController {

	@Autowired
	RedisDAO redisDAO;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "hello world";
	}
	@RequestMapping(value="/value/{key}",method=RequestMethod.GET)
	public String value(@PathVariable String key) {
		return redisDAO.getValue(key);
	}
}
