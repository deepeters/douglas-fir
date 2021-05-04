package models;

import org.sql2o.*;

public class DB {
    // For local use only
    // public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "deepeters", "password");

    //For Heroku
    private static String connectionString = "jdbc:postgresql://ec2-52-87-107-83.compute-1.amazonaws.com:5432/dc04vf9j5qb3g5"; //!
    public static Sql2o sql2o = new Sql2o(connectionString, "fkpzwbhosrazfb", "82b3a75d0143686c51bbfe50f2a6f293e40f7335887565bfb05fd1b42c2d5a0f"); //!
}


