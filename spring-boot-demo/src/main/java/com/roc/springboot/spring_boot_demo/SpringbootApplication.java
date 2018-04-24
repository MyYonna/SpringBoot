package com.roc.springboot.spring_boot_demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.roc.springboot.spring_boot_demo.ex5.Customer;
import com.roc.springboot.spring_boot_demo.ex5.CustomerDAO;
import com.roc.springboot.spring_boot_demo.ex6.RedisDAO;

@SpringBootApplication
public class SpringbootApplication {

	@Autowired
	RedisDAO redisDAO;
	@Autowired
	CustomerDAO customerDAO;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//    	Redis
		redisDAO.setValue("zhang","peng");
		redisDAO.setValue("huang","jing");
		 // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        String value = redisDAO.getValue("huang");
    	System.out.println(value);
    	
//    	Mongodb
		// TODO Auto-generated method stub
		customerDAO.deleteAll();
		customerDAO.save(new Customer("zhang","peng"));
		customerDAO.save(new Customer("huang","jing"));
		 // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        List<Customer> customers = customerDAO.findAll();
        for(Customer customer : customers) {
        	System.out.println(customer.toString());
        }
        System.out.println("Customer found with findByFirstName('zhang'):");
        System.out.println("--------------------------------");
        customers = customerDAO.findByFirstName("zhang");
        for(Customer customer : customers) {
        	System.out.println(customer.toString());
        }
        
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
