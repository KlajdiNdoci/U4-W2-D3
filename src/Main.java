import entities.Customer;
import entities.Order;
import entities.Product;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            productList.add(new Product("LordOfTheRings", "Books"));
        }
        for (int i = 0; i < 5; i++) {
            productList.add(new Product("Biberon", "Baby"));
        }
        for (int i = 0; i < 5; i++) {
            productList.add(new Product("Skateboard", "Boys"));
        }

//        bookList.forEach(i -> System.out.println(i));
//        productList.forEach(System.out::println);
        System.out.println(" ");
        System.out.println("**************************EXERCISE 1***********************************");
        System.out.println(" ");

        List<Product> expensiveBooks = productList.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();

        expensiveBooks.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("**************************EXERCISE 2***********************************");
        System.out.println(" ");

        List<Order> orders = new ArrayList<>();
        Customer aldo = new Customer("aldo");
        orders.add(new Order(productList, aldo));


        List<Product> filteredProducts = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Baby"))
                .toList();

        filteredProducts.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("**************************EXERCISE 3***********************************");
        System.out.println(" ");

        System.out.println("DISCOUNTED PRODUCTS");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        List<Product> boysProducts = productList.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    double originalPrice = product.getPrice();
                    double discountedPrice = originalPrice * 0.9;
                    String formattedPrice = decimalFormat.format(discountedPrice).replace(',', '.');
                    product.setPrice(Double.parseDouble(formattedPrice));
                    return product;
                })
                .toList();
        boysProducts.forEach(System.out::println);
        System.out.println(" ");
        System.out.println("**************************EXERCISE 4***********************************");
        System.out.println(" ");

        Customer giovanni = new Customer("giovanni");
        Customer giacomo = new Customer("giacomo");
        Customer ajeje = new Customer("ajeje");


        orders.add(new Order(boysProducts, giovanni));
        orders.add(new Order(boysProducts, giovanni));
        orders.add(new Order(boysProducts, giovanni));
        orders.add(new Order(boysProducts, giacomo));
        orders.add(new Order(boysProducts, giacomo));
        orders.add(new Order(boysProducts, giacomo));
        orders.add(new Order(boysProducts, ajeje));
        orders.add(new Order(boysProducts, ajeje));
        orders.add(new Order(boysProducts, ajeje));


        System.out.println(aldo);
        System.out.println(giovanni);
        System.out.println(giacomo);
        System.out.println(ajeje);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Order> filteredOrdersByTierAndDate = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> {
                    LocalDate orderDate = order.getOrderDate();
                    return orderDate.isAfter(startDate) && orderDate.isBefore(endDate);
                })
                .toList();

        System.out.println(" ");
        System.out.println("FILTERED ORDERS");
        System.out.println(" ");

        filteredOrdersByTierAndDate.forEach(System.out::println);

        List<Product> filteredList = filteredOrdersByTierAndDate.stream().flatMap(order -> order.getProducts().stream()).toList();

        System.out.println(" ");
        System.out.println("FILTERED LIST");
        System.out.println(" ");

        filteredList.forEach(System.out::println);


    }
}