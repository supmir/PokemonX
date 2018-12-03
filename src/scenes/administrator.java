package scenes;

import framework.main;
import framework.pokeWriter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class administrator {

    public static Scene administrator() {
        Label txt = new Label("Create your own Pokémon!");
        Button back = new Button("Back");
        Button save = new Button("Save");
        HBox bottom = new HBox(20, back, save);
        bottom.setAlignment(Pos.CENTER_RIGHT);


        GridPane center = new GridPane();
        center.setAlignment(Pos.CENTER);
        center.setVgap(10);
        center.setHgap(10);

        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
        ArrayList<ComboBox<String>> type = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            type.add(new ComboBox<>());
            type.get(i).setPrefWidth(150);
            type.get(i).setPromptText((i == 0 ? "Pokemon" : "Skill") + " type");
            type.get(i).getItems().addAll("Fire", "Water", "Grass");

        }

        txt.setMinSize(400, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);

        labels.add(new Label("Name :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Attack :"));
        labels.add(new Label("Defense :"));
        labels.add(new Label("HP :"));
        labels.add(new Label("Speed :"));
        labels.add(new Label("Skill 1 :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Power :"));
        labels.add(new Label("Accuracy :"));
        labels.add(new Label("Skill 2 :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Power :"));
        labels.add(new Label("Accuracy :"));
        labels.add(new Label("Skill 3 :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Power :"));
        labels.add(new Label("Accuracy :"));
        labels.add(new Label("Skill 4 :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Power :"));
        labels.add(new Label("Accuracy :"));


        textFields.add(new TextField("Name"));//pokemon name CANNOT contain () because it is used as (custom) during game
        textFields.add(new TextField("Type"));
        textFields.add(new TextField("Attack"));
        textFields.add(new TextField("Defense"));
        textFields.add(new TextField("HP"));
        textFields.add(new TextField("Speed"));
        textFields.add(new TextField("Skill 1"));
        textFields.add(new TextField("Type"));
        textFields.add(new TextField("Power"));
        textFields.add(new TextField("Accuracy"));
        textFields.add(new TextField("Skill 2"));
        textFields.add(new TextField("Type"));
        textFields.add(new TextField("Power"));
        textFields.add(new TextField("Accuracy"));
        textFields.add(new TextField("Skill 3"));
        textFields.add(new TextField("Type"));
        textFields.add(new TextField("Power"));
        textFields.add(new TextField("Accuracy"));
        textFields.add(new TextField("Skill 4"));
        textFields.add(new TextField("Type"));
        textFields.add(new TextField("Power"));
        textFields.add(new TextField("Accuracy"));


        for (int i = 0; i < 23; i++) {
            final int first = 6, second = 8 + first;
            if (i < first) {
                center.add(labels.get(i), 0, 1 + i);
                center.add(i != 1 ? textFields.get(i) : type.get(0), 1, 1 + i);
            } else if (i < second) {
                center.add(labels.get(i), 2, 1 + i - first);
                center.add(i != 7 ? (i != 11 ? textFields.get(i) : type.get(2)) : type.get(1), 3, 1 + i - first);

            } else if (i != 22) {

                center.add(labels.get(i), 4, 1 + i - second);
                center.add(i != 15 ? (i != 19 ? textFields.get(i) : type.get(4)) : type.get(3), 5, 1 + i - second);

            } else {
                center.add(bottom, 4, 1 + i - second, 2, 1);
            }
        }


        VBox layout1 = new VBox(20);
        final int labWid = 80, fieldWid = 150;
        center.getColumnConstraints().add(new ColumnConstraints(65));
        center.getColumnConstraints().add(new ColumnConstraints(fieldWid));
        center.getColumnConstraints().add(new ColumnConstraints(labWid));
        center.getColumnConstraints().add(new ColumnConstraints(fieldWid));
        center.getColumnConstraints().add(new ColumnConstraints(labWid));
        center.getColumnConstraints().add(new ColumnConstraints(fieldWid));

        layout1.setPadding(new Insets(20));
        layout1.getChildren().addAll(txt, center);
        layout1.setAlignment(Pos.CENTER);


        back.setOnAction(event -> main.window.setScene(SceneHandler.menu()));
        save.setOnAction(event -> {
            //TODO: fix this
            if (5 == pokeWriter.write(textFields, type)) {
                System.out.println("saved");
            } else {
                txt.setText("Your input is invalid");
            }
        });


        return new Scene(layout1, 800, 800);

    }


}
