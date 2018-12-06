package framework;


import scenes.Combat;

import java.io.*;

public class PokeWriter {
    private static int L;
    private static int R;
    private static boolean T;
    private static boolean M;
    private static String STR, STRC;


    public static void writePokemon(String line) {
        //todo remove pokemon in admin

        //todo save border style
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt",
                tempLine = line;
        File temp = new File(path);

        if (!temp.exists()) tempLine = "$\n" + tempLine;//check if custom file alr exist
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path, true));
            pw.println(tempLine);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void writeProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        try {
            saveObject(Combat.getController(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Pokemon[][] getProg() {
        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";

        try {
            return (Pokemon[][]) loadObject(path);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;

    }



    private static void saveObject(Serializable object, String filename)
            throws IOException {
        ObjectOutputStream OO = new ObjectOutputStream(
                new FileOutputStream(filename));

        OO.writeObject(object);

        OO.close();
    }

    private static Object loadObject(String filename) throws ClassNotFoundException, IOException {

        ObjectInputStream OI = new ObjectInputStream(
                new FileInputStream(filename));

        Object object = OI.readObject();

        OI.close();

        return object;
    }


    static void writeLRTStr() throws IOException {


        ObjectOutputStream OO = new ObjectOutputStream(
                new FileOutputStream(System.getProperty("user.home") + "/PokemonX/LRTStr.bin"));

        OO.writeInt(Combat.getL());
        OO.writeInt(Combat.getR());
        OO.writeBoolean(Combat.getT());
        OO.writeBoolean(Combat.getM());
        OO.writeUTF(Combat.getStr());
        OO.writeUTF(Combat.getStrC());
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

        T = OI.readBoolean();
        M = OI.readBoolean();
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
        return T;
    }

    public static boolean isM() {
        return M;
    }

    public static String getStr() {
        return STR;
    }

    public static String getStrC() {
        return STRC;
    }


}

