package lesson4.animals.behaviors;


import lesson4.animals.Food;

public class Anorexia implements IEatBehavior{
    @Override
    public void TryToEat(Food food, int count) {
        System.out.println("no eat!");
    }
}
