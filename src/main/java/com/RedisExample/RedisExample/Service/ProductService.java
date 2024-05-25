package com.RedisExample.RedisExample.Service;

import com.RedisExample.RedisExample.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(String productName);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
