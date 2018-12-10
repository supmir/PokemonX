package tools;


import java.io.*;
import java.util.ArrayList;

public class Writer {


    public static void writer(String line, String fileName, boolean append) {
        String path = System.getProperty("user.home") + "/PokemonX/" + fileName + ".txt";

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path, append));
            pw.println(line);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveObject(Serializable object, String filename)
            throws IOException {
        ObjectOutputStream OO = new ObjectOutputStream(
                new FileOutputStream(filename));

        OO.writeObject(object);

        OO.close();
    }

    public static Object loadObject(String filename) throws ClassNotFoundException, IOException {

        ObjectInputStream OI = new ObjectInputStream(
                new FileInputStream(filename));

        Object object = OI.readObject();

        OI.close();

        return object;
    }

    public static void delete(boolean all) {
        ArrayList<String> files = new ArrayList<>();

        if (all) {
            files.add("Pokemons.txt");
            files.add("userStyle.txt");

        }

        files.add("fight.bin");
        files.add("LRTStr.bin");


        for (String file : files) {
            String path = System.getProperty("user.home") + "/PokemonX/" + file;
            File temp = new File(path);
            if (temp.delete())
                System.out.println("Deleted " + path);
        }


    }


}

