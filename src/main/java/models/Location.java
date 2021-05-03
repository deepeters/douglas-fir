package models;

import org.sql2o.Connection;

import java.util.List;

public class Location{
    int id;
    String Location ;

    public Location(String location) {
        Location = location;
    }

    public String getLocation() {
        return Location;
    }
    public void  save(){
        String sql = "INSERT INTO location (location) VALUES (:location)";
        try (Connection con = DB.sql2o.open()){
            this.id = (int)
                    con.createQuery(sql,true)
                            .addParameter("location",this.Location)
                            .throwOnMappingFailure(false)
                            .executeUpdate()
                            .getKey();
        }
    }
    public static List all(){
        String sql = "SELECT * FROM location";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Location.class);
        }
    }
    public static Location find(int id) {
        String sql = "SELECT * FROM location WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Location Location = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Location.class);
            return Location;
        }
    }

}