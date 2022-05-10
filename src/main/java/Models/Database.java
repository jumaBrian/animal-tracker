package Models;

import org.sql2o.Sql2o;

public class Database {

    static String connectionString = "jdbc:postgresql://ec2-54-161-239-198.compute-1.amazonaws.com:5432/d2bjal4k2hqfo6";
    public static  Sql2o sql2o = new Sql2o(connectionString, "mergbiwnuandzr", "765882d2333bde1e79554e6f68a6b6ccfc409787de45807538983eed9461b4d8");
}
