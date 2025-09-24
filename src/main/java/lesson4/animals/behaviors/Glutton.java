package lesson4.animals.behaviors;


import lesson4.animals.Food;

public class Glutton implements IEatBehavior {
    private int _hunger;
    private int _maxHunger;
    private int _harmfulness;

    public Glutton(int maxHunger, int harmfulness) {
        this._hunger = 0;
        this._maxHunger = Math.abs(maxHunger) == 0 ? 100 : Math.abs(maxHunger);
        this._harmfulness = Math.abs(harmfulness);

        if (_harmfulness > _maxHunger) {
            _harmfulness = _maxHunger;
        }
    }

    @Override
    public void TryToEat(Food food, int count) {
        if (food == null) {
            System.out.println("обман! это не еда..");
            return;
        }

        if (count >= _harmfulness) {
            int countFood = food.pickUpSomeFood(count);
            if (countFood > 0) {
                if (countFood + _hunger <= _maxHunger) {
                    _hunger += countFood;
                    System.out.printf("Съели %d еды. ", countFood);
                    System.out.printf(" уровень насыщения: %d/%d\n", _hunger, _maxHunger);
                } else {
                    if (_hunger < _maxHunger) {
                        int possibleToEat = _maxHunger - _hunger;
                        _hunger = _maxHunger;
                        System.out.printf("Этого слишком много. съел только %d еды. %d еды выбросил.", possibleToEat, (countFood - possibleToEat));
                        System.out.printf(" уровень насыщения: %d/%d\n", _hunger, _maxHunger);
                    } else {
                        System.out.printf("Наелся! %d выбросил\n", countFood);
                    }

                }

            } else {
                System.out.println("Ничего нет, ничего не съел");
            }
        } else {
            System.out.println("Этого слишком мало..");
        }
    }


}
