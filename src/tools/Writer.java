package tools;


import popups.ConfirmBoxHelper;

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
            if (ConfirmBoxHelper.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                delete(true);
        }
    }

    public static void saveObject(Serializable object, String filename) {


        ObjectOutputStream OO;
        try {
            OO = new ObjectOutputStream(
                    new FileOutputStream(filename));
            OO.writeObject(object);
            OO.close();


        } catch (IOException e) {
            if (ConfirmBoxHelper.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                delete(true);
        }


    }

    public static Object loadObject(String filename) {
        ObjectInputStream OI;
        Object object = null;
        try {
            OI = new ObjectInputStream(
                    new FileInputStream(filename));
            object = OI.readObject();
            OI.close();
        } catch (IOException | ClassNotFoundException e) {
            if (ConfirmBoxHelper.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                delete(true);
        }

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

