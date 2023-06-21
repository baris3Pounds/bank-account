package com.springboot.caseStudy.dto;

import java.math.BigDecimal;

public class Withdraw {

  private Integer userId;
  private BigDecimal amountToWithdraw;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BigDecimal getAmountToWithdraw() {
    return amountToWithdraw;
  }

  public void setAmountToWithdraw(BigDecimal amountToWithdraw) {
    this.amountToWithdraw = amountToWithdraw;
  }
}
