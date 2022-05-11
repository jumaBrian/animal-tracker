package Models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredSpecies extends Animal {
    // fields
    private static final String STATUS = "endangered";
    private String health;
    private String age;

    public String getHealth() { return health;}
    public String getAge() {return age;}

    // behaviour
    public EndangeredSpecies(String name, String health, String age , String STATUS) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = STATUS;
    }

    public static EndangeredSpecies find(int id){
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredSpecies animal = con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(EndangeredSpecies.class);
            return animal;
        }
    }

    /*list of all unsafe animals*/
    public static List<EndangeredSpecies> all() {
        String sql = "SELECT * FROM animals WHERE type = 'endangered'";
        try (Connection con = Database.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(EndangeredSpecies.class);
        }
    }

    /*save object to database*/
    public void save() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name).addParameter("type", this.type).addParameter("health", this.health).addParameter("age", this.age).executeUpdate().getKey();
        }
        catch (ClassCastException exc){

        }
    }

    /*getter for public id*/
    public int getId() {
        return id;
    }

}
