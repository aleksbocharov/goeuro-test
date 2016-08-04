package handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlHandler {
    private static final String CITY_ENDPOINT_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static String getJsonData(String cityName) throws IOException {
        URL url = new URL(CITY_ENDPOINT_URL+cityName);
        try(InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ){
            StringBuilder stringBuilder = new StringBuilder();
            String nextLine;
            while ((nextLine = br.readLine()) != null){
                stringBuilder.append(nextLine);
            }
            return stringBuilder.toString();
        }catch (IOException ioe){
            throw new IOException("Unable to read data: " + ioe.getMessage());
        }
    }

}
