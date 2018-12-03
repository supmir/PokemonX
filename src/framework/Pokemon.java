package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import scenes.combat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author amir
 */
public class Pokemon {

    private String name, type;
    private int attack, defense, speed;
    final private String[] skillName = new String[4], skillType = new String[4];
    final private int[] power = new int[4], accuracy = new int[4];
    private int accSp, skillCount;
    private double hp;
    private boolean alive = true;

    public Pokemon(String name) {
        if (name.endsWith("(Custom)")) {
            try (Scanner is = new Scanner(new FileInputStream(System.getProperty("user.home") + "/PokemonX/Pokemons.txt"))) {
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

                    if ("".equals(str) || "$".equals(str)) {
                        int x = 0;
                        while (skillCount < 4) {
                            this.skillName[skillCount] = "...";
                            skillCount++;
                            x++;
                        }
                        skillCount -= x;
                        break;
                    }
                    this.skillName[skillCount] = str;
                    this.skillType[skillCount] = is.nextLine();
                    this.power[skillCount] = Integer.parseInt(is.nextLine());
                    this.accuracy[skillCount] = Integer.parseInt(is.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            InputStream IS = getClass().getResourceAsStream("Pokemons.txt");

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

                    if ("".equals(str) || "$".equals(str)) {
                        int x = 0;
                        while (skillCount < 4) {
                            this.skillName[skillCount] = "...";
                            skillCount++;
                            x++;
                        }
                        skillCount -= x;
                        break;
                    }
                    this.skillName[skillCount] = str;
                    this.skillType[skillCount] = is.nextLine();
                    this.power[skillCount] = Integer.parseInt(is.nextLine());
                    this.accuracy[skillCount] = Integer.parseInt(is.nextLine());
                }
            }
        }
    }


    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAccSp() {
        return accSp;
    }

    public void adder() {
        this.accSp += speed;
    }

    public String getSkillName(int skillIndex) {
        return skillName[skillIndex];
    }

    public String getName() {
        return name;
    }


    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void attack(int skillN, Pokemon attacked) {
        String line = name + " used " + skillName[skillN] + " and it is ";
        if (multiplier(attacked.type) == 0) {
            line += "not effective";
        } else if (multiplier(attacked.type) == 0.5) {
            line += "not very effective";
        } else if (multiplier(attacked.type) == 1) {
            line += "effective";
        } else if (multiplier(attacked.type) == 2) {
            line += "super effective";
        }
        line += " dealing " + (((attack * power[skillN] / attacked.defense) / 20) + 2) * multiplier(attacked.type) + " damage!\n";

        attacked.setHp(attacked.getHp() - (((attack * power[skillN] / attacked.defense) / 20) + 2) * multiplier(attacked.type));
        if (attacked.getHp() <= 0) {
            attacked.setAlive(false);
            line += attacked.name + " has fainted.\n";
        }


        accSp -= 100;

        combat.setStr(line);

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
