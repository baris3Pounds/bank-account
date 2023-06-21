package com.springboot.caseStudy.account;

import com.springboot.caseStudy.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AccountService {

  @Autowired
  private AccountRepository repo;

  public List<Account> listAll() {
    return (List<Account>) repo.findAll();
  }

  public void save(Account account) {
    repo.save(account);
  }

  public Account get(Integer user_id) throws AccountNotFoundException {
    Optional<Account> result = repo.findById(user_id);
    if (result.isPresent()) {
      return result.get();
    }
    throw new AccountNotFoundException("Could not find accounts with ID" + user_id);

  }

  public abstract void saveBalance(Account account);
}
