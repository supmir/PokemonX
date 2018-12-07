package scenes;

import framework.Main;
import framework.Styles;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

class EndGame {

    public static Scene start(String x) {


        Label border = new Label();
        Label txt = new Label(("Computer".equals(x) ? "" : "Player ") + x + " wins!");

        border.setMinSize(400, 50);
        border.setBorder(Styles.getBorder());
        StackPane stack = new StackPane();
        stack.getChildren().addAll(border, txt);

        //add if statement only if txt config exists
        Button back = new Button("Back to Main");
        Button newGame = new Button("New Game");
        Button credits = new Button("Credits");
//todo fix reset

        newGame.setOnAction(e -> Main.window.setScene(SceneHandler.menu()));
        back.setOnAction(e -> Main.window.setScene(SceneHandler.gameMode()));
        credits.setOnAction(e -> SceneHandler.credits());

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(back, newGame, credits);
        VBox holder = new VBox(20);
        holder.getChildren().addAll(stack, buttons);
        buttons.setAlignment(Pos.CENTER);
        holder.setAlignment(Pos.CENTER);


        return new Scene(holder, 800, 800);
    }
}
