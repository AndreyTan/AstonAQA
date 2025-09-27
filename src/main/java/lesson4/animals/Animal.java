package lesson4.animals;

import lesson4.animals.organism.*;
import lesson4.animals.organism.musculoskeletalSystem.IMusculoskeletalSystem;
import lesson4.animals.organism.stomach.IStomach;
import lesson4.animals.organism.stomach.IStomachObserver;

import java.util.Objects;

public abstract class Animal {
    private static int _countAnimals = 0;
    private IMusculoskeletalSystem _musculoskeletalSystem;
    private IStomach _stomach;
    protected String _nameActor;

    public Animal(String titleActor, IOrganismFactory organism) {
        Animal._countAnimals++;
        this._nameActor = Objects.requireNonNullElse(titleActor, "unknown animal");
        this._stomach = organism.createStomach();
        this._musculoskeletalSystem = organism.createMusculoskeletalSystem();
        this._stomach.connectToStomach((IStomachObserver) this._musculoskeletalSystem);
    }

    public void run(int distance) {
        System.out.printf(getNameActor() + ": ");
        _musculoskeletalSystem.tryToRun(distance);
    }

    public void swim(int distance) {
        System.out.printf(getNameActor() + ": ");
        _musculoskeletalSystem.tryToSwim(distance);
    }

    public void eat(Food food, int count) {
        System.out.printf(getNameActor() + ": ");
        _stomach.tryDigestFood(food, count);
    }

    public abstract String getNameActor();

    public static int getCountAnimals() {
        return _countAnimals;
    }


}
