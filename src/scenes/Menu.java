package scenes;

import framework.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.io.File;
import java.util.ArrayList;

public class Menu {

    public static Scene start() {


        final int width = 200;
        int x = 0;
        Label txt = new Label("Welcome to Pokémon");
        txt.setMinSize(width * 2, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);


        ArrayList<Button> Buttons = new ArrayList<>();
        //add if statement only if txt config exists

        String path = System.getProperty("user.home") + "/PokemonX/fight.bin";
        File temp = new File(path);
        if (temp.exists()) {
            String path2 = System.getProperty("user.home") + "/PokemonX/LRTStr.bin";

            File temp2 = new File(path2);

            if (temp2.exists()) {
                Buttons.add(new Button("Continue"));
                x++;
                Buttons.get(0).setOnAction(event -> {
                    Main.window.setScene(SceneHandler.cont());
                });
            }
        }
        Buttons.add(new Button("New Game"));
        Buttons.add(new Button("Credits"));
        Buttons.add(new Button("Settings"));

        Buttons.add(new Button("???"));//todo hide this button to make it more special
        //todo reset button


        for (Button button : Buttons) {
            button.setMinWidth(width);

        }


        Buttons.get(x).setOnAction(e -> {
            Main.window.setScene(SceneHandler.gameMode());
        });
        Buttons.get(x + 1).setOnAction(e -> {
            SceneHandler.credits();
        });
        Buttons.get(x + 2).setOnAction(e -> {
            Main.window.setScene(SceneHandler.settings());
        });

        Buttons.get(x + 3).setOnAction(e -> {
            Main.window.setScene(SceneHandler.administrator());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(txt);
        layout1.getChildren().addAll(Buttons);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }
}
