import entities.Customer;
import entities.Order;
import entities.Product;

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
            productList.add(new Product("LordOfTheRings", "Boys"));
        }

//        bookList.forEach(i -> System.out.println(i));
        productList.forEach(System.out::println);

        System.out.println("**************************EXERCISE 1***********************************");

        List<Product> expensiveBooks = productList.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();

        expensiveBooks.forEach(System.out::println);

        System.out.println("**************************EXERCISE 2***********************************");

        List<Order> myOrder = new ArrayList<>();
        Customer aldo = new Customer("aldo");
        myOrder.add(new Order(productList, aldo));


        System.out.println(myOrder);
        List<Product> filteredProducts = myOrder.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Baby"))
                .toList();

        filteredProducts.forEach(System.out::println);


    }
}