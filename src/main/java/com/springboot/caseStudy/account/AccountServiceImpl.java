package com.springboot.caseStudy.account;

import com.springboot.caseStudy.repositories.AccountRepository;
import com.springboot.caseStudy.repositories.BalanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl extends AccountService {
    private AccountRepository accountRepository;
    private BalanceRepository balanceRepository;


    public AccountServiceImpl(AccountRepository accountRepository,
                           BalanceRepository balanceRepository) {
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void saveBalance(Account account) {
        Account account1 = new Account();
        Balance balance = new Balance();
        account1.setBalance(balance.setUser_id(account1.getUserId()));
        balance.setBakiye(0);

        Optional<Balance> balance1 = balanceRepository.findById(account.getUserId());

        balanceRepository.save(balance);
    }


}
