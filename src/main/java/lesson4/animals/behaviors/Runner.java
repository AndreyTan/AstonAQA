package lesson4.animals.behaviors;

public class Runner implements IRunBehavior{
    private int _maxDistance;

    public Runner(int maxDistance){
        this._maxDistance = maxDistance;
    }
    @Override
    public void TryToRun(int distance) {
        if(distance > _maxDistance)
            System.out.println("Не может столько пробежать");
        else
            System.out.printf("Бежим %d метров...\n",distance);
    }
}
