package lesson4.animals;


import lesson4.animals.organism.*;

public class Cat extends Animal {
    private static int _countCats;

    public Cat(String name, IOrganismFactory organism) {
        super(name, organism);
        _countCats++;
    }

    @Override
    public String getNameActor() {
        if (!_nameActor.isBlank())
            return _nameActor;
        return "Кот";
    }

    public static int getCountCats() {
        return _countCats;
    }
}
