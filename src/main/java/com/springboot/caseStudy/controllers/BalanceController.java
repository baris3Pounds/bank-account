package com.springboot.caseStudy.controllers;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.AccountNotFoundException;
import com.springboot.caseStudy.account.AccountServiceImpl;
import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.balance.BalanceNotFoundException;
import com.springboot.caseStudy.balance.BalanceService;
import com.springboot.caseStudy.repositories.BalanceRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
public class BalanceController {
    @Autowired
    private AccountServiceImpl service2;
    @Autowired
    private BalanceService service;

    private final BalanceRepository balanceRepository;

    public BalanceController(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }


    @GetMapping("/account/balance/{user_id}")
    public String showEditForm(@PathVariable("user_id") Integer user_id, Model model, Model model2) {
        try {
            Account account = service2.get(user_id);
            Balance balance = service.get(user_id);
            model.addAttribute("account", account);
            model2.addAttribute("balance", balance);
            model.addAttribute("pageTitle", "Edit Balance(ID: " + user_id + ")");
            return "balance_deposit";
        } catch (AccountNotFoundException e) {
            return "redirect:/balances";
        } catch (BalanceNotFoundException e) {
            return "redirect:/balances";
        }
    }


    @RequestMapping(value = "/account/deposit/{user_id}", method = RequestMethod.POST)
    public String depositBalance(@PathVariable("user_id") Integer user_id, Model model) {
        try {
            Balance balance = service.get(user_id);
            service.save(balance);
            model.addAttribute("balance", balance);
            model.addAttribute("pageTitle", "Edit Balance(ID: " + user_id + ")");
            return "depositMoney";
        } catch (BalanceNotFoundException e) {
            return "redirect:/accounts";
        }
    }

    @RequestMapping(value = "/account/withdraw/{user_id}", method = RequestMethod.POST)
    public String withdrawBalance(@PathVariable("user_id") Integer user_id, Model model) {
        try {
            Account account = service2.get(user_id);
            Balance balance = service.get(user_id);
            model.addAttribute("balance", balance);
            model.addAttribute("pageTitle", "Edit Balance(ID: " + user_id + ")");
            service.save(balance);
            return "withdrawMoney";
        } catch (AccountNotFoundException e) {
            return "redirect:/balances";
        } catch (BalanceNotFoundException e) {
            return "redirect:/balances";
        }
    }

}






