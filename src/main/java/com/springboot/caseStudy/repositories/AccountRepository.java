package com.springboot.caseStudy.repositories;

import com.springboot.caseStudy.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends CrudRepository<Account, Integer> {


}
