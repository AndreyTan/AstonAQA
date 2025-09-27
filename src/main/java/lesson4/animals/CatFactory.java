package lesson4.animals;

import lesson4.animals.organism.CatOrganism;
import lesson4.animals.organism.RandomOrganism;

public class CatFactory extends AnimalFactory {

    public CatFactory() {
        _organism = new CatOrganism();
    }

    @Override
    public Animal createAnimal(String name) {
        return new Cat(name, _organism);
    }

    @Override
    public Animal createRandomAnimal(String name) {
        return new Cat(name, new RandomOrganism());
    }

}
