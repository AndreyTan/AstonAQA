package lesson4;


import lesson4.animals.Animal;
import lesson4.animals.Cat;
import lesson4.animals.Dog;
import lesson4.animals.FlatFood;
import lesson4.geometry.Circle;
import lesson4.geometry.Rectangle;
import lesson4.geometry.Triangle;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Луна");
        Dog dog1 = new Dog("Джек");
        System.out.println("\n\tфизкультура\t\n");
        cat1.run(200);
        cat1.run(201);
        cat1.swim(30);

        dog1.run(500);
        dog1.run(501);
        dog1.swim(10);
        dog1.swim(20);
        System.out.println("\n\tкормёжка\t\n");

        FlatFood food = new FlatFood(0);
        food.fill(6);
        food.fill(2);

        cat1.eatFood(food);

        Cat[] cats = new Cat[5];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот " + i);
        }

        for (Cat cat : cats) {
            cat.eatFood(food);
        }
        for (Cat cat : cats) {
            cat.printHungryStatus();
        }

        System.out.println("\n\tитоги\t\n");
        Animal.printCountAnimals();
        Cat.printCountCats();
        Dog.printCountDogs();

        /*-----------------------------------------------------*/

        System.out.println("\n\tФигуры\t\n");
        Circle circle = new Circle(3, "Red", "White");
        Rectangle rect = new Rectangle(10, 15, "Blue", "Green");
        Triangle triangle = new Triangle(3, 5, 7, "White", "Orange");

        circle.printInfo();
        rect.printInfo();
        triangle.printInfo();

    }
}