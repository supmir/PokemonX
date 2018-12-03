package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class menu {

    public static Scene menu() {


        final int width = 200;
        int x = 0;
        Label txt = new Label("Welcome to Pokémon");
        txt.setMinSize(width * 2, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);


        ArrayList<Button> Buttons = new ArrayList<>();
        //add if statement only if txt config exists
        if (true) {
            Buttons.add(new Button("Continue"));
            x++;
            Buttons.get(0).setOnAction(event -> {
                framework.main.window.setScene(SceneHandler.Continue());
            });
        }
        Buttons.add(new Button("New Game"));
        Buttons.add(new Button("Credits"));
        Buttons.add(new Button("???"));

        for (int i = 0; i < Buttons.size(); i++) {
            Buttons.get(i).setMinWidth(width);

        }


        Buttons.get(x + 0).setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.gameMode());
        });
        Buttons.get(x + 1).setOnAction(e -> {
            SceneHandler.credits();
        });
        Buttons.get(x + 2).setOnAction(e -> {
            framework.main.window.setScene(SceneHandler.administrator());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(txt);
        layout1.getChildren().addAll(Buttons);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }
}
