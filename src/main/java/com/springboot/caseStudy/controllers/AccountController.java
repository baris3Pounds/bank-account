package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.AccountNotFoundException;
import com.springboot.caseStudy.account.AccountServiceImpl;
import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.balance.BalanceNotFoundException;
import com.springboot.caseStudy.balance.BalanceService;
import com.springboot.caseStudy.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountServiceImpl service;
    @Autowired
    private BalanceService service2;

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/accounts")
    public String getAccounts(Model model){
        model.addAttribute("accounts",accountRepository.findAll());
        return "accounts";
    }


    @GetMapping("/accounts")
    public String showAccountList(Model model){
        List<Account> listAccounts = service.listAll();
        model.addAttribute("listAccounts",listAccounts);
        return "accounts";
    }


    @GetMapping("/account/create")
    public String showNewForm(Model model){
        model.addAttribute("account",new Account());
        model.addAttribute("pageTitle","Create New Account");
        return "create_account";
    }

    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    public String saveAccount(Account account){
        service.save(account);
        Balance balance=new Balance(0);
        balance.setAccount(account);
        account.setBalance(balance);
        service2.save(balance);
        return "redirect:/accounts";
    }


}
