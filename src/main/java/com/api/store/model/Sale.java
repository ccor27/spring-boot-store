package com.api.store.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String concept;
    @Temporal(TemporalType.DATE)
    private Date created_at;
    private Double price;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Customer customer;
    @OneToMany
    private Set<Product> products;
    public Sale(){}

    public Sale(String concept, Customer customer, Set<Product> products) {
        this.concept = concept;
        this.customer = customer;
        this.products = products;
        this.price=0.0;
        onPrePersist();
    }

    @PrePersist  void onPrePersist() {created_at = new java.util.Date();}

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
    //@PrePersist
    public Double getPrice() {
     if(this.products==null)
         return 0.0;

        this.products.stream().forEach(product -> {
            this.price+=product.getPrice()*product.getAmount();
        });
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", created_at=" + created_at +
                ", price=" + price +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
