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
import tools.getres.GetResource;

public class Credits {
    static Boolean stay = false;


    public static void pop() {
        GetResource popBgm = new GetResource();
        popBgm.playAudio("Credits");
        //todo change to gridpane
        Text amir = new Text("Amir Bin Iskandar (Head and Shoulder Knees Mentos)\n");
        Text marina = new Text("Nur Marina Binti Wan Mahathir Awang Hijau\n");
        Text anis = new Text("Nurus Siti Anis Wafiah Binti Mas Sokar \n");
        Text fadh = new Text("Fadh Fadh Siku Lipat Siapa Cepat Dia Dapat\n");
        Text team = new Text("Kacang");
        Text dash = new Text("-");
        Text team2 = new Text("Kacang Jaring\n");

        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Credits");
        window.setMinWidth(500);
        window.setMinHeight(250);


        TextFlow txt = new TextFlow(amir, marina, anis, fadh, team, dash, team2);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            popBgm.stopAudio();
            Main.bgm.continueAudio();
            window.close();
        });
        VBox layout = new VBox(20);
        Button magic = new Button("???");
        layout.getChildren().add(magic);
        magic.setVisible(false);
        magic.setOnAction(e -> {
            window.close();
            Main.window.setScene(SceneHandler.administrator());
        });
        layout.getChildren().addAll(txt, closeButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);


        dash.setOnMouseEntered(event -> {
            popBgm.pauseAudio();
            magic.setVisible(true);
        });
        dash.setOnMouseClicked(event -> stay = !stay);
        dash.setOnMouseExited(event -> {
            popBgm.continueAudio();
            if (!stay)
                magic.setVisible(false);
        });

        Scene scene = new Scene(layout);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {

                popBgm.pauseAudio();
                magic.setVisible(true);
                //this part might cause a duplicate children added error, but it's fine.
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {

                popBgm.continueAudio();
                magic.setVisible(false);
            }
        });
        window.setOnCloseRequest(event -> {
            event.consume();
            popBgm.stopAudio();
            Main.bgm.continueAudio();
            window.close();
        });

        window.setScene(scene);
        window.showAndWait();
    }

}
