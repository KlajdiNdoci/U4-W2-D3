package entities;

import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(long id, String name, int tier) {
        Random rand = new Random();
        this.id = rand.nextLong();
        this.name = name;
        this.tier = tier;
    }
}
