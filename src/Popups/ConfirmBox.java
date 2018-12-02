package Popups;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */
public class ConfirmBox {

    static boolean answer = false;

    public static boolean display(String title, String message) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        label.setAlignment(Pos.CENTER);
        Button yes = new Button("Yes");
        yes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        Button no = new Button("No");
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });
        VBox layout = new VBox(20);
        HBox butts = new HBox(20);
        butts.setAlignment(Pos.CENTER);
        butts.getChildren().addAll(yes, no);
        layout.getChildren().addAll(label, butts);
        layout.setPadding(new Insets(20));

        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
