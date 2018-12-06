package scenes;

import framework.Main;
import framework.PokeWriter;
import framework.Styles;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

class GameMode {

    public static Scene start() {
        Label border = new Label();
        Label txt = new Label("Choose your game mode :");
        border.setMinSize(400, 50);
        border.setBorder(Styles.getBorder());
        StackPane stack = new StackPane();
        stack.getChildren().addAll(border, txt);

        //add if statement only if txt config exists
        Button PvP = new Button("VS Player");
        Button PvC = new Button("VS Computer");
        Button back = new Button("Back");
        PvP.setMinWidth(200);
        PvC.setMinWidth(200);
        back.setMinWidth(200);

        PvP.setOnAction(e -> {
            Combat.reset();
            PokeWriter.delete(false);
            Main.window.setScene(SceneHandler.selection("one"));
        });
        PvC.setOnAction(e -> {
            Combat.reset();
            PokeWriter.delete(false);
            Main.window.setScene(SceneHandler.selection("computer"));
        });

        back.setOnAction(e -> Main.window.setScene(SceneHandler.menu()));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(stack, PvP, PvC, back);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);

    }
}
