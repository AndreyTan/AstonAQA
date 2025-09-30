package lesson3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("bus", LocalDate.of(2025, 9, 10), "Vietnam", 4000000, false);
        products[1] = new Product("Iphone", LocalDate.of(2022, 11, 12), "USA", 5600, false);
        products[2] = new Product("race car", LocalDate.of(2021, 3, 23), "Poland", 33000000, true);
        products[3] = new Product("loader", LocalDate.of(2023, 2, 4), "China", 170000, false);
        products[4] = new Product("winter car", LocalDate.of(2020, 6, 17), "Indonesia", 96600, true);

        for (Product product : products) {
            product.printInfo();
            System.out.println("---------");
        }
        System.out.println("\n             парки       \n");
        Park funnyPark = new Park("funny park");
        funnyPark.buildNewAttraction("Clowns", "A very fun attraction 100% safety", 50, LocalTime.of(9, 0), LocalTime.of(18, 0));
        funnyPark.buildNewAttraction("Booo", "Absolute non scary", 150, LocalTime.of(10, 0), LocalTime.of(23, 0));
        funnyPark.buildNewAttraction("Yayoo", "Awesome fun time", 100, LocalTime.of(9, 30), LocalTime.of(17, 0));

        funnyPark.introducePark();

    }

}