package com.springboot.caseStudy.repositories;

import com.springboot.caseStudy.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {


}
