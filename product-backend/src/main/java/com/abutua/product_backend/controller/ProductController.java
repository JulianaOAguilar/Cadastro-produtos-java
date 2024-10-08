package com.abutua.product_backend.controller;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.product_backend.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductController {
  

  private List<Product> products = new ArrayList<>();

  @PostConstruct
  public void init(){
   
    Product p1 = new Product();
    p1.setId(1);
    p1.setName("Procuct01");
    p1.setPrice(100.50);

    Product p2 = new Product();
    p2.setId(2);
    p2.setName("Procuct02");
    p2.setPrice(200.50);

    Product p3 = new Product();
    p3.setId(3);
    p3.setName("Procuct03");
    p3.setPrice(300.50);

    
    products.add(p1);
    products.add(p2);
    products.add(p3);

  }

@GetMapping("products/{id}")
public ResponseEntity<Product> getProduct(@PathVariable int id) {
  Product prod = products.stream()
      .filter(p -> p.getId() == id)
      .findFirst()
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));

return ResponseEntity.ok(prod);

}

  @GetMapping("products")
  public List<Product> getProducts() {
    return products;
  }


}

