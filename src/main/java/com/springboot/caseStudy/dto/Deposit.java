package com.springboot.caseStudy.dto;

import java.math.BigDecimal;

public class Deposit {

  private Integer userId;
  private BigDecimal balance;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
