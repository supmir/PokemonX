package framework;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import popups.ConfirmBoxHelper;
import tools.getres.GetResource;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scenes.SceneHandler;
import tools.CombatProgress;
import tools.LRTStr;

import java.io.File;

/**
 * @author amir
 */


public class Main extends Application {

    public static Stage window;
    private static boolean inCombat = false;
    public static Styles styles = new Styles();
    public static GetResource bgm = new GetResource();

    public static Styles getStyles() {
        return styles;
    }

    public static void main(String[] args) {


        launch(args);
    }

    public static void setInCombat(boolean inCombat) {
        Main.inCombat = inCombat;
    }

    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setResizable(false);
        window.setMaxHeight(780);
        window.setMinWidth(800);
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });

        window.setScene(SceneHandler.menu());
//        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("Pokémon X");


        bgm.playAudio("Menu");
        String path = System.getProperty("user.home") + "/PokemonX/userStyle.txt";
        File temp = new File(path);
        if (temp.exists()) {
            tools.StyleWriter.setFields();
            styles = new Styles(Color.valueOf(tools.StyleWriter.getColor()), tools.StyleWriter.getBorderStrokeStyle(), tools.StyleWriter.getRadii(), tools.StyleWriter.getBorderWidths());
        }


        window.show();

    }


    private static void exitProgram() {
        if (ConfirmBoxHelper.display("Exit?", "Are you sure you want to exit?")) {

            if (inCombat) {
                CombatProgress.writeProg();
                LRTStr.writeLRTStr();
            }

            window.close();

        }
    }

}
