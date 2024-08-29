package com.OptimisticLocking.OptimisticLock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/urlWorking")
    public String UrlWorking() {
        return "URL Working";
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product  saved = productService.saveProduct(product);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/productId")
    public ResponseEntity<Product> updateProduct(@PathVariable long productId, Product product) {
        Product updateItem = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updateItem);

    }
}
