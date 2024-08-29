package com.OptimisticLocking.OptimisticLock;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

@Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(long productId, Product product) {
        try {
            Product product1 = productRepository.findById(productId).get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            return productRepository.save(product1);
        }catch (Exception e) {
            throw new RuntimeException("Optimistic Locking failed");
        }
    }
}
