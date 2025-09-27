package lesson4.animals;

public class Dish {
    private Food _food;

    public Dish() {
    }

    public Dish(Food food) {
        this._food = food;
    }

    public void addFood(Food food) {
        if (food == null) return;

        if (this._food == null)
            this._food = food;
        else
            this._food = new Food(this._food.getCountFood() + food.getCountFood());
    }

    public Food getFood() {
        return this._food;
    }

}
