package handlers;

import model.City;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    private List<City> cities;

    public CsvWriter(List<City> cities){
        this.cities = cities;
    }

    public void writeToFile(String name){
        try(FileWriter fileWriter = new FileWriter(name+".csv")) {
            String header = "_id, name, type, latitude, longitude\n";
            fileWriter.append(header);
            for (City city : cities) {
                fileWriter.append(city.toCsv());
                fileWriter.append("\n");
            }
        } catch (IOException ioe) {
            System.out.println("I/O error:" + ioe.getMessage());
        }


    }


}
