/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amir
 */
public class game {
    public static void game() {

        Scanner s = new Scanner(System.in);
        ArrayList<String> pList = new PokeList().getList();
        
        
        Pokemon[] PlayerOne = new Pokemon[3];
        Pokemon[] Computer = new Pokemon[3];

        for (int i = 0; i < PlayerOne.length; i++) {
            for (int j = 0; j < pList.size(); j++) {
                System.out.printf("%2d. ", (j + 1));
                System.out.println(pList.get(j));
            }
            System.out.println("Choose your " + (i == 0 ? "first" : (i == 1 ? "second" : "third")) + " Pokemon! ");

            String str = pList.get(s.nextInt() - 1);
            PlayerOne[i] = new Pokemon(str);
            System.out.println("You chose " + str + "!");
            System.out.println(PlayerOne[i].toString());
            System.out.println(" 1. Confirm selection");
            System.out.println(" 2. Choose another Pokemon");

            if (s.nextInt() == 1) {
                pList.remove(i);
                //computer selection here
            } else {
                i--;
            }
        }
        for (Pokemon Px : PlayerOne) {
            System.out.println(Px.toString());
        }

    }
}
