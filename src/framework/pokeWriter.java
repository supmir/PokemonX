package framework;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class pokeWriter {
    private static String name, type;
    private static int attack, defense, speed;
    final private static String[] skillName = new String[4], skillType = new String[4];
    final private static int[] power = new int[4], accuracy = new int[4];
    private static double hp;

    private static int verify(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {
        int code = 0b10000000;//128 (no problem)
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";

        File temp = new File(path);
        if (a.get(0).getText().contains("(Custom)")) {

        }
        name = temp.exists() ? "" : "$\n" + a.get(0).getText() + " (Custom)";
        type = b.get(0).getValue();
        attack = Integer.parseInt(a.get(2).getText());
        defense = Integer.parseInt(a.get(3).getText());
        hp = Integer.parseInt(a.get(4).getText());
        speed = Integer.parseInt(a.get(5).getText());

        for (int i = 1; i < 5; i++) {
            skillName[i - 1] = a.get(2 + (i * 4)).getText();
            skillType[i - 1] = b.get(i).getValue();
            power[i - 1] = Integer.parseInt(a.get(3 + (i * 4)).getText());
            accuracy[i - 1] = Integer.parseInt(a.get(4 + (i * 4)).getText());
        }


        if (a.get(0).getText() == (null)) {


        } else {
            code &= 0b10000000;
        }

        return code;


    }

    public static int write(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {
        int code = verify(a, b);
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
        File temp = new File(path);
        System.out.println(temp.exists());
        String str = "";


        if (!temp.exists()) str = "$\n";

        str += a.get(0).getText() + "(Custom)\n";
        str += b.get(0).getValue() + "\n";
        for (int i = 2; i < 7; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(1).getValue() + "\n";
        for (int i = 8; i < 11; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(2).getValue() + "\n";
        for (int i = 12; i < 15; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(3).getValue() + "\n";
        for (int i = 16; i < 19; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(4).getValue() + "\n";
        for (int i = 20; i < 22; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += "$";


        System.out.println(str);
        if (true)
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(path, true));
                pw.println(str);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else {
            return code;
        }


        //data validation return false if fail


        return 0;
    }
}
