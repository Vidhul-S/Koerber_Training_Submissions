package com.productStore.products.service;

import com.productStore.products.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface ProdServ {
    public List<Product> getListOfAllProducts();
    public List<Product> getAllProductBasedOnName(String name);
    public List<Product> getAllProductBasedOnNameOrPrice(String name, BigDecimal price);
    public List<Product> getAllProductBasedOnNameAndPrice(String name, BigDecimal price);

    public List<Product> getAllProductSorted(String field);
    public Page<Product> getAllProductPage(int offset, int pageSize);
    public Page<Product> getAllProductPageSorted(String field,int offset, int pageSize);
}
