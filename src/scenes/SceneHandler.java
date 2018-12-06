package scenes;

import framework.Main;
import framework.Pokemon;
import framework.PokeWriter;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;


public class SceneHandler {

    private static final Pokemon[][] controller = new Pokemon[2][3];//player 0 is left, player 1 is right
    static ArrayList<String> allList = new framework.PokeList().getList();

    static void setController(Pokemon whichPoke, int who, int which) {
        SceneHandler.controller[who][which] = whichPoke;
    }

    static Pokemon[][] getController() {
        return controller;
    }


    static Scene administrator() {
        return Administrator.start();
    }
    public static Scene menu() {
        return Menu.start();
    }

    static Scene gameMode() {
        return GameMode.start();
    }

    static void credits() {
        Credits.pop();
    }

    static Scene selection(int x, String y) {
        allList = new framework.PokeList().getList();
        return Selection.start(x, y);
    }

    static Scene combat(Boolean notComputer) {
        Main.setInCombat(true);
        return Combat.start(notComputer);
    }

    static Scene endGame(String x) {
        PokeWriter.delete(false);
        Main.setInCombat(false);
        return EndGame.start(x);
    }

    static Scene cont() {
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


    static Scene settings() {
        return Settings.start();
    }
}
