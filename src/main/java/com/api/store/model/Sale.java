package com.api.store.model;

import com.sun.istack.NotNull;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String concept;
    @Temporal(TemporalType.DATE)
    private Date created_at;
    private Double price=0.0;
    @ManyToMany
    @Column(unique = false,nullable = false)
    @JoinTable(name = "sale_products")
    private Set<Product> products;
    public Sale(){}

    public Sale(String concept,  Set<Product> products) {
        this.concept = concept;
        this.products = products;
        knowPrice();
    }

    @PrePersist  void onPrePersist() {
        created_at = new java.util.Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
   // @PrePersist
    public void knowPrice(){

        if(this.products!=null){

            this.products.stream().forEach(product -> {
                this.price+=product.getPrice()*product.getAmount();
            });

        }
        System.out.println("no tiene productos");
    }
    public Double getPrice() {
        knowPrice();
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

     public void addProduct(Product product){
        this.products.add(product);
    }
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", created_at=" + created_at +
                ", price=" + price +
                ", products=" + products +
                '}';
    }
}
