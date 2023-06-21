package com.springboot.caseStudy;

import com.springboot.caseStudy.account.Account;
import com.springboot.caseStudy.repositories.AccountRepository;
import com.springboot.caseStudy.account.Balance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AccountRepositoryTests {
    @Autowired private AccountRepository repo;

    @Test
    public void testAddNew(){
        Account account=new Account();
        account.setName("Ahmet");
        account.setSurname("Gül");
        account.setTelephone("05608045255");
        account.setEmail("ahmet.gul@hotmail.com");

        Account savedAccount= repo.save(account);

        Assertions.assertNotNull(savedAccount);
        Assertions.assertTrue(savedAccount.getUserId()>0);
    }


    @Test
    public void testListAll(){
        Iterable<Account> accounts = repo.findAll();
        Assertions.assertTrue(accounts.spliterator().getExactSizeIfKnown()>0);

        for (Account account: accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testUpdate() {
        Integer userId =92;
        Optional<Account> optionalAccount = repo.findById(userId);
        Account account=optionalAccount.get();
        account.setName("Tevfik");
        repo.save(account);

        Account updateAccount = repo.findById(userId).get();
        Assertions.assertEquals(updateAccount.getName(),"Tevfik");

    }

    @Test
    public void testGet(){
        Integer userId =92;
        Optional<Account> optionalAccount = repo.findById(userId);
        Assertions.assertTrue(optionalAccount.isPresent());
        System.out.println(optionalAccount.get());

    }

    @Test
    public void testDelete(){
        Integer userId =92;
        repo.deleteById(userId);

        Optional<Account> optionalAccount = repo.findById(userId);
        Assertions.assertTrue(!optionalAccount.isPresent());
    }

    @Test
    public void testAdd() {
        Account account = new Account();
        Balance balance = new Balance();
        account.setName("Tevfik");
        account.setSurname("Uykun");
        account.setTelephone("12312321313");
        account.setEmail("das@da");
        balance.setBakiye(2500);
        account.setBalance(balance);
        balance.setAccount(account);

        Account savedAccount;
        savedAccount = repo.save(account);

        Assertions.assertNotNull(savedAccount);

    }


}
