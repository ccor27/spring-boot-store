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

    @OneToMany
    private Set<Sale> saleSet;

    public Record(){}
    public Record(Set<Sale> saleSet){
        this.saleSet=saleSet;
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
}
