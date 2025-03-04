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
    private ProductServiceImpl productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return productService.getById(id);
    }

    @GetMapping("/vendor/{vendor}")
    public List<Product> getByVendor(@PathVariable String vendor) {
        return productService.getProductsByVendor(vendor);
    }

    @GetMapping("/qty/{qty}")
    public List<Product> getByQty(@PathVariable int qty) {
        return productService.getProductsByQtyGreaterThan(qty);
    }
}

