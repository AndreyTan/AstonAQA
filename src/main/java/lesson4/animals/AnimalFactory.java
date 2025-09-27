package lesson4.animals;


import lesson4.animals.organism.IOrganismFactory;

public abstract class AnimalFactory {
    protected IOrganismFactory _organism;


    public abstract Animal createAnimal(String name);

    public abstract Animal createRandomAnimal(String name);

}
