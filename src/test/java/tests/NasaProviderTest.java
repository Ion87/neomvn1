package tests;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
public class NasaProviderTest {
@Test
    void ceckNasaConnection() throws IOException {
        URL url = new URL("https://api.nasa.gov/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        if ((inputLine = in.readLine())== null){
            fail("Failed connection to Nasa");
        }
    }
}
