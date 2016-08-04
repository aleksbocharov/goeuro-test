package handlers;

import model.City;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private String jsonData;

    public JsonHandler(String jsonData) {
        this.jsonData = jsonData;
    }

    public List<City> parseJsonData(){
        if(jsonData==null) return null;

        List<City> cities = new ArrayList<>();
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);
            JSONArray citiesArray = (JSONArray) obj;
            for (Object o : citiesArray) {
                JSONObject tempJsonCity = (JSONObject) o;
                City tempCity = new City();
                tempCity.setId((Long)tempJsonCity.get("_id"));
                tempCity.setName((String)tempJsonCity.get("name"));
                tempCity.setType((String)tempJsonCity.get("type"));
                JSONObject geo_position = (JSONObject)tempJsonCity.get("geo_position");
                tempCity.setLatitude((Double)geo_position.get("latitude"));
                tempCity.setLongitude((Double)geo_position.get("longitude"));
                cities.add(tempCity);

            }
        }catch(ParseException pe){
            System.out.println("Parsing error at position: " + pe.getPosition());
            pe.printStackTrace();
        }
        return cities;
    }
}
