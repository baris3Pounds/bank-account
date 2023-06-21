package com.springboot.caseStudy.exceptions;

public class InsufficientFundsException extends RuntimeException {
  public InsufficientFundsException(String message){
    super(message);
  }
}
