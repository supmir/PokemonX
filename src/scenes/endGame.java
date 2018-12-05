package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class endGame {

    public static Scene start(String x) {


        Label border = new Label();
        Label txt = new Label(x.equals("Computer") ? "" : ("Player ") + x + " wins!");

        border.setMinSize(400, 50);
        border.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        StackPane stack = new StackPane();
        stack.getChildren().addAll(border, txt);

        //add if statement only if txt config exists
        Button back = new Button("Back to Main");
        Button newGame = new Button("New Game");
        Button credits = new Button("Credits");


        newGame.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.menu());
        });
        back.setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.gameMode());
        });
        credits.setOnAction(e -> {
            SceneHandler.credits();
        });

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(back, newGame, credits);
        VBox holder = new VBox(20);
        holder.getChildren().addAll(stack, buttons);
        buttons.setAlignment(Pos.CENTER);
        holder.setAlignment(Pos.CENTER);


        return new Scene(holder, 800, 800);
    }
}
