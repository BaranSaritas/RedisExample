package com.RedisExample.RedisExample.Service.impl;

import com.RedisExample.RedisExample.Repository.ProductRepository;
import com.RedisExample.RedisExample.Service.ProductService;
import com.RedisExample.RedisExample.Service.Redis.RedisService;
import com.RedisExample.RedisExample.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final RedisService redisService;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) redisService.getValue("allProducts");
        if (products == null) {
            products = repository.getAllProducts();
            redisService.setValue("allProducts", products, 10, TimeUnit.MINUTES);
        }
        return products;
    }
    @Override
    public Product getProduct(String productName) {

        return repository.getProductByName(productName);
    }

    @Override
    public Product saveProduct(Product product) {

        Product newProduct = repository.save(product);
        redisService.setValue("product_" + newProduct.getId(), newProduct, 10, TimeUnit.MINUTES);
        redisService.deleteValue("allProducts");
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
        redisService.deleteValue("product_" + id);
        redisService.deleteValue("allProducts");
    }
}
