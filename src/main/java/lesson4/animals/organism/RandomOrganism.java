package lesson4.animals.organism;

import lesson4.animals.organism.musculoskeletalSystem.IMusculoskeletalSystem;
import lesson4.animals.organism.musculoskeletalSystem.NoSwimMusculoskeletalSystem;
import lesson4.animals.organism.musculoskeletalSystem.NormalMusculoskeletalSystem;
import lesson4.animals.organism.stomach.Anorexia;
import lesson4.animals.organism.stomach.Glutton;
import lesson4.animals.organism.stomach.IStomach;

import java.util.Random;

public class RandomOrganism implements IOrganismFactory {
    @Override
    public IMusculoskeletalSystem createMusculoskeletalSystem() {
        Random random = new Random();

        if (random.nextInt(100) > 50) {
            int spendByRun = random.nextInt(1, 20);
            return new NormalMusculoskeletalSystem(random.nextInt(100, 1000), random.nextInt(1, 20), spendByRun * 3);
        } else {
            int spendByRun = random.nextInt(3, 30);
            return new NoSwimMusculoskeletalSystem(random.nextInt(100, 500), spendByRun);
        }

    }

    @Override
    public IStomach createStomach() {
        Random random = new Random();

        if (random.nextInt(100) > 50) {
            int maxHunger = random.nextInt(50, 400);
            return new Glutton(maxHunger, maxHunger / random.nextInt(50, 200));
        } else {
            return new Anorexia();
        }

    }

}
