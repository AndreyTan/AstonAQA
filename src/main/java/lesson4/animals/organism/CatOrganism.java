package lesson4.animals.organism;

import lesson4.animals.organism.musculoskeletalSystem.IMusculoskeletalSystem;
import lesson4.animals.organism.musculoskeletalSystem.NoSwimMusculoskeletalSystem;
import lesson4.animals.organism.stomach.Glutton;
import lesson4.animals.organism.stomach.IStomach;

public class CatOrganism implements IOrganismFactory {

    @Override
    public IMusculoskeletalSystem createMusculoskeletalSystem() {
        return new NoSwimMusculoskeletalSystem(200, 1);
    }

    @Override
    public IStomach createStomach() {
        return new Glutton(100, 10);
    }

}
