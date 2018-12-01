/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author amir
 */
public class Pokemon {

    private String name, type;
    private int attack, defense, hp, speed, skillCount;
    private String[] skillName = new String[4], skillType = new String[4];
    private int[] power = new int[4], accuracy = new int[4];

    public Pokemon(String name) throws FileNotFoundException {

        InputStream IS = getClass().getResourceAsStream("Pokemons.txt");
        //try (Scanner is = new Scanner(new FileInputStream("Pokemons/" + name + ".txt"))) {
        try (Scanner is = new Scanner(IS)) {
            String line = null;
            //read pokemon
            while (is.hasNext()) {
                line = is.nextLine();
                if (line.contains(name)) {
                    break;
                }
            }
            
            this.name = line;
            this.type = is.nextLine();
            this.attack = Integer.parseInt(is.nextLine());
            this.defense = Integer.parseInt(is.nextLine());
            this.hp = Integer.parseInt(is.nextLine());
            this.speed = Integer.parseInt(is.nextLine());
            for (skillCount = 0; is.hasNextLine(); skillCount++) {
                String str = is.nextLine();
                
                if ("".equals(str)||"$".equals(str)) {
                    skillCount--;
                    break;
                }
                this.skillName[skillCount] = str;
                this.skillType[skillCount] = is.nextLine();
                this.power[skillCount] = Integer.parseInt(is.nextLine());
                this.accuracy[skillCount] = Integer.parseInt(is.nextLine());
            }
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double attack(int skillN, int oppDef, String oppType) {
        return (((attack * power[skillN] / oppDef) / 20) + 2) * multiplier(oppType);
    }

    @Override
    public String toString() {
        String str = "Name : " + name + "\nType : " + type + "\nAttack : " + attack + "\nDefense : " + defense + "\nHP : " + hp + "\nSpeed : " + speed;
        for (int i = 0; i < skillCount; i++) {
            str += "\nSkill " + (i + 1) + " : " + skillName[i] + "\nType : " + skillType[i] + "\nPower : " + power[i] + "\nAccuracy : " + accuracy[i];
        }
        return str;
    }

    private double multiplier(String oppType) {
        double x = 1;

        return x;
    }

}
