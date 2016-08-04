import handlers.CsvWriter;
import handlers.JsonHandler;
import handlers.UrlHandler;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length>0 && args[0]!=null){
            String cityName = args[0];
            String responseString = UrlHandler.getJsonData(cityName);
            System.out.println(responseString);
            JsonHandler jsonHandler = new JsonHandler(responseString);
            CsvWriter csvWriter = new CsvWriter(jsonHandler.parseJsonData());
            csvWriter.writeToFile(cityName);
        }
        else{
            System.out.println("Error: empty request.");
        }
    }
}
