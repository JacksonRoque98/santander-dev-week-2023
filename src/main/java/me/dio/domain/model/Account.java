package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {
    @Id
    //Gerar um numero ID unico para este campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Tabela com numero de conta único
    @Column(unique = true)
    private String number;
    private String agency;

    //precision 11 numeros inteiros e scale 2 decimais
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    //precision 11 numeros inteiros e scale 2 decimais
    @Column(name = "additional_limit", precision = 11, scale = 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
