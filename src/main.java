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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */
public class main extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);

        try {
            game.game();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });

        Label label1 = new Label("Welcome");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> {
            AlertBox.display("hi", "You are depressed");
            window.setScene(scene2);
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 800, 800);

        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        Button exit = new Button("exit");
        exit.setOnAction(e -> exitProgram());

        HBox layout2 = new HBox(20);
        layout2.getChildren().addAll(button2, exit);
        layout2.setAlignment(Pos.CENTER);

        scene2 = new Scene(layout2, 600, 600);

        window.setScene(scene1);
        window.setTitle("Ay lmao");
        window.show();

    }

    private void exitProgram() {
        if (ConfirmBox.display("You sure?", "Sureee????")) {
            System.out.println("File is saved");
                    window.close();

        }
    }

}
