package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceimpl;

    @GetMapping
    public List<Product> getAllProducts() {
        return productServiceimpl.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productServiceimpl.getById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productServiceimpl.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productServiceimpl.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productServiceimpl.delete(id);
    }

    @GetMapping("/query/vendor/{vendor}")
    public List<Product> getProductsByVendor(@PathVariable String vendor) {
        return productServiceimpl.getProductsByVendor(vendor);
    }

    @GetMapping("/query/qty/{qty}")
    public List<Product> getProductsByQty(@PathVariable Integer qty) {
        return productServiceimpl.getProductsByQty(qty);
    }
}

