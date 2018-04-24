package com.roc.springboot.spring_boot_demo.ex4;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roc.springboot.spring_boot_demo.ex2.Account;
import com.roc.springboot.spring_boot_demo.ex2.IAccountService;
@Service
public class Account4Service  implements IAccountService{

	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public int add(Account account) {
		// TODO Auto-generated method stub
		accountDAO.saveAndFlush(account);
		return 1;
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		accountDAO.saveAndFlush(account);
		return 1;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		 accountDAO.delete(id);
		 return 1;
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findOne(id);
		
	}

	@Override
	public List<Account> findAccountList() {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}

	
	@Override
	@Transactional
	public void testTransaction(int id, Account account) {
		// TODO Auto-generated method stub
		accountDAO.delete(id);
		int i = 3/0;
		accountDAO.saveAndFlush(account);
	}

}
