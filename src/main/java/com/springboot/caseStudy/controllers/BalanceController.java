package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.dto.Deposit;
import com.springboot.caseStudy.dto.Withdraw;
import com.springboot.caseStudy.exceptions.NotFoundException;
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

    public BalanceController(AccountService accountService) {
        this.accountService = accountService;
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
            account.getBalance().setBakiye(account.getBalance().getBakiye().add(deposit.getBalance()));
            Account updateAccount = accountService.save(account);
            return new GenericResponse("success",updateAccount);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/account/withdraw/{user_id}", method = RequestMethod.POST)
    public GenericResponse withdrawBalance(@RequestBody Withdraw withdraw) {
        try {
            Account account = accountService.withdraw(withdraw);
            return new GenericResponse("success",account);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

    @PostMapping(value = "/account/transfer")
    public GenericResponse<List<Account>> transferBalance(@RequestBody Transfer transfer) {
        try {
            Account account1 = accountService.get(transfer.getFromId());
            Account account2 = accountService.get(transfer.getToId());
            BigDecimal acc1=account1.getBalance().getBakiye();
            BigDecimal acc2=account2.getBalance().getBakiye();
            int fromAccBakiye=acc1.intValue();
            int toAccBakiye=acc2.intValue();
            if (account1.getCurrencyType().equals(account2.getCurrencyType()) ){
                if (fromAccBakiye >= toAccBakiye){
                    account1.getBalance().setBakiye(account1.getBalance().getBakiye().subtract(transfer.getAmountToTransfer()));
                    account2.getBalance().setBakiye(account2.getBalance().getBakiye().add(transfer.getAmountToTransfer()));
                }
                else if (fromAccBakiye < toAccBakiye){
                    System.out.println("Yeterli Bakiyeniz Bulunmamaktadır");
                }

            }
            else {
                System.out.println("Hesapların Para Birimi Farklıdır.");
            }
            //account1.getBalance().setBakiye(account1.getBalance().getBakiye().subtract(transfer.getAmountToTransfer()));
            //account2.getBalance().setBakiye(account2.getBalance().getBakiye().add(transfer.getAmountToTransfer()));
            Account updateAccount1 = accountService.save(account1);
            Account updateAccount2 = accountService.save(account2);
            List<Account> list=accountService.list();
            return new GenericResponse("success",list);
        } catch (NotFoundException e) {
            return new GenericResponse<>(e.getMessage(),null);
        }
    }

}






