package framework;


import scenes.combat;

import java.io.*;

public class pokeWriter {
    static int L, R, T, M;
    static boolean t, m;
    private static String STR, STRC;


    public static void writePokemon(String line) {
        //todo remove pokemon in admin

        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
        File temp = new File(path);

        if (!temp.exists()) line = "$\n" + line;//check if custom file alr exist
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path, true));
            pw.println(line);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";
        File temp = new File(path);

        try {
            saveObject(combat.getController(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Pokemon[][] getProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";
        File temp = new File(path);

        try {
            return loadObject(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


// Serialize an object into binary format inside a file
// stored in the location of the second parameter


    private static void saveObject(Serializable object, String filename)
            throws IOException {
        ObjectOutputStream OO = new ObjectOutputStream(
                new FileOutputStream(filename));

// The writeObject() method automatically transforms the contents of
        // the object to bytes.
        // An error is generated if the object does not implement the Serialize interface
        OO.writeObject(object);

        OO.close();
    }

    // Deserializes the object stored in the provied path and returns this
// object without any casting it to a specific type
    private static Pokemon[][] loadObject(String filename) throws ClassNotFoundException, IOException {
        // Open the file for reading
        ObjectInputStream OI = new ObjectInputStream(
                new FileInputStream(filename));

        // Read the bytes and creates the object in memory
        Pokemon[][] object = (Pokemon[][]) OI.readObject();

        // Close the file
        OI.close();

        // Returns the object without casting
        return object;
    }


    public static void writeLRTStr() throws IOException {


        ObjectOutputStream OO = new ObjectOutputStream(
                new FileOutputStream(System.getProperty("user.home") + "/PokemonX/LRTStr.bin"));

        OO.writeInt(combat.getL());
        OO.writeInt(combat.getR());
        OO.writeInt(combat.getT());
        OO.writeInt(combat.getM());
        OO.writeUTF(combat.getStr());
        OO.writeUTF(combat.getStrC());
        OO.close();


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

    public static void readLRTStr() throws IOException {
        ObjectInputStream OI = new ObjectInputStream(
                new FileInputStream(System.getProperty("user.home") + "/PokemonX/LRTStr.bin"));

        L = OI.readInt();
        R = OI.readInt();
        T = OI.readInt();
        t = T == 1;
        M = OI.readInt();
        m = M == 1;
        STR = OI.readUTF();
        STRC = OI.readUTF();
        OI.close();
    }


    public static int getL() {
        return L;
    }

    public static int getR() {
        return R;
    }


    public static boolean isT() {
        return t;
    }

    public static boolean isM() {
        return m;
    }

    public static String getStr() {
        return STR;
    }

    public static String getStrC() {
        return STRC;
    }


}

