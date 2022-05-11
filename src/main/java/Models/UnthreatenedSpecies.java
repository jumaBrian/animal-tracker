package Models;

import org.sql2o.Connection;

import java.util.List;

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
    // Save into database
    public void save(){
        try(Connection con = Database.sql2o.open()){
            String sql = "INSERT INTO animals (name, type,health,age) VALUES(:name, :type,:health,:age)";
            this.id =(int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("type",this.type).addParameter("health", this.health).addParameter("age", this.age).executeUpdate().getKey();
        }
        catch (ClassCastException exc){
        }
    }

    // list of all unthreatened species
    public static List<UnthreatenedSpecies> all() {
        String sql = "SELECT * FROM animals WHERE type = 'safe'";
        try(Connection con = Database.sql2o.open()) {
            return  con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(UnthreatenedSpecies.class);
        }
    }

}
