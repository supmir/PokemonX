package framework;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class userPokemon {

    public static boolean verify(ArrayList<TextField> a, ArrayList<ComboBox<String>> b) {

        String str = "$\n";
        str += a.get(0).getText() + "\n";
        str += b.get(0).getValue() + "\n";
        for (int i = 1; i < 6; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(1).getValue() + "\n";
        for (int i = 6; i < 10; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(2).getValue() + "\n";
        for (int i = 10; i < 14; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(3).getValue() + "\n";
        for (int i = 14; i < 18; i++) {
            str += a.get(i).getText() + "\n";
        }
        str += b.get(4).getValue() + "\n";
        for (int i = 18; i < 20; i++) {
            str += a.get(i).getText() + "\n";
        }


        System.out.println(str);


        //data validation return false if fail
        //save into user home
        //might upgrade to int verification system


        return false;
    }
}
