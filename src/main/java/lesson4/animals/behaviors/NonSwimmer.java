package lesson4.animals.behaviors;

public class NonSwimmer implements ISwimBehavior{
    @Override
    public void TryToSwim(int distance) {
        System.out.println("Не умею плавать!");
    }
}
