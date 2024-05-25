package com.RedisExample.RedisExample.Controller;

import com.RedisExample.RedisExample.Service.ProductService;
import com.RedisExample.RedisExample.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        return  ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Product> getProduct(@RequestParam("productName") String productName){
       return ResponseEntity.ok(service.getProduct(productName));
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
