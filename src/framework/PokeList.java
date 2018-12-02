package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amir
 */
public class PokeList {

    public ArrayList<String> getList() {

        ArrayList<String> pList = new ArrayList<>();

        InputStream IS = getClass().getResourceAsStream("Pokemons.txt");
        //try (Scanner is = new Scanner(new FileInputStream("Pokemons/" + name + ".txt"))) {
        try (Scanner is = new Scanner(IS)) {
            //read pokemon
            while (is.hasNext()) {
                if (is.nextLine().contains("$")) {
                    pList.add(is.nextLine());
                }
            }
        }        
        
        return pList;
    }
}
