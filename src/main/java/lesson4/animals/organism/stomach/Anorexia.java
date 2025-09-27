package lesson4.animals.organism.stomach;


import lesson4.animals.Food;

import java.util.ArrayList;

public class Anorexia implements IStomach {
    private ArrayList<IStomachObserver> _observers;

    public Anorexia() {
        _observers = new ArrayList<>(0);
    }

    @Override
    public void tryDigestFood(Food food, int count) {
        System.out.println("Нельзя есть, желудок не работает!");
    }

    @Override
    public void connectToStomach(IStomachObserver observer) {
        System.out.println("Не присоединяется к желудку, желудок не работает");
    }

    @Override
    public void disconnectFromStomach(IStomachObserver observer) {
        if (observer != null)
            _observers.remove(observer);
    }

    @Override
    public void notifyConnected() {
        for (IStomachObserver observer : _observers) {
            observer.updateNewFood(0);
        }
    }

}
