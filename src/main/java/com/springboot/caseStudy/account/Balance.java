package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_seq")
    private Integer user_id;
    @Column(length = 20, nullable=false)
    private Integer bakiye;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Balance(Integer bakiye) {
        this.bakiye = bakiye;
    }

    public Balance() {

    }


    public Integer getUser_id() {
        return user_id;
    }

    public Balance setUser_id(Integer user_id) {
        this.user_id = user_id;
        return null;
    }

    public Integer getBakiye() {
        return bakiye;
    }

    public void setBakiye(Integer bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "user_id=" + user_id +
                ", bakiye=" + bakiye +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return Objects.equals(user_id, balance.user_id);
    }

    @Override
    public int hashCode() {
        return user_id != null ? user_id.hashCode() : 0;
    }

}
