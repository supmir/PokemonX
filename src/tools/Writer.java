package tools;


import java.io.*;

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
        if (all) {
            String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
            File temp = new File(path);
            if (temp.delete())
                System.out.println("Deleted " + path);
        }

        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";
        File temp = new File(path);
        if (temp.delete())
            System.out.println("Deleted " + path);


        String path2 = System.getProperty("user.home") + "/PokemonX/LRTStr.bin";
        File temp2 = new File(path2);
        if (temp2.delete())
            System.out.println("Deleted " + path2);


    }


}

