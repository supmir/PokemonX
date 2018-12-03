package framework;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class pokeWriter {
    private String name, type;
    private int attack, defense, speed;
    final private String[] skillName = new String[4], skillType = new String[4];
    final private int[] power = new int[4], accuracy = new int[4];
    private double hp;

    public pokeWriter(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {
        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
        File temp = new File(path);

        this.name = temp.exists() ? "" : "$\n" + a.get(0).getText() + " (Custom)";
        this.type = b.get(0).getValue();
        this.attack = Integer.parseInt(a.get(2).getText());
        this.defense = Integer.parseInt(a.get(3).getText());
        this.hp = Integer.parseInt(a.get(4).getText());
        this.speed = Integer.parseInt(a.get(5).getText());

        for (int i = 1; i < 5; i++) {
            this.skillName[i - 1] = a.get(2 + (i * 4)).getText();
            this.skillType[i - 1] = b.get(i).getValue();
            this.power[i - 1] = Integer.parseInt(a.get(3 + (i * 4)).getText());
            this.accuracy[i - 1] = Integer.parseInt(a.get(4 + (i * 4)).getText());
        }


    }

    public static boolean verify(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {
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

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path, true));
            pw.println(str);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //data validation return false if fail
        //save into user home
        //might upgrade to int verification system


        return false;
    }
}
