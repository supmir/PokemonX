package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class credits {
    public static Scene credits() {

        Button back = new Button("Back");
        back.setOnAction(e -> framework.main.window.setScene(SceneHandler.menu()));
        VBox layout2 = new VBox(20);
        Label names = new Label("Amir\nMarina\nAnis\nFadh");
        layout2.getChildren().addAll(names, back);
        layout2.setAlignment(Pos.CENTER);
        return new Scene(layout2, 800, 800);

    }
}
