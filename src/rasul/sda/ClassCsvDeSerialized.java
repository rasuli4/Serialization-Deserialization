package rasul.sda;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;


public class ClassCsvDeSerialized  {

    final private static Logger logger = Logger.getLogger(ClassCsvSerialized.class);

    private static List<List<String>> deserializedArray = new ArrayList<>();        // arrays of arrays of routes between the cities "Citi1; City2; DistanceBetweeen"
    private static Set<String> cities = new HashSet<>();

    public static void main(String[] args) {


        try {
            FileInputStream fis = new FileInputStream("src/rasul/sda/serialized_dest.ser");    // deserialization of array
            ObjectInputStream in = new ObjectInputStream(fis);
            deserializedArray = (ArrayList) in.readObject();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            return;
        }


        for(List<String> printString : deserializedArray) {

            for (String s : printString){
                cities.add(s.replaceAll("[^a-zA-Z]", ""));
            }
            logger.info(printString);
        }
        cities.remove("");
        System.out.println(cities);

    }

}



