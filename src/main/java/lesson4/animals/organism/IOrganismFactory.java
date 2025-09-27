package lesson4.animals.organism;

import lesson4.animals.organism.musculoskeletalSystem.IMusculoskeletalSystem;
import lesson4.animals.organism.stomach.IStomach;

public interface IOrganismFactory {
    IMusculoskeletalSystem createMusculoskeletalSystem();

    IStomach createStomach();
}
