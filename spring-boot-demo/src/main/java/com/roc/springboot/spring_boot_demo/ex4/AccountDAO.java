package com.roc.springboot.spring_boot_demo.ex4;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roc.springboot.spring_boot_demo.ex2.Account;

public interface AccountDAO extends JpaRepository<Account, Integer> {

}
