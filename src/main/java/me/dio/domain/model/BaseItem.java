package me.dio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//Classe com atributos e metodos que irão ser utilizados por 2 classes.
//Definimos como classe abstract e extendemos para as classes que usarão seus atributos
@MappedSuperclass
public abstract class BaseItem {
    @Id
    //Gerar um numero ID unico para este campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return icon;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
