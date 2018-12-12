package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import scenes.Combat;
import tools.getres.GetResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @author amir
 */
public class Pokemon implements Serializable {

    private String
            name,
            type;
    private int
            attack,
            defense,
            speed;
    final private String[]
            skillName = new String[4],
            skillType = new String[4];
    final private int[]
            power = new int[4],
            accuracy = new int[4];
    private int accSp,
            skillCount;
    private double hp;
    private boolean alive = true;
//    private GetResource sfx = new GetResource(); DO NOT PUT IT HER IT IS NOT SERIALIZABLE

    public Pokemon(String name) {
        String path = name.endsWith("(Custom)") ? System.getProperty("user.home") + "/PokemonX/Pokemons.txt" : "Pokemons.txt";
        InputStream IS = getClass().getResourceAsStream(path);
        try (Scanner sc = new Scanner((name.endsWith("(Custom)") ? new FileInputStream(path) : IS))) {
            String line = null;
            //read pokemon
            while (sc.hasNext()) {
                line = sc.nextLine();
                if (line.contains(name)) {
                    break;
                }
            }

            this.name = line;
            this.type = sc.nextLine();
            this.attack = Integer.parseInt(sc.nextLine());
            this.defense = Integer.parseInt(sc.nextLine());
            this.hp = Integer.parseInt(sc.nextLine());
            this.speed = Integer.parseInt(sc.nextLine());
            for (skillCount = 0; sc.hasNextLine(); skillCount++) {
                String str = sc.nextLine();

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
                this.skillType[skillCount] = sc.nextLine();
                this.power[skillCount] = Integer.parseInt(sc.nextLine());
                this.accuracy[skillCount] = Integer.parseInt(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return alive;
    }

    private void kill() {
        this.alive = false;
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

    private void setHp(double hp) {
        this.hp = hp;
    }

    public void attacks(int skillN, Pokemon attacked, boolean turn, boolean notComputer) {
        Random r = new Random();
        GetResource sfx = new GetResource();
        //todo @anis

        System.out.println("Attack" + new DecimalFormat("00").format(r.nextInt(12)));
//        sfx.playAudio("Attack" + new DecimalFormat("00").format(r.nextInt(12)));

        String line = name + " used " + skillName[skillN] + ". ";

        if (skillName[skillN].equals("...")) {
            accSp -= speed;
            line = "Why are you using a skill that doesn't exist..?\n";
            Combat.appendStr(line, turn, notComputer);
            return;
        }


        if (r.nextInt(101) < accuracy[skillN]) {
            line += "It is";
            if (multiplier(attacked.type) == 0) {
                line += " not effective";
            } else if (multiplier(attacked.type) == 0.5) {
                line += " not very effective";
            } else if (multiplier(attacked.type) == 1) {
                line += " effective";
            } else if (multiplier(attacked.type) == 2) {
                line += " super effective";
            }
            double damage = (((double) (attack * power[skillN] / attacked.defense) / 20) + 2) * multiplier(attacked.type);
            line += " dealing " + damage + " damage!\n";
            attacked.setHp(attacked.getHp() - damage);
            if (attacked.getHp() <= 0) {
                attacked.kill();
                line += attacked.name + " has fainted.\n";
                //todo @anis
                sfx.playAudio("Died");
            }
        } else {
            line += name + "s attack missed.\n";
        }
        accSp -= 100;
        Combat.appendStr(line, turn, notComputer);

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Name : " + name + "\nType : " + type + "\nAttack : " + attack + "\nDefense : " + defense + "\nHP : " + hp + "\nSpeed : " + speed);
        for (int i = 0; i < skillCount; i++) {
            str.append("\nSkill ").append(i + 1).append(" : ").append(skillName[i]).append("\nType : ").append(skillType[i]).append("\nPower : ").append(power[i]).append("\nAccuracy : ").append(accuracy[i]);
        }
        return str.toString();
    }

    private double multiplier(String oppType) {
        double[][] multiplierList = {
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 1.0, 0.5, 1.0},
                {1.0, 0.5, 0.5, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0},
                {1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0},
                {1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0},
                {1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 0.5, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0},
                {1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0},
                {2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 2.0, 0.0, 1.0, 2.0, 2.0, 0.5},
                {1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 0.0, 2.0},
                {1.0, 2.0, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0},
                {1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0},
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.0, 0.5, 1.0},
                {1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 0.5, 0.5},
                {1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0},
                {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0},
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 0.0},
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5},
                {1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0},
                {1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.5, 1.0}

        };

        return multiplierList[typeIndexGetter(type)][typeIndexGetter(oppType)];
    }

    private int typeIndexGetter(String type) {
        int x = 0;
        String[] typeList = tools.TypeList.getList();

        while (x < typeList.length) {
            if (typeList[x].equals(type)) {
                return x;
            }
            x++;
        }


        return x;
    }

}
