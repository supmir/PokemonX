package scenes;

import framework.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

class Credits {


    public static void pop() {


        //todo change to gridpane
        Text amir = new Text("Amir\n");
        Text marina = new Text("Marina\n");
        Text anis = new Text("Anis\n");
        Text fadh = new Text("Fadh\n");
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Credits");
        window.setMinWidth(500);
        window.setMinHeight(250);


        TextFlow txt = new TextFlow(amir, marina, anis, fadh);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(20);
        Button magic = new Button("???");
        magic.setOnAction(e -> Main.window.setScene(SceneHandler.administrator()));
        layout.getChildren().addAll(txt, closeButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);


        amir.setOnMouseEntered(event -> {
            layout.getChildren().add(magic);
        });
        amir.setOnMouseExited(event -> {
            layout.getChildren().remove(magic);
        });

        Scene scene = new Scene(layout);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                layout.getChildren().add(magic);
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                layout.getChildren().remove(magic);
            }
        });
        window.setScene(scene);
        window.showAndWait();
    }

}
