package lesson4.animals;

public abstract class Animal {
    protected String name;
    protected static int countAnimals;

    public Animal(String name) {
        countAnimals++;
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static void printCountAnimals() {
        System.out.println("всего животных создано: " + countAnimals);
    }

}
