package com.roc.springboot.spring_boot_demo.ex3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roc.springboot.spring_boot_demo.ex2.Account;
import com.roc.springboot.spring_boot_demo.ex2.IAccountService;
@Service
public class Account1Service  implements IAccountService{

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public int add(Account account) {
		// TODO Auto-generated method stub
		return accountMapper.add(account);
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return accountMapper.update(account);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return accountMapper.delete(id);
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return accountMapper.findAccountById(id);
	}

	@Override
	public List<Account> findAccountList() {
		// TODO Auto-generated method stub
		return accountMapper.findAccountList();
	}

	@Override
	public void testTransaction(int id, Account account) {
		// TODO Auto-generated method stub
		
	}

}
