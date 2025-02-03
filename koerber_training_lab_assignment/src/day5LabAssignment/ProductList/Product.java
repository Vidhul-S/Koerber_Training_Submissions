package day5LabAssignment.ProductList;

import java.util.Comparator;

class CompareProducts implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getProductPrice(), o2.getProductPrice());
    }
}
public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    public Product(){}
    public Product(int productID,String productName,double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return (new StringBuilder()
                .append("Product{")
                .append("Product ID = ").append(productID)
                .append(", Product Name = ").append(productName)
                .append(", Product Price = ").append(productPrice)
                .append('}').toString());
    }
}
