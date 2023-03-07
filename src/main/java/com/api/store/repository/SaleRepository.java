package com.api.store.repository;

import com.api.store.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    //@Query("INSERT INTO sale_products (s_id, p_id)")
    //public void addProduct(@Param("s_id") Long sale_id,@Param("p_id")Long product_id);
}
