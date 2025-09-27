package lesson4.animals;

public class Food {
    private int _countFood;

    public Food(int countFood) {
        if (countFood < 0)
            _countFood = -countFood;
        else
            _countFood = countFood;
    }

    public int getCountFood() {
        return _countFood;
    }

    public int pickUpSomeFood(int count) {
        if (count > 0) {
            if (count <= _countFood) {
                _countFood -= count;
                System.out.println("Забрали " + count + " еды, осталось: " + (_countFood) + " еды");
                return count;
            } else if (_countFood > 0) {
                int possiblePickUp = _countFood;
                _countFood = 0;
                System.out.println("Столько еды нет, забрали только " + possiblePickUp + " еды");
                return possiblePickUp;
            } else {
                System.out.println("Еды нет, ничего не взяли..");
                return 0;
            }
        }
        System.out.println("Ничего не взяли..");
        return 0;
    }
}
