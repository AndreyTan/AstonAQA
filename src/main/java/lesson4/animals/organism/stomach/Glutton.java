package lesson4.animals.organism.stomach;

import lesson4.animals.Food;

import java.util.ArrayList;

public class Glutton implements IStomach {
    private ArrayList<IStomachObserver> _observers;
    private int _hunger;
    private int _maxHunger;
    private int _harmfulness;
    private int _justEaten;


    public Glutton(int maxHunger, int harmfulness) {
        _observers = new ArrayList<>(1);
        this._hunger = 0;
        this._maxHunger = Math.abs(maxHunger) == 0 ? 100 : Math.abs(maxHunger);
        this._harmfulness = Math.abs(harmfulness);

        if (_harmfulness > _maxHunger) {
            _harmfulness = _maxHunger;
        }
    }

    @Override
    public void tryDigestFood(Food food, int count) {
        if (food == null) {
            System.out.println("обман! это не еда..");
            return;
        }

        if (count >= _harmfulness) {
            int countFood = food.pickUpSomeFood(count);
            if (countFood > 0) {
                if (countFood + _hunger <= _maxHunger) {
                    _hunger += countFood;
                    _justEaten = countFood;
                    System.out.printf("Съели %d еды. ", _justEaten);
                    System.out.printf(" уровень насыщения: %d/%d\n", _hunger, _maxHunger);
                    notifyConnected();
                    _justEaten = 0;
                } else {
                    if (_hunger < _maxHunger) {
                        int possibleToEat = _maxHunger - _hunger;
                        _hunger = _maxHunger;
                        System.out.printf("Этого слишком много. съел только %d еды. %d еды выбросил.", possibleToEat, (countFood - possibleToEat));
                        System.out.printf(" уровень насыщения: %d/%d\n", _hunger, _maxHunger);
                        notifyConnected();
                        _justEaten = 0;
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

    @Override
    public void connectToStomach(IStomachObserver observer) {
        if (observer != null) {
            _observers.add(observer);
        }
    }

    @Override
    public void disconnectFromStomach(IStomachObserver observer) {
        if (observer != null) {
            _observers.remove(observer);
        }
    }

    @Override
    public void notifyConnected() {
        for (IStomachObserver observer : _observers) {
            observer.updateNewFood(_justEaten);
        }
    }

}
