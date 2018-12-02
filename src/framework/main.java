package framework;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.stage.Stage;
import scenes.SceneHandler;

/**
 *
 * @author amir
 */


public class main extends Application {

    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });

        window.setScene(SceneHandler.menu());
        window.setTitle("Pokemon");


        window.show();

    }


    private static void exitProgram() {
        if (Popups.ConfirmBox.display("Exit?", "Are you sure you want to exit?")) {
            System.out.println("File is saved");
                    window.close();

        }
    }

}
