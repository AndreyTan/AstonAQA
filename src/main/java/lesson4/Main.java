package lesson4;

import lesson4.animals.*;
import lesson4.animals.organism.*;
import lesson4.geometry.*;

public class Main {
    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        DogFactory dogFactory = new DogFactory();

        Animal cat = catFactory.createAnimal("Дикси");

        Animal[] cats = new Cat[3];


        for (int i = 0; i < cats.length; i++) {
            cats[i] = catFactory.createRandomAnimal("Кот " + (i + 1));
        }

        Animal dog = dogFactory.createAnimal("Джек");
        Food catfood = new Food(110);
        Food catFoodPremium = new Food(1000);
        Dish flat = new Dish();

        cat.eat(flat.getFood(), 15);
        cat.eat(flat.getFood(), 25);
        flat.addFood(catfood);
        cat.eat(flat.getFood(), 10);
        cat.eat(flat.getFood(), 30);
        cat.eat(flat.getFood(), 40);
        cat.eat(flat.getFood(), 30);
        dog.eat(flat.getFood(), 10);
        cat.eat(flat.getFood(), 30);
        flat.addFood(catFoodPremium);
        dog.eat(flat.getFood(), 100);
        cat.run(200);
        dog.run(500);
        cat.swim(10);
        dog.swim(10);

        for (int i = 0; i < 3; i++) {
            for (Animal cit : cats) {
                cit.eat(flat.getFood(), 15);
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Всего создано животных: " + Animal.getCountAnimals());
        System.out.println("Всего создано котов: " + Cat.getCountCats());
        System.out.println("Всего создано собак: " + Dog.getCountDogs());
        /*-------------------------------*/
        System.out.println("\nЗадание 2 -------------------------\n");
        Circle cirle = new Circle(2, "Red", "White");
        Rectangle rect = new Rectangle(10, 15, "Blue", "Green");
        Triangle triangle = new Triangle(3, 5, 7, "White", "Orange");

        cirle.showInfo();
        rect.showInfo();
        triangle.showInfo();

    }
}