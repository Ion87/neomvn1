package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchitectureTest {
@Test
    void checBothCLIandGUI(){
    try {
        Class.forName("main.CLIApplication");
        Class.forName("main.GUIApplication");
    }catch (ClassNotFoundException e){
        fail("The Application doesn't have both GUI and CLI");
    }
}
@Test
    void checMethodMain(){
        try {
            Class.forName("main.CLIApplication").getMethod("main",String[].class);
            Class.forName("main.GUIApplication").getMethod("main",String[].class);
        }catch (ClassNotFoundException e){
            fail("The Application doesn't have both GUI and CLI");
        } catch (NoSuchMethodException e) {
            fail("The Application class doesn't have \"main()\"");
        }
    }
    @Test
    void checBothAsteroidandNasaDataProvider(){
        try {
            Class.forName("space.Asteroid");
            Class.forName("space.NasaDataProvider");
        }catch (ClassNotFoundException e){
            fail("The Application doesn't have both Asteroid and NasaDataProvider");
        }
    }
}