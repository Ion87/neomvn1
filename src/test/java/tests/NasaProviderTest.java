package tests;
import config.XMLConfigurateProvider;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NasaProviderTest {
//    ClassLoader classLoader = getClass().getClassLoader();
//    File file = new File(classLoader.getResource("nasa.xml").getPath());
    @Test
    public void testURL() throws Exception {
       // XMLConfigurateProvider configurateProvider = new XMLConfigurateProvider();
       // String strUrl = configurateProvider.getValue("url","nasa.xml");
        //String demoKey = configurateProvider.getValue("key","nasa.xml");
        try {
            //URL oracle = new URL(strUrl+"?start_date=2020-03-03&end_date=2020-03-03"+"&api_key="+demoKey);
            URL url = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY");
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();
            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }
    @Test
    void testConnection() throws IOException, SAXException {
        XMLConfigurateProvider configurateProvider = new XMLConfigurateProvider();
        String url = configurateProvider.getValue("url","nasa.xml");
        String demoKey = configurateProvider.getValue("key","nasa.xml");
        //Connection
        URL oracle = new URL(url+"?start_date=2020-03-03&end_date=2020-03-03"+"&api_key="+demoKey);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        //2.read data
        String stringData = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            stringData += inputLine;
        in.close();
        //3.parse JSON
        JSONObject data = new JSONObject(stringData);
        int count = data.getInt("element_count");
        System.out.println("Found " + count + " results.");
    }
}
