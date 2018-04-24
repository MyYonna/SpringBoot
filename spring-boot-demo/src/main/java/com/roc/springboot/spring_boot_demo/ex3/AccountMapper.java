package com.roc.springboot.spring_boot_demo.ex3;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.roc.springboot.spring_boot_demo.ex2.Account;

@Mapper
public interface AccountMapper {
	@Insert("insert into account(name,money) values(#{account.name},#{account.money})")
    int add(@Param("account") Account account);

	@Update("update account t set t.name=#{account.name},t.money=#{account.money} where t.id=#{account.id}")
    int update(@Param("account") Account account);

	@Delete("delete from account where id=#{id}")
    int delete(@Param("id") int id);

	@Select("select * from account t where t.id = #{id}")
    Account findAccountById(@Param("id")int id);
	
	@Select("select * from account t")
    List<Account> findAccountList();
}
