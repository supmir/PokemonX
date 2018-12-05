package scenes;

import framework.Main;
import framework.Pokemon;
import framework.PokeWriter;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;


public class SceneHandler {

    private static Pokemon[][] controller = new Pokemon[2][3];//player 0 is left, player 1 is right
    public static ArrayList<String> allList = new framework.PokeList().getList();

    public static void setController(Pokemon whichPoke, int who, int which) {
        SceneHandler.controller[who][which] = whichPoke;
    }

    public static Pokemon[][] getController() {
        return controller;
    }


    public static Scene administrator() {
        return Administrator.start();
    }
    public static Scene menu() {
        return Menu.start();
    }

    public static Scene gameMode() {
        return GameMode.start();
    }

    public static void credits() {
        Credits.pop();
    }

    public static Scene selection(int x, String y) {
        allList = new framework.PokeList().getList();
        return Selection.start(x, y);
    }

    public static Scene combat(Boolean notComputer) {
        Main.setInCombat(true);
        return Combat.start(notComputer);
    }

    public static Scene endGame(String x) {
        PokeWriter.delete(false);
        Main.setInCombat(false);
        return EndGame.start(x);
    }

    public static Scene cont() {
        Combat.setController(PokeWriter.getProg());
        try {
            PokeWriter.readLRTStr();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Combat.setStr(PokeWriter.getStr());
        Combat.setStrC(PokeWriter.getStrC());
        return Combat.start(PokeWriter.getL(), PokeWriter.getR(), PokeWriter.isT(), PokeWriter.isM());
    }


    public static Scene settings() {
        return Settings.start();
    }
}
