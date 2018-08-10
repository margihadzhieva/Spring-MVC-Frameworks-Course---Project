package pawinc.models.animals;

public abstract class Animal {

    private String name;

    private int age;

    private boolean isCleansed;

    private String adoptionCenter;

    protected Animal(String name, int age, String adoptionCenter) {
        this.name = name;
        this.age = age;
        this.isCleansed = false;
        this.adoptionCenter = adoptionCenter;
    }


}
