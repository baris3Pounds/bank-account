package com.springboot.caseStudy.util;


public class GenericResponse<T> {

  private String message;
  private T response;

  public GenericResponse(String message, T response) {
    this.message = message;
    this.response = response;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }
}
