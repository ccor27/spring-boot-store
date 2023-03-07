package com.api.store.model;

import javax.persistence.*;
import java.util.Set;

/**
 * to create a record, is needed to use of products from customer's sales
 */
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "record",cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(cascade = CascadeType.REFRESH)
    private Set<Sale> saleSet;

    public Record(){}
    public Record(Customer customer,Set<Sale> saleSet){
        this.customer=customer;
        this.saleSet=saleSet;
    }
    public Record(Set<Sale> saleSet){
        this.saleSet=saleSet;
    }

    public void addSale(Sale sale){
        this.saleSet.add(sale);
    }
    public void removeSale(Sale sale){
        this.saleSet.remove(sale);
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Sale> getSaleSet() {
        return saleSet;
    }

    public void setSaleSet(Set<Sale> saleSet) {
        this.saleSet = saleSet;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", customer=" + customer +
                ", saleSet=" + saleSet +
                '}';
    }
}
