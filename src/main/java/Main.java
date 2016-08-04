import handlers.CsvWriter;
import handlers.JsonHandler;
import handlers.UrlHandler;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String cityName = scan.next();
//        if(args.length>0 && args[0]!=null){
        if(cityName.length()>0){
            String responseString = UrlHandler.getJsonData(cityName);
            System.out.println(responseString);
            JsonHandler jsonHandler = new JsonHandler(responseString);
            CsvWriter csvWriter = new CsvWriter(jsonHandler.parseJsonData());

        }
        else{
            System.out.println("Error: empty request.");
        }
    }
}
