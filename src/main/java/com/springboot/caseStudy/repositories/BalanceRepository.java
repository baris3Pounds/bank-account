package com.springboot.caseStudy.repositories;

import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.balance.BalanceService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

    @Query(value = "select sum(bakiye) from balance where user_id = :user_id", nativeQuery = true)
    Integer getTotalBalance(@Param("user_id")int user_id);


    @Modifying
    @Query(value = "UPDATE bakiye set bakiye = :bakiye where user_id = :user_id", nativeQuery = true)
    @Transactional
    void changeBalanceById(@Param("bakiye") int bakiye, @Param("user_id") int user_id);

}
