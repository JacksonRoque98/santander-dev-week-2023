package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_card")
public class Card {
    @Id
    //Gerar um numero ID unico para este campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Numero de cartão unico
    @Column(unique = true)
    private String number;

    //precision 11 numeros inteiros e scale 2 decimais
    @Column(name = "additional_limit", precision = 13, scale = 2)
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
