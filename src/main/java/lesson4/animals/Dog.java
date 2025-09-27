package lesson4.animals;

import lesson4.animals.organism.*;

public class Dog extends Animal {
    private static int _countDogs;

    public Dog(String name, IOrganismFactory organism) {
        super(name, organism);
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
