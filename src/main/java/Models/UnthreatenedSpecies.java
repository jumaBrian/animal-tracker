package Models;

public class UnthreatenedSpecies extends Animal{

    private static final String STATUS = "unthreatened";
    private String health;
    private String age;

    public UnthreatenedSpecies(String name,String health, String age,String STATUS){
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = STATUS;
    }

}
