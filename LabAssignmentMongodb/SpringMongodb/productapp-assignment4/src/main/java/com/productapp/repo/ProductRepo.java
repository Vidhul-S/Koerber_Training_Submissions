package com.productapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{id :?0}") // Select * from Product where id=?
    Optional<Product> getProdcutById(Integer id);

    @Query("{qty : {$lt: ?0}}") // SELECT * FROM Product where qty<?
    List<Product> getProductsByQtyLessThan(Integer qty);

    @Query("{ qty : { $gte: ?0 } }") // SELECT * FROM Product where qty>=?
    List<Product> getProductdByPagesGreaterThanEqual(Integer qty);

    @Query("{ qty : ?0 }") // SELECT * FROM Product where qty=?
    List<Product> getProductsByQty(Integer qty);

    @Query("{vendor : ?0}") // SELECT * FROM Product where vendor = ?
    List<Product> getProductsByVendor(String vendor);

    @Query("{vendor: ?0, cost: ?1}") // SELECT * FROM Product where vendor = ? and cost=?
    List<Product> getProductsByVendorAndCost(String vendor, Double cost);

    @Query("{$or :[{vendor: ?0},{name: ?1}]}") // SELECT * FROM Product where vendor=? or name=?
    List<Product> getProductsByVendorOrName(String vendor, String name);

    @Query(value = "{vendor: ?0}", count = true) // SELECT count(*) FROM Product where vendor=?
    Integer getProductsCountByVendor(String vendor);

    @Query(value = "{vendor:?0}", sort = "{name:1}") // Sorting by name ASC
    List<Product> getProductsByVendorSortByName(String vendor);

    @Query(value = "{qty: ?0}", fields = "{name:1, vendor:1}") // Projection: Only name & vendor
    List<Product> getProductNameAndVendorByQty(Integer qty);

    @Query(value= "{vendor : ?0}") // SELECT * FROM Product where vendor=?
    List<Product> getAllProductByVendor(String vendor);

    @Query("{ vendor : { $regex : ?0 } }") // SELECT * FROM Product where vendor like ?
    List<Product> getProductsByVendorRegEx(String vendor);
}
