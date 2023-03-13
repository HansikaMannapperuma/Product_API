package com.example.CRUD_API.controller;

import com.example.CRUD_API.entity.Product;
import com.example.CRUD_API.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productServices.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productServices.saveProducts(products);
    }

    @GetMapping("getAllProducts")
    public List<Product> getAllProducts(){
        return productServices.getProducts();
    }
    @GetMapping("getProductById/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return productServices.getProductById(id);
    }
    @GetMapping("getProductByName/{name}")
    public Optional<Product> getProduct(@PathVariable String name){
        return productServices.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productServices.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productServices.deleteProduct(id);
    }

}
