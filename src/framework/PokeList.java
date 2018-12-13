package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import popups.ConfirmBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static tools.Writer.delete;

/**
 * @author amir
 */
public class PokeList {

    public ArrayList<String> getList() {

        ArrayList<String> pList = new ArrayList<>();

        InputStream IS = getClass().getResourceAsStream("Pokemons.txt");
        try (Scanner is = new Scanner(IS)) {
            //read pokemon
            while (is.hasNext()) {
                if (is.nextLine().contains("$") && is.hasNextLine())
                    pList.add(is.nextLine());

            }
        }
        try {
            IS.close();
        } catch (IOException e) {

            if (ConfirmBox.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                delete(true);
        }


        String path = System.getProperty("user.home") + "/PokemonX/Pokemons.txt";
        File temp = new File(path);
        if (temp.exists()) {
            try (Scanner is = new Scanner(new FileInputStream(path))) {
                //read pokemon
                while (is.hasNext()) {
                    if (is.nextLine().contains("$") && is.hasNextLine()) {
                        pList.add(is.nextLine());
                    }
                }
            } catch (FileNotFoundException e) {
                if (ConfirmBox.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                    delete(true);
            }
            try {
                IS.close();
            } catch (IOException e) {

                if (ConfirmBox.display("Fatal error found!", "Would you like to reset the game? \n(Please contact the developer @supmir on GitHub)"))
                    delete(true);
            }
        }


        return pList;
    }
}
