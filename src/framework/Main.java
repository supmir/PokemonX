package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.stage.Stage;
import scenes.SceneHandler;

import java.io.IOException;

/**
 * @author amir
 */


public class Main extends Application {

    public static Stage window;
    private static boolean inCombat = false;

    public static void main(String[] args) {
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

            if (inCombat)
                try {
                    PokeWriter.writeProg();
                    PokeWriter.writeLRTStr();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            window.close();

        }
    }

}
