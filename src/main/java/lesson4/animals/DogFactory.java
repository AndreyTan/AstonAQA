package lesson4.animals;

import lesson4.animals.organism.DogOrganism;
import lesson4.animals.organism.RandomOrganism;

public class DogFactory extends AnimalFactory {

    public DogFactory() {
        _organism = new DogOrganism();
    }

    @Override
    public Animal createAnimal(String name) {
        return new Dog(name, _organism);
    }

    @Override
    public Animal createRandomAnimal(String name) {
        return new Dog(name, new RandomOrganism());
    }


}
