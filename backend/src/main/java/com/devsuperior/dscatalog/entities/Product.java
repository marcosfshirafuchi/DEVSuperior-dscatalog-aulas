package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//Nome do banco de dados
@Table(name = "tb_product")
public class Product implements Serializable {
    @Id
    //Vai autoincrementar no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //O banco de dados vai mapear a coluna como text(Vai aceitar texto mais longo)
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;

    //Armazene a sua data no UTC
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;

    @ManyToMany
    //tabela que faz associação entre duas entidades(Product e Category)
    @JoinTable(name = "tb_product_category",
        //Vai ser a chave estrangeira do id do Product
            //Vai pegar o id da classe Product
        joinColumns = @JoinColumn(name = "product_id"),
            //A outra chave estrangeira do id do Category
            //O inverseJoinColumns vai pegar o id do Category do set
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    //Set aplica o conceito de conjunto ou seja não aceita repetições
    Set<Category> categories = new HashSet<>();
    public Product(){

    }

    public Product(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
