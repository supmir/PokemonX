package framework;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class pokeWriter {
    private static String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
    private static File temp = new File(path);
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
