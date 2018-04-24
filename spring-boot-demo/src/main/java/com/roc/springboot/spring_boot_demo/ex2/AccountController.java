package com.roc.springboot.spring_boot_demo.ex2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="")
	public String index(){
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
	public  Map<String,Object>  updateAaccount(@PathVariable int id,@RequestParam(value = "name") String name,@RequestParam(value = "money" ,required = true) double money) {
		
		Account account = new Account();
		account.setId(id);
		account.setMoney(money);
		account.setName(name);
	    int count = accountService.update(account);
		Map<String,Object> result = new HashMap<String,Object>();
	    if(count == 1) {
	    	result.put("msg", "ok");
	    	result.put("success", true);
	    	return result;
	    }else {
	    	result.put("msg", "no");
	    	result.put("success", false);
	    	return result;
	    }
	    
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public Map<String,Object> addAccount(@RequestParam(value = "name",required=true) String name,@RequestParam(value = "money" ,required = true) double money){
		Account account = new Account();
		account.setMoney(money);
		account.setName(name);
		int count = accountService.add(account);
		Map<String,Object> result = new HashMap<String,Object>();
	    if(count == 1) {
	    	result.put("msg", "ok");
	    	result.put("success", true);
	    	return result;
	    }else {
	    	result.put("msg", "no");
	    	result.put("success", false);
	    	return result;
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
}
