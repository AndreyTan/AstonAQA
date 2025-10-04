package lesson4.animals;

public class FlatFood {
    protected int countFood;

    public FlatFood(int countFood) {
        this.countFood = Math.abs(countFood);
    }

    public void fill(int countFood) {
        this.countFood += Math.abs(countFood);
        System.out.printf("добавили в миску %d еды. Еды теперь %d\n", countFood, this.countFood);
    }

    public boolean tryToEat(int countFood) {
        if (this.countFood >= countFood && this.countFood > 3) {
            this.countFood -= countFood;
            return true;
        } else {
            return false;
        }
    }

}
