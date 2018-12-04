package framework;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class pokeWriter {
    static String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
    static File temp = new File(path);

    public static String getStats(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {

        String stats = "";

        stats += a.get(0).getText() + "(Custom)\n";//name
        stats += b.get(0).getValue() + "\n";//type
        for (int i = 2; i < 6; i++) {//7 is to be missed
            stats += a.get(i).getText() + "\n";//attack,defense,hp,speed
        }

        ///////skill starts here
        for (int i = 1; i < 5; i++) {//i = 1 is skill 1;
            if (a.get(2 + (i * 4)).getText() != "") {//when i = 1, val = 6, i=2, val 10
                stats += a.get(2 + (i * 4)).getText() + "\n";
                stats += b.get(i).getValue();
                for (int j = 3; j < 5; j++) {
                    stats += a.get(j + (i * 4)).getText() + "\n";
                }
            }
        }
        stats += "$";

        return stats;
    }

    public static void write(String line) {


        if (!temp.exists()) line = "$\n" + line;//check if custom file alr exist


        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path, true));
            pw.println(line);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
