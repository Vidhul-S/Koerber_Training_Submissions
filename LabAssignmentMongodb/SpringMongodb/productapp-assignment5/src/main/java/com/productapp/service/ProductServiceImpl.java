package com.productapp.service;

import com.productapp.repo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> getAll() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product save(Product product) {
        return mongoTemplate.insert(product);
    }

    @Override
    public Product update(String id, Product product) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("name", product.getName())
                .set("qty", product.getQty())
                .set("vendor", product.getVendor())
                .set("cost", product.getCost());
        return mongoTemplate.findAndModify(query, update, Product.class);
    }

    @Override
    public void delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Product.class);
    }

    @Override
    public Product getById(String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    public List<Product> getProductsByVendor(String vendor) {
        Query query = new Query(Criteria.where("vendor").is(vendor));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> getProductsByQtyGreaterThan(int qty) {
        Query query = new Query(Criteria.where("qty").gt(qty));
        return mongoTemplate.find(query, Product.class);
    }

    public void insertAll(List<Product> products) {
        mongoTemplate.insertAll(products);
    }

    public void updateMulti() {
        Query query = new Query(Criteria.where("qty").lte(180));
        Update update = new Update().set("cost", 999.0);
        mongoTemplate.updateMulti(query, update, Product.class);
    }

    public void upsertProduct() {
        Query query = new Query(Criteria.where("id").is("510"));
        Update update = new Update().set("cost", 1065.25).set("name", "Core Java");
        mongoTemplate.upsert(query, update, Product.class);
    }

    public void findAndRemove() {
        Query query = new Query(Criteria.where("cost").is(1749.0));
        mongoTemplate.findAndRemove(query, Product.class);
    }

    public void findAllAndRemove() {
        Query query = new Query(Criteria.where("cost").gte(1000.0));
        mongoTemplate.findAllAndRemove(query, Product.class);
    }
}

