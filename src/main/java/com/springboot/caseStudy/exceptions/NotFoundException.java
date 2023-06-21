package com.springboot.caseStudy.exceptions;

public class NotFoundException extends RuntimeException{
  public NotFoundException(String message){
    super(message);
  }
}
