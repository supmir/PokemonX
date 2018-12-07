package tools;

import scenes.Combat;

import java.io.*;

public class LRTStr {
    private static int L;
    private static int R;
    private static boolean T;
    private static boolean M;
    private static String
            STR;
    private static String STRC;

    public static void writeLRTStr() throws IOException {


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
