package Models;

public class Endangered extends Animal {
    // fields
    private static final String STATUS = "endangered";
    private String health;
    private String age;

    // behaviour
    public Endangered(String name, String health, String age ,String STATUS) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = STATUS;
    }

}
