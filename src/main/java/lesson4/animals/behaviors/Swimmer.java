package lesson4.animals.behaviors;

public class Swimmer implements ISwimBehavior{
    private int _maxDistance;

    public Swimmer(int maxDistance){
        this._maxDistance = maxDistance;
    }

    @Override
    public void TryToSwim(int distance) {
        if(distance > _maxDistance)
            System.out.println("Не может столько проплыть");
        else
            System.out.printf("Плывём %d метров...\n",distance);
    }
}
