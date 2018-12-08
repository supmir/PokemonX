package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import tools.getres.getRes;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scenes.SceneHandler;
import tools.CombatProgress;
import tools.LRTStr;

import java.io.File;
import java.io.IOException;

/**
 * @author amir
 */


public class Main extends Application {

    public static Stage window;
    private static boolean inCombat = false;
    public static Styles styles = new Styles();
    public static getRes bgm = new getRes();


    public static void main(String[] args) {

        bgm.playAudio("Menu");


        String path = System.getProperty("user.home") + "/PokemonX/userStyle.txt";
        File temp = new File(path);
        if (temp.exists()) {
            System.out.println("hi");
            tools.StyleWriter.setFields();
            styles = new Styles(Color.valueOf(tools.StyleWriter.getColor()), tools.StyleWriter.getBorderStrokeStyle(), tools.StyleWriter.getRadii(), tools.StyleWriter.getBorderWidths());
        }
        launch(args);
    }

    public static void setInCombat(boolean inCombat) {
        Main.inCombat = inCombat;
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });

        window.setScene(SceneHandler.menu());
        window.setTitle("Pokémon X");


        window.show();

    }


    private static void exitProgram() {
        if (popups.ConfirmBox.display("Exit?", "Are you sure you want to exit?")) {

            if (inCombat) {
                try {
                    CombatProgress.writeProg();
                    LRTStr.writeLRTStr();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            window.close();

        }
    }

}
