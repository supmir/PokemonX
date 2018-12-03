package scenes;

import framework.Pokemon;
import javafx.scene.Scene;

import java.util.ArrayList;


public class SceneHandler {

    private static Pokemon controller[][] = new Pokemon[2][3];//player 0 is left, player 1 is right
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
        return combat.combat(notComputer);
    }

    public static Scene endGame(String x) {
        return endGame.endGame(x);
    }

    public static Scene Continue() {
        return null;
    }


}
