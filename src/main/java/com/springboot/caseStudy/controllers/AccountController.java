package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.balance.BalanceService;
import com.springboot.caseStudy.service.AccountService;
import com.springboot.caseStudy.util.GenericResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private BalanceService balanceService;

    private final AccountService accountService;

    public AccountController(BalanceService balanceService, AccountService accountService) {
        this.balanceService = balanceService;
        this.accountService = accountService;
    }

    @RequestMapping("/accounts")
    public GenericResponse<List<Account>> getAccounts(){
        List<Account> list = accountService.list();
        return new GenericResponse<>("success", list);
    }


    @PostMapping(value = "/account/create")
    public GenericResponse<Account> saveAccount(@RequestBody Account account){
        Balance balance = account.getBalance();
        Balance savedBalance = balanceService.save(balance);
        account.setBalance(savedBalance);
        Account savedAccount = accountService.save(account);
        return new GenericResponse<>("success",savedAccount);
    }


}
