package com.roc.springboot.spring_boot_demo.ex2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements IAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int add(Account account) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into account(name,money) values(?,?)", account.getName(),account.getMoney());
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update account t set t.name = ? , t.money = ? where t.id = ?", new Object[] {account.getName(),account.getMoney(),account.getId()});
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from  account  where id = ?",id);
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		List<Account> list = jdbcTemplate.query("select * from  account t where t.id = ?", new Object[]{id}, new BeanPropertyRowMapper<Account>(Account.class));
		if(list != null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Account> findAccountList() {
		// TODO Auto-generated method stub
		 List<Account> list = jdbcTemplate.query("select * from  account t ", new Object[] {}, new BeanPropertyRowMapper<Account>(Account.class));;
		 return list;
	}

}
