package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class LocationTest {
    @Test
    public void Location_instanciatesCorrectly(){
        Location testLocation = new Location("By the river");
        assertEquals(true,testLocation instanceof location);
    }
    @Test
    public void Location_getName(){
        Location testLocation = new Location("By the river");
        assertEquals("By the river",testLocation.getLocation());
    }


}