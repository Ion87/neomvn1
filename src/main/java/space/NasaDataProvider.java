package space;

import org.json.JSONObject;
import space.Asteroid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NasaDataProvider {
    private final static String Access_Key = "gwHZJmevi2ug220QzLmMKQGNTguavvOTU8WI7WDK";
    private final static String Neo_ENDPOINT = "https://api.nasa.gov/neo/rest/v1/feed";
    private final static Calendar calendarStart = Calendar.getInstance();
    private final static Calendar calendarEnd = Calendar.getInstance();
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void getNeoAsteroids(String startDate, String endDate) throws Exception {

            //1.Connect to nasa API
            URL oracle = new URL(Neo_ENDPOINT + "?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + Access_Key);
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

            List<Asteroid> asteroidsList = new ArrayList(count);
            calendarStart.setTime(dateFormat.parse(startDate));
        calendarEnd.setTime(dateFormat.parse(endDate));
        calendarEnd.add(Calendar.DATE, 1);
        endDate = dateFormat.format(calendarEnd.getTime());

        do {
            for (int j = 0; j < data.getJSONObject("near_earth_objects").getJSONArray(startDate).length(); j++) {

                JSONObject asteroid = data.getJSONObject("near_earth_objects")
                        .getJSONArray(startDate)
                        .getJSONObject(j);

                float distance = asteroid
                        .getJSONArray("close_approach_data")
                        .getJSONObject(0)
                        .getJSONObject("miss_distance")
                        .getFloat("kilometers");

                float diameter = asteroid
                        .getJSONObject("estimated_diameter")
                        .getJSONObject("kilometers")
                        .getFloat("estimated_diameter_min");

                boolean dangerous = asteroid
                        .getBoolean("is_potentially_hazardous_asteroid");

                asteroidsList.add(new Asteroid(startDate+" /"+(j+1), diameter, distance, dangerous));
            }
            calendarStart.add(Calendar.DATE, 1);
            startDate = dateFormat.format(calendarStart.getTime());
        }while (!startDate.equals(endDate));
        asteroidsList.forEach(System.out::println);
    }
}
