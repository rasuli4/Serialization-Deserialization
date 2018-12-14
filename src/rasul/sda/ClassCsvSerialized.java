package rasul.sda;

import java.io.*;
import java.util.*;

public class ClassCsvSerialized implements Serializable {

    private static final String SEPARATOR = ";";

    public static void main(String[] args) {

        String csvFile = "src/rasul/sda/viljandi_routes.csv";
        BufferedReader br = null;
        String line = "";

        List<List<String>> linksAsList = new ArrayList<>();


        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] stringParams = line.split(ClassCsvSerialized.SEPARATOR);
                linksAsList.add(Arrays.asList(stringParams));
            }

            for (List<String> printString : linksAsList) {
                System.out.println(printString);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream("src/rasul/sda/serialized_dest.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fos);
            objectOut.writeObject(linksAsList);
            objectOut.close();
            fos.close();
            System.out.println("Serialized data is saved in rasul/sda/serialized_dest.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}