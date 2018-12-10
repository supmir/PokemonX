package scenes;

import framework.Main;
import javafx.scene.image.ImageView;
import tools.Writer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import tools.getres.GetResource;

class GameMode {

    public static Scene start() {
        ImageView imageHolder = new ImageView();

        GetResource get = new GetResource();
        imageHolder.setImage(get.getImage("backgd"));


        Label border = new Label();
        Label txt = new Label("Choose your game mode :");
        border.setMinSize(400, 50);
        border.setBorder(Main.styles.getBorder());
        border.setStyle("-fx-background-color: white;");
        StackPane stack = new StackPane();
        stack.getChildren().addAll(border, txt);

        //add if statement only if txt config exists
        Button PvP = new Button("VS Player");
        Button PvC = new Button("VS Computer");
        Button back = new Button("Back to Menu");
        PvP.setMinWidth(200);
        PvC.setMinWidth(200);
        back.setMinWidth(200);

        PvP.setOnAction(e -> {
            Combat.reset();
            Writer.delete(false);
            Main.window.setScene(SceneHandler.selection("one"));
        });
        PvC.setOnAction(e -> {
            Combat.reset();
            Writer.delete(false);
            Main.window.setScene(SceneHandler.selection("computer"));
        });

        back.setOnAction(e -> Main.window.setScene(SceneHandler.menu()));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(stack, PvP, PvC, back);
        layout1.setAlignment(Pos.CENTER);

        StackPane all = new StackPane();
        all.getChildren().addAll(imageHolder, layout1);

        return new Scene(all, 800, 800);

    }
}
