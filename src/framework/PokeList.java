package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
                if (is.nextLine().contains("$")) {
                    if (is.hasNextLine())
                        pList.add(is.nextLine());
                }
            }
        }
        try {
            IS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get user defined pokemon here
        /*
        InputStream IS2 = getClass().getResourceAsStream("~Pokemons.txt");
        try (Scanner is = new Scanner(IS)) {
            //read pokemon
            while (is.hasNext()) {
                if (is.nextLine().contains("$")) {
                    if (is.hasNextLine())
                        pList.add(is.nextLine());
                }
            }
        }
        try {
            IS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        return pList;
    }
}
