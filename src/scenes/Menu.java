package scenes;

import imagegetter.ImgGet;
import framework.Main;
import framework.Styles;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.util.ArrayList;

class Menu {
    //todo reset game if user files are corrupt
    public static Scene start() {
        final int width = 200;
        int x = 0;

        ImageView imageHolder = new ImageView();
        imageHolder.setImage(ImgGet.imgGet());

        Label txt = new Label("Welcome to Pokémon");
        txt.setMinSize(width * 2, 50);
        txt.setStyle("-fx-background-color: white;");
        txt.setBorder(Main.styles.getBorder());
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
                Buttons.get(0).setOnAction(event -> Main.window.setScene(SceneHandler.cont()));
            }
        }
        Buttons.add(new Button("New Game"));
        Buttons.add(new Button("Credits"));
        Buttons.add(new Button("Settings"));

        Buttons.add(new Button("Reset"));//todo make reset button work


        for (Button button : Buttons) {
            button.setMinWidth(width);

        }


        Buttons.get(x).setOnAction(e -> Main.window.setScene(SceneHandler.gameMode()));
        Buttons.get(x + 1).setOnAction(e -> SceneHandler.credits());
        Buttons.get(x + 2).setOnAction(e -> Main.window.setScene(SceneHandler.settings()));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(txt);
        layout1.getChildren().addAll(Buttons);
        layout1.setAlignment(Pos.CENTER);

        StackPane all = new StackPane();
        all.getChildren().addAll(imageHolder, layout1);


        return new Scene(all, 800, 800);
    }
}
