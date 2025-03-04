package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setQty(product.getQty());
            updatedProduct.setVendor(product.getVendor());
            updatedProduct.setCost(product.getCost());
            return productRepo.save(updatedProduct);
        }
        return null; // Could throw an exception instead
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).orElse(null);
    }
}
