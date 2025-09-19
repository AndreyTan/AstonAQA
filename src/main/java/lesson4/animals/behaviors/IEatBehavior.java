package lesson4.animals.behaviors;


import lesson4.animals.Food;

public interface IEatBehavior {
    public void TryToEat(Food food, int count);
}
