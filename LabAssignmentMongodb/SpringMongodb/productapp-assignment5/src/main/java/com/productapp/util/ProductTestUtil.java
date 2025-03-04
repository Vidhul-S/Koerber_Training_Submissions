package com.productapp.util;

import com.productapp.repo.Product;
import com.productapp.service.ProductServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductTestUtil {

    @Autowired
    private ProductServiceImpl productService;

    @PostConstruct
    public void test() {
        System.out.println("Testing MongoTemplate operations...");

        // Insert Sample Data
        Product p1 = new Product("Laptop", 10, "Dell", 50000.0);
        Product p2 = new Product("Mouse", 50, "Logitech", 1000.0);
        Product p3 = new Product("Keyboard", 30, "HP", 2000.0);
        productService.insertAll(Arrays.asList(p1, p2, p3));

        // Get All Products
        List<Product> allProducts = productService.getAll();
        System.out.println("All Products: " + allProducts);

        // Get by Vendor
        List<Product> byVendor = productService.getProductsByVendor("Dell");
        System.out.println("Products by Vendor: " + byVendor);

        // Update Multi
        productService.updateMulti();
        System.out.println("Updated multiple products");

        // Upsert
        productService.upsertProduct();
        System.out.println("Upsert operation performed");

        // Find and Remove
        productService.findAndRemove();
        System.out.println("Removed specific product");

        // Find All and Remove
        productService.findAllAndRemove();
        System.out.println("Removed multiple products");

        System.out.println("MongoTemplate testing completed!");
    }
}
