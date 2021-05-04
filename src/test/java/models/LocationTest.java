package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class LocationTest {
    @Test
    public void Location_instanciatesCorrectly(){
        Location testLocation = new Location("Area Section 001");
        assertEquals(true,testLocation instanceof Location);
    }
    @Test
    public void Location_getName(){
        Location testLocation = new Location("Area Section 001");
        assertEquals("Area Section 001",testLocation.getLocation());
    }


}