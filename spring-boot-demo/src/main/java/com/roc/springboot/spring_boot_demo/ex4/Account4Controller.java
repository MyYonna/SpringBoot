package com.roc.springboot.spring_boot_demo.ex4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roc.springboot.spring_boot_demo.ex2.Account;

@RestController
@RequestMapping("/account4")
public class Account4Controller {
	@Autowired
	Account4Service accountService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "hello world";
	}
	
	@RequestMapping(value="/lists")
	public List<Account> getAccounts(){
		return accountService.findAccountList();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Account getAccountById(@PathVariable int id) {
		return accountService.findAccountById(id);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String updateAaccount(@PathVariable int id,@RequestParam(value = "name") String name,@RequestParam(value = "money" ,required = true) double money) {
		
		Account account = new Account();
		account.setId(id);
		account.setMoney(money);
		account.setName(name);
	    int count = accountService.update(account);
	    if(count == 1) {
	    	return "success";
	    }else {
	    	return "failure";
	    }
	    
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public String addAccount(@RequestParam(value = "name",required=true) String name,@RequestParam(value = "money" ,required = true) double money){
		Account account = new Account();
		account.setMoney(money);
		account.setName(name);
		int count = accountService.add(account);
	    if(count == 1) {
	    	return "success";
	    }else {
	    	return "failure";
	    }
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable int id) {
		int count = accountService.delete(id);
	    if(count == 1) {
	    	return "success";
	    }else {
	    	return "failure";
	    }
	}
	@RequestMapping(value="/{id}/log",method=RequestMethod.PUT)
	public String deleteAndAddAccount(@PathVariable int id) throws Exception {
		Account account = new Account();
		account.setMoney(0);
		account.setName("wuye");
		accountService.testTransaction(id,account);
		return "success";
	}
}
