package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.balance.BalanceService;
import com.springboot.caseStudy.dto.Deposit;
import com.springboot.caseStudy.dto.Withdraw;
import com.springboot.caseStudy.exceptions.NotFoundException;
import com.springboot.caseStudy.repositories.BalanceRepository;
import com.springboot.caseStudy.service.AccountService;
import com.springboot.caseStudy.util.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    private final AccountService accountService;
    private final BalanceService balanceService;
    private final BalanceRepository balanceRepository;

    public BalanceController(AccountService accountService, BalanceService balanceService,
        BalanceRepository balanceRepository) {
        this.accountService = accountService;
        this.balanceService = balanceService;
        this.balanceRepository = balanceRepository;
    }


    @GetMapping("/account/balance/{user_id}")
    public GenericResponse<Account> showEditForm(@PathVariable("user_id") Integer userId) {
        try {
            Account account = accountService.get(userId);
            return new GenericResponse<>("success",account);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }


    @PostMapping(value = "/account/deposit/{user_id}")
    public GenericResponse<Account> depositBalance(@RequestBody Deposit deposit) {
        try {
            Account account = accountService.get(deposit.getUserId());
            account.getBalance().setBakiye(deposit.getBalance());
            Account updateAccount = accountService.save(account);
            return new GenericResponse("success",updateAccount);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/account/withdraw/{user_id}", method = RequestMethod.POST)
    public GenericResponse withdrawBalance(Withdraw withdraw) {
        try {
            Account account = accountService.withdraw(withdraw);
            return new GenericResponse("success",account);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

}






