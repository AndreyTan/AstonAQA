package lesson4;

import lesson4.animals.*;
import lesson4.animals.behaviors.*;
import lesson4.geometry.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Дикси", new Glutton(50,15),new Runner(200),new NonSwimmer());
        Cat[] cats = new Cat[3];

        for(int i = 0; i < cats.length; i++){
            cats[i] = new Cat("Кот " + (i + 1), new Glutton(25 + i * 10,5 + 5 * i),new Runner(200),new NonSwimmer());
        }

        Dog dog = new Dog("Джек", new Anorexia(),new Runner(500),new Swimmer(10));
        Food catfood = new Food(80);
        Food catFoodPremium = new Food(100);
        Dish flat = new Dish();

        cat.run(200);
        dog.run(500);

        cat.swim(10);
        dog.swim(10);

        cat.eat(flat.getFood(),15);
        cat.eat(flat.getFood(),25);
        flat.addFood(catfood);
        cat.eat(flat.getFood(),10);
        cat.eat(flat.getFood(),30);
        cat.eat(flat.getFood(),40);
        cat.eat(flat.getFood(),30);
        dog.eat(flat.getFood(),10);
        cat.eat(flat.getFood(),30);
        flat.addFood(catFoodPremium);

        for(int i = 0; i < 3; i++){
            for(Cat cit : cats){
                cit.eat(flat.getFood(),15);
            }
        }

        /*-------------------------------*/
        System.out.println("\nЗадание 2 -------------------------\n");
        Circle cirle = new Circle(2,"Red","White");
        Rectangle rect = new Rectangle(10,15,"Blue","Green");
        Triangle triangle = new Triangle(3,5,7,"White","Black");

        cirle.showInfo();
        rect.showInfo();
        triangle.showInfo();

    }
}