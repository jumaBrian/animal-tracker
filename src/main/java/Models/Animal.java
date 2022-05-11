package Models;

import org.sql2o.Connection;

public abstract class Animal {
    public String name;
    public String type;
    public int id;

    // getters
    public String getName(){ return name; }
    public String getType(){ return type; }
    public int getId(){ return id;}


    // Save object to database, Create sql20 object to use its methods
    public void save(){
        try(Connection con = Database.sql2o.open()){
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            /*this- object being added,retrieve properties*/
            /*create obj,connect into database,execute query statement,update existing fields,retrieve primary key*/
            this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter(type,this.type).executeUpdate().getKey();
        }

    }
}


