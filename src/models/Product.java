package models;

import java.util.ArrayList;

public class Product {
    public String name;
    public int pricePerKg;
    public ArrayList<Variant>variants=new ArrayList<>();

    public Product(String name, int pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public Product(String name) {
        this.name = name;
    }
}
