package com.springboot.caseStudy.service;


import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.dto.Withdraw;
import com.springboot.caseStudy.exceptions.InsufficientFundsException;
import com.springboot.caseStudy.exceptions.NotFoundException;
import com.springboot.caseStudy.repositories.AccountRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account save(Account account){
    return accountRepository.save(account);
  }


  public List<Account> list(){
    return accountRepository.findAll();
  }

  public Account get(Integer userId){
    return accountRepository.findById(userId).orElseThrow(()-> new NotFoundException("Account not found"));
  }

  public Account withdraw(Withdraw withdrawDto){
    Account account = accountRepository.findById(withdrawDto.getUserId())
        .orElseThrow(() -> new NotFoundException("Account not found"));
    Balance balance = account.getBalance();
    if(balance.getBakiye().compareTo(withdrawDto.getAmountToWithdraw()) == -1){
      throw new InsufficientFundsException("Balance not enough");
    }
    balance.setBakiye(balance.getBakiye().subtract(withdrawDto.getAmountToWithdraw()));
    return account;
  }



}
