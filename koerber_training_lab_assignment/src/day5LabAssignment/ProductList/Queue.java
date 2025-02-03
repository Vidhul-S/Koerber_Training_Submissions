package day5LabAssignment.ProductList;

import java.util.PriorityQueue;

public class Queue extends Product{

    public static void main(String[] args) {

        PriorityQueue <Product> products = new PriorityQueue<>(new CompareProducts());
        products.offer(new Product(101, "Laptop", 1500.50));
        products.offer(new Product(102, "Smartphone", 800.75));
        products.offer(new Product(103, "Tablet", 600.25));
        products.offer(new Product(104, "Smartwatch", 250.00));
        System.out.println("Products sorted by price:");
        while (!products.isEmpty()) {
            System.out.println(products.poll());
        }
    }
}
