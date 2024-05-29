package com.RedisExample.RedisExample.Repository;


import com.RedisExample.RedisExample.model.Product;
import io.lettuce.core.dynamic.annotation.Param;
import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("""
            SELECT p FROM Product p
            """)
    List<Product> getAllProducts();

    @Query("""
            SELECT p FROM Product p WHERE :productName IS NULL OR p.name = :productName
            """)
    Product getProductByName(@Param("productName") String productName);
}
