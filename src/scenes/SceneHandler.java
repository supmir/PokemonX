package scenes;

import framework.Pokemon;
import framework.pokeWriter;
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
        return administrator.administrator();
    }
    public static Scene menu() {
        return menu.menu();
    }

    public static Scene gameMode() {
        return gameMode.gameMode();
    }

    public static void credits() {
        credits.credits();
    }

    public static Scene selection(int x, String y) {
        allList = new framework.PokeList().getList();
        return selection.selection(x, y);
    }

    public static Scene combat(Boolean notComputer) {
        framework.main.setInCombat(true);
        return combat.combat(notComputer);
    }

    public static Scene endGame(String x) {
        pokeWriter.delete(false);
        framework.main.setInCombat(false);
        return endGame.endGame(x);
    }

    public static Scene Continue() {
        combat.setController(framework.pokeWriter.getProg());
        try {
            pokeWriter.readLRTStr();
        } catch (IOException e) {
            e.printStackTrace();
        }
        combat.setStr(pokeWriter.getStr());
        combat.setStrC(pokeWriter.getStrC());
        return combat.start(pokeWriter.getL(), pokeWriter.getR(), pokeWriter.isT(), pokeWriter.isM());
    }


    public static Scene settings() {
        return settings.settings();
    }
}
