package lesson4.animals.organism.stomach;


import lesson4.animals.Food;

public interface IStomach {
    void tryDigestFood(Food food, int count);

    void connectToStomach(IStomachObserver observer);

    void disconnectFromStomach(IStomachObserver observer);

    void notifyConnected();
}
