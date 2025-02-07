//package com.productStore.products.util;
//
//import com.productStore.products.entities.Product;
//import com.productStore.products.repository.ProdRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.IntStream;
//
//@AllArgsConstructor
//@Component
//public class Initializer implements CommandLineRunner {
//    private final ProdRepo prodRepo;
//
//    public void run(String... args) throws Exception {
//
//            List<Product> products= IntStream.rangeClosed(1, 4000)
//					.mapToObj(i->
//							new Product("product "+i, BigDecimal.valueOf(new Random().nextDouble(5000))))
//					.toList();
//
//            prodRepo.saveAll(products);
//
//        }
//}
