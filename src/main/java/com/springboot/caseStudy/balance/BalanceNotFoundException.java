package com.springboot.caseStudy.balance;

public class BalanceNotFoundException extends Throwable {
    public BalanceNotFoundException(String message) {
        super(message);
    }
}
