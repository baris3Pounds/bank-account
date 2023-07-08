package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Account {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
  private Integer userId;
  @Column(length = 20, nullable = false)
  private String name;
  @Column(length = 20, nullable = false)
  private String surname;
  @Column(length = 11)
  private String telephone;
  @Column
  private String email;

  @Column
  @Enumerated(EnumType.STRING)
  private CurrencyType currencyType;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "balance_id", referencedColumnName = "id")
  private Balance balance;

  public Balance getBalance() {
    return balance;
  }

  public void setBalance(Balance balance) {
    this.balance = balance;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Account(String name, String surname, String telephone, String email, CurrencyType currencyType) {
    this.name = name;
    this.surname = surname;
    this.telephone = telephone;
    this.email = email;
    this.currencyType = currencyType;
  }

  public Account() {

  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = this.userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public CurrencyType getCurrencyType() {
    return currencyType;
  }

  public void setCurrencyType(CurrencyType currencyType) {
    this.currencyType = currencyType;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + userId +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", telephone='" + telephone + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }

    Account account = (Account) o;

    return Objects.equals(userId, account.userId);
  }

  @Override
  public int hashCode() {
    return userId != null ? userId.hashCode() : 0;
  }

}
