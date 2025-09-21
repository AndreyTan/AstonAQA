package lesson4.animals;

import lesson4.animals.behaviors.*;
import java.util.Objects;

public abstract class Animal {
    private static int _countAnimals = 0;
    private IRunBehavior _runBehavior;
    private ISwimBehavior _swimBehavior;
    private IEatBehavior _eatBehavior;
    protected String _nameActor;

    public Animal(String titleActor, IEatBehavior eatBehavior, IRunBehavior runBehavior, ISwimBehavior swimBehavior){
        Animal._countAnimals++;
        this._nameActor = Objects.requireNonNullElse(titleActor,"unknown animal");
        this._eatBehavior = Objects.requireNonNullElse(eatBehavior,new Anorexia());
        this._runBehavior = Objects.requireNonNullElse(runBehavior,new Runner(100));
        this._swimBehavior =  Objects.requireNonNullElse(swimBehavior,new NonSwimmer());
    }

    public void run(int distance){
        System.out.printf(getNameActor() + ": ");
        _runBehavior.TryToRun(distance);
    }

    public void swim(int distance){
        System.out.printf(getNameActor() + ": ");
        _swimBehavior.TryToSwim(distance);
    }

    public void eat(Food food,int count){
        System.out.printf(getNameActor() + ": ");
        _eatBehavior.TryToEat(food,count);
    }

    public abstract String getNameActor();

    public static int getCountAnimals(){
        return _countAnimals;
    }


}
