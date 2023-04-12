package com.api.store.repository;

import com.api.store.model.ProductSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSoldRepository extends JpaRepository<ProductSold,Long> {
    ProductSold findByBarCode(String barCode);
}
