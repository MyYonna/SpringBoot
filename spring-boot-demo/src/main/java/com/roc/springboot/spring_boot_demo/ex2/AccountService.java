package com.roc.springboot.spring_boot_demo.ex2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService  implements IAccountService{

	@Autowired
	IAccountDAO accountDao;
	
	@Override
	public int add(Account account) {
		// TODO Auto-generated method stub
		return accountDao.add(account);
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return accountDao.update(account);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return accountDao.delete(id);
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(id);
	}

	@Override
	public List<Account> findAccountList() {
		// TODO Auto-generated method stub
		return accountDao.findAccountList();
	}

	@Override
	public void testTransaction(int id, Account account) {
		// TODO Auto-generated method stub
		
	}

}
