package com.mulatodev.greeting.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExternalRestfulService {

    public String GetLocationCodeByCityName(String cityName) {

        String output = "";

        try {
            URL url = new URL("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=HU0gvteaKdygWPHZt6ZZ6PB53cUZEctm&q="+cityName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200)
                throw new RuntimeException("Failed : HTTP Error code: " + conn.getResponseCode());

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);

            while ((output = br.readLine()) != null ){
                System.out.println(output);
            }
            br.close();
            in.close();
            conn.disconnect();

        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return output;
    }
}
