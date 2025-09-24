package lesson4.animals;

import lesson4.animals.behaviors.*;

public class Dog extends Animal {
    private static int _countDogs;

    public Dog(String name, IEatBehavior eatBehavior, IRunBehavior runBehavior, ISwimBehavior swimBehavior) {
        super(name, eatBehavior, runBehavior, swimBehavior);
        _countDogs++;
    }

    @Override
    public String getNameActor() {
        if (!_nameActor.isBlank())
            return _nameActor;
        return "Собака";
    }

    public static int getCountDogs() {
        return _countDogs;
    }

}
