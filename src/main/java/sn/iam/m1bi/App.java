package sn.iam.m1bi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

/**
 * Hello world!
 *
 */
public class App {

    private static final String DATA_PATH = "src/main/resources/data.csv";

    private static final int 
    COL_TITLE = 1,
    COL_GENRES = 2, 
    COL_DIRECTEUR = 4, 
    COL_ACTEURS = 5,
    COL_DUREE = 7,
    COL_REVENUE = 10,
    COL_RATINGS = 8;

    public static void main(String[] args) {

        Map<String, List<String[]>> dataset = new HashMap<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(DATA_PATH));
            List<String[]> data = reader.readAll();
            for (String[] observation: data) {
                dataset.put(observation[COL_TITLE], Arrays.asList(
                    new String[]{observation[COL_GENRES]}, 
                    new String[]{observation[COL_DIRECTEUR]},
                    new String[]{observation[COL_ACTEURS]},
                    new String[]{observation[COL_DUREE]},
                    new String[]{observation[COL_REVENUE]},
                    new String[]{observation[COL_RATINGS]}
                ));
            }

            // for (Map.Entry<String, List<String[]>> entry : dataset.entrySet()) {
            //     System.out.println(entry.getKey());
            //     for (String[] r: entry.getValue()) {
            //         System.out.println(Arrays.toString(r));
            //     }
            //     System.out.println("-----------------------");
            // }

            for (Map.Entry<String, List<String[]>> entry : dataset.entrySet()) {
                String genre = entry.getValue().get(0)[0];
                String[] tabGenres = genre.split(",");
                System.out.println(tabGenres[0]);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur: le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur: impossible de fermer le reader");
        }

    }


}
