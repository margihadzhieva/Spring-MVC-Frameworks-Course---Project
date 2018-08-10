package pawinc.models.centers;

import pawinc.models.animals.Animal;

import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;

    List<Animal> animals;

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addAnimalAll(List<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    public List<Animal> getAnimals() {

        return Collections.unmodifiableList(this.animals);
    }

    public void removeAnimalAll(List<Animal> animals) {
        this.animals.remove(animals);
    }


}
