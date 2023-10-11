import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Product("LordOfTheRings", "Books"));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new Product("Biberon", "Baby"));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new Product("LordOfTheRings", "Boys"));
        }

//        bookList.forEach(i -> System.out.println(i));
        list.forEach(System.out::println);

        System.out.println("**************************EXERCISE 1***********************************");

        List<Product> expensiveBooks = list.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();

        expensiveBooks.forEach(System.out::println);
    }
}