package me.jihyun.springMVC.Runners;

import me.jihyun.springMVC.Models.Account;
import me.jihyun.springMVC.Services.AccountSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    private AccountSerivce accountSerivce;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = accountSerivce.createAccount("jihyun", "wlgus");
        System.out.println(account.getUsername() + ' ' + account.getPassword());
    }
}
