package models;

import org.sql2o.*;

public class DB {
    // For local use only
    // public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "deepeters", "password");

    //For Heroku
    private static String connectionString = "jdbc:postgresql://ec2-54-196-33-23.compute-1.amazonaws.com:5432/da4vsocdcsgf2g"; //!
    public static Sql2o sql2o = new Sql2o(connectionString, "jjnbbjicfjdupw", "0ac59a91dd41d91b98dad8a9051c210d042ff23685ae938a87c8fd69839cd0ca"); //!
}


