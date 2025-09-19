package lesson4.animals;


import lesson4.animals.behaviors.*;

public class Cat extends Animal{
    private static int _countCats;

    public Cat(String name, IEatBehavior eatBehavior, IRunBehavior runBehavior, ISwimBehavior swimBehavior){
        super(name, eatBehavior, runBehavior, swimBehavior);
        _countCats++;
    }

    @Override
    public String getNameActor() {
        if(!_nameActor.isBlank())
            return _nameActor;
        return "Кот";
    }
}
