package com.productStore.products.service;

import com.productStore.products.entities.Product;
import com.productStore.products.repository.ProdRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class ProdServImpl implements ProdServ {

    private final ProdRepo prodRepo;
    @Override
    public List<Product> getListOfAllProducts() {
        return prodRepo.getListOfAllProducts();
    }

    @Override
    public List<Product> getAllProductBasedOnName(String name) {
        return prodRepo.getListOfAllProductsBasedOnName(name);
    }

    @Override
    public List<Product> getAllProductBasedOnNameOrPrice(String name, BigDecimal price) {
        return prodRepo.getListOfAllProductsBasedOnNameOrPrice(name, price);
    }

    @Override
    public List<Product> getAllProductBasedOnNameAndPrice(String name, BigDecimal price) {
        return prodRepo.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }

    @Override
    public List<Product> getAllProductSorted(String field) {
        return prodRepo.findAll(Sort.by(field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return prodRepo.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return prodRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }
}
