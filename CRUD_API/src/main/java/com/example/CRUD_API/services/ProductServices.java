package com.example.CRUD_API.services;

import com.example.CRUD_API.entity.Product;
import com.example.CRUD_API.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServices {
    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productRepo.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    public Optional<Product> getProductById(int id){
        return productRepo.findById(id);
    }
    public Optional<Product> getProductByName(String name){
        return productRepo.findByName(name);
    }

    public String deleteProduct(int id){
        productRepo.findById(id);
        return "product deleted"+id;
    }

    public Product updateProduct(Product product){
        Product exsistingProduct=productRepo.findById(product.getId()).orElse(null);
        exsistingProduct.setName(product.getName());
        exsistingProduct.setPrice(product.getPrice());
        exsistingProduct.setQuantity(product.getQuantity());
        return  productRepo.save(exsistingProduct);
    }
}
