package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;

    private Customer customer;

    public Order(List<Product> products, Customer customer) {
        Random rand = new Random();
        this.id = rand.nextLong();
        this.status = "ordered";
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusDays(5);
        this.products = products;
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }


}
