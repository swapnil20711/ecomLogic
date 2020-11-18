package models;

public class Product {
    public String name;
    public int pricePerKg;

    public Product(String name, int pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public Product(String name) {
        this.name = name;
    }
}
