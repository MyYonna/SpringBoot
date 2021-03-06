package com.roc.springboot.spring_boot_demo.ex2;

import java.util.List;

public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
    
    void testTransaction(int id,Account account);

}
