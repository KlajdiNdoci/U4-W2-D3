package entities;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(long id, String name, String category, double price) {
        Random rand = new Random();
        this.id = rand.nextLong();
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
