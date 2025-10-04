package lesson4.animals;

public class Cat extends Animal {
    protected static int countCats;
    protected boolean hungry;

    public Cat(String name) {
        super(name);
        countCats++;
        this.hungry = false;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 200)
            System.out.printf("%s бежит %d дистанцию\n", this.name, distance);
        else if (distance > 200)
            System.out.printf("%s на такие дистанции не бегает\n", this.name);
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать!\n", this.name);
    }

    public void eatFood(FlatFood food) {
        if (food.tryToEat(1)) {
            this.hungry = true;
            System.out.printf("%s поел\n", this.name);
        } else {
            this.hungry = false;
            System.out.printf("%s не поел\n", this.name);
        }
    }

    public void printHungryStatus() {
        System.out.printf("%s статус сытости %b\n", this.name, this.hungry);
    }

    public static void printCountCats() {
        System.out.println("всего кошек создано: " + countCats);
    }


}
