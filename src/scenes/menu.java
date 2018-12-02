package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class menu {

    public static Scene menu() {
        Label txt = new Label("Welcome to Pokémon");
        txt.setMinSize(400, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);

        //add if statement only if txt config exists
        Button contGame = new Button("Continue");
        Button newGame = new Button("New Game");
        Button creditsPage = new Button("Credits");
        Button administratorPage = new Button("???");


        newGame.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.gameMode());
        });
        creditsPage.setOnAction(e -> {
            SceneHandler.credits();
        });
        administratorPage.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.administrator());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(txt, contGame, newGame, creditsPage, administratorPage);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }
}
