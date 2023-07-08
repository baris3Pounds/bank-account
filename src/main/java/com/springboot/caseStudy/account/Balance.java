package com.springboot.caseStudy.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_seq")
    private Integer id;
    @Column(length = 20, nullable=false)
    private BigDecimal bakiye;


    public Balance(BigDecimal bakiye) {
        this.bakiye = bakiye;
    }

    public Balance() {

    }


    public Integer getUser_id() {
        return id;
    }

    public Balance setUser_id(Integer id) {
        this.id = id;
        return null;
    }

    public BigDecimal getBakiye() {
        return bakiye;
    }

    public void setBakiye(BigDecimal bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "user_id=" + id +
                ", bakiye=" + bakiye +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return Objects.equals(id, balance.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
