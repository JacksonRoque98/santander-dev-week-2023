package me.dio.domain.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tb_user")
public class User {
    //Coluna Id na tabela User
    @Id
    //Gerar um numero ID unico para este campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //1 para 1, e o cascade Corresponde a todas as operações (MERGE, PERSIST, REFRESH e REMOVE).
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    //1 para 1, e o cascade Corresponde a todas as operações (MERGE, PERSIST, REFRESH e REMOVE).
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    //1 para muitos, fetch.Eager quando for buscar o usuario no banco, irá retornar todas as features dele.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    //1 para muitos, fetch.Eager quando for buscar o usuario no banco, irá retornar todas as news dele.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public List<Feature> getFeatures() {
        return features;
    }
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
    public List<News> getNews() {
        return news;
    }
    public void setNews(List<News> news) {
        this.news = news;
    }
}
