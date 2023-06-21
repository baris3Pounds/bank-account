package com.springboot.caseStudy.account;

public class AccountNotFoundException extends Throwable {

  public AccountNotFoundException(String message) {
    super(message);
  }
}
