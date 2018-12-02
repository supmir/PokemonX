package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class menu {

    public static Scene menu() {
        Label border = new Label();
        Label txt = new Label("Welcome to Pokemon");
        border.setMinSize(400, 50);
        border.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(border, txt);

        //add if statement only if txt config exists
        Button contGame = new Button("Continue");
        Button newGame = new Button("New Game");
        Button credits = new Button("Credits");


        newGame.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.gameMode());
        });
        credits.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.credits());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(stack, contGame, newGame, credits);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }
}
