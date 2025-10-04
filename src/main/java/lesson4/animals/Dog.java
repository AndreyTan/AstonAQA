package lesson4.animals;

public class Dog extends Animal {
    protected static int countDogs;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 500)
            System.out.printf("%s бежит %d дистанции\n", name, distance);
        else if (distance > 500)
            System.out.printf("%s на такие дистанции не бегает\n", name);
    }

    @Override
    public void swim(int distance) {
        if (distance > 0 && distance <= 10)
            System.out.printf("%s плывёт на %d дистанцию\n", name, distance);
        else if (distance > 10)
            System.out.printf("%s на такие дистанции не плавает\n", name);
    }

    public static void printCountDogs() {
        System.out.println("всего собак создано: " + countDogs);
    }

}
