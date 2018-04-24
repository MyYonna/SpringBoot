package com.roc.springboot.spring_boot_demo.ex1;

import static org.hamcrest.CoreMatchers.*; 
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HelloControllerIT extends Assert{

	@LocalServerPort
	private int port;
	
	private URL base;
	@Value(value="/index")
	private String path;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Before
	public void setup() throws MalformedURLException {
		this.base = new URL("http://127.0.0.1:"+port+path);
	}
	
	@Test
	public void getHello() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(base.toString(), String.class);
		assertThat(responseEntity.getBody(),equalTo("hello world"));
		
	}
	
}
