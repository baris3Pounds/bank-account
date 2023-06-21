package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Account {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
  private Integer user_id;
  @Column(length = 20, nullable = false)
  private String name;
  @Column(length = 20, nullable = false)
  private String surname;
  @Column(length = 11)
  private String telephone;
  @Column
  private String email;


  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
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

  public Account(String name, String surname, String telephone, String email) {
    this.name = name;
    this.surname = surname;
    this.telephone = telephone;
    this.email = email;
  }

  public Account() {

  }

  public Integer getUserId() {
    return user_id;
  }

  public void setUserId(Integer userId) {
    this.user_id = user_id;
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

  @Override
  public String toString() {
    return "Account{" +
        "id=" + user_id +
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

    return Objects.equals(user_id, account.user_id);
  }

  @Override
  public int hashCode() {
    return user_id != null ? user_id.hashCode() : 0;
  }

}
