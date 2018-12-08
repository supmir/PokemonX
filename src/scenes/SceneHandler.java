package scenes;

import framework.Main;
import framework.Pokemon;
import tools.CombatProgress;
import tools.LRTStr;
import tools.Writer;
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

        Main.bgm.pauseAudio();
        Credits.pop();
    }

    static Scene selection(String y) {
        allList = new framework.PokeList().getList();
        Main.bgm.stopAudio();
        Main.bgm.playAudio("Selection");
        return Selection.start(0, y);
    }

    //testtesttest
    static Scene combat(Boolean notComputer) {

        Main.bgm.stopAudio();
        Main.bgm.playAudio("Combat");

        Main.setInCombat(true);
        return Combat.start(notComputer);
    }

    static Scene endGame(String x) {
        Writer.delete(false);
        Main.setInCombat(false);

        Main.bgm.stopAudio();
        Main.bgm.playAudio("EndGame");

        return EndGame.start(x);
    }

    static Scene cont() {
        Combat.setController(CombatProgress.getProg());
        try {
            LRTStr.readLRTStr();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Combat.setStr(LRTStr.getStr());
        Combat.setStrC(LRTStr.getStrC());
        return Combat.start(LRTStr.getL(), LRTStr.getR(), LRTStr.isT(), LRTStr.isM());
    }


    static Scene settings() {
        return Settings.start();
    }
}
