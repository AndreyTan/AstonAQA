package lesson4.animals.organism;

import lesson4.animals.organism.musculoskeletalSystem.IMusculoskeletalSystem;
import lesson4.animals.organism.musculoskeletalSystem.NormalMusculoskeletalSystem;
import lesson4.animals.organism.stomach.Anorexia;
import lesson4.animals.organism.stomach.Glutton;
import lesson4.animals.organism.stomach.IStomach;

public class DogOrganism implements IOrganismFactory {

    @Override
    public IMusculoskeletalSystem createMusculoskeletalSystem() {
        return new NormalMusculoskeletalSystem(500, 1, 50);
    }

    @Override
    public IStomach createStomach() {
        return new Glutton(200, 0);
    }


}
