/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */


public class main extends Application {

    static Stage window;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
/*
        try {
            game.game();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
*/

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
        if (ConfirmBox.display("Exit?", "Are you sure you want to exit?")) {
            System.out.println("File is saved");
                    window.close();

        }
    }

}
