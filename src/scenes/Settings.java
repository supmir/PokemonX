package scenes;

import framework.Main;
import framework.Styles;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

class Settings {

    //todo settings page
    static Scene start() {
        final int width = 200;
        Label txt = new Label("Settings");
        txt.setMinSize(width * 2, 50);
        txt.setBorder(Styles.getBorder());
        txt.setAlignment(Pos.CENTER);


        ArrayList<Button> Buttons = new ArrayList<>();
        //add if statement only if txt config exists

        Buttons.add(new Button("Reset"));
        Buttons.add(new Button("Back"));


        for (Button button : Buttons) {
            button.setMinWidth(width);
        }

        GridPane holder = new GridPane();

        holder.setHgap(10);
        holder.setVgap(10);
        Label[] labels = new Label[4];

        String[] labelString = {
                "Border Color : ",
                "Border Style : ",
                "Corner Style : ",
                "Border Width : "
        };

        for (int i = 0; i < labelString.length; i++) {
            labels[i] = new Label(labelString[i]);
        }

        ColorPicker colorPicker = new ColorPicker(Styles.getColor());
        colorPicker.setMaxWidth(200);
        ComboBox<BorderStrokeStyle> borderStrokeStyleComboBox = new ComboBox<>();
        borderStrokeStyleComboBox.setPrefWidth(200);

        Slider radii = new Slider(0, 20, Styles.getRadii());
        Slider borderWidths = new Slider(0, 20, Styles.getBorderWidths());

        radii.setSnapToTicks(false);
        radii.setMaxWidth(200);

        borderWidths.setSnapToTicks(false);
        borderWidths.setMaxWidth(200);


        radii.valueProperty().addListener((arg0, oldValue, newValue) -> {
            Styles.setRadii(newValue.doubleValue());
            txt.setBorder(Styles.getBorder());
        });
        borderWidths.valueProperty().addListener((arg0, oldValue, newValue) -> {
            Styles.setBorderWidths(newValue.doubleValue());
            txt.setBorder(Styles.getBorder());
        });
        borderStrokeStyleComboBox.getItems().addAll(
                BorderStrokeStyle.NONE,
                BorderStrokeStyle.DASHED,
                BorderStrokeStyle.DOTTED,
                BorderStrokeStyle.SOLID
        );
        borderStrokeStyleComboBox.getSelectionModel().select(Styles.getBorderStrokeStyle());

        Buttons.get(0).setOnAction(event -> {
            Styles.setDefault();
            Main.window.setScene(SceneHandler.settings());
        });
        Buttons.get(1).setOnAction(e -> Main.window.setScene(SceneHandler.menu()));
        colorPicker.setOnAction(event -> {
            Styles.setColor(colorPicker.getValue());
            txt.setBorder(Styles.getBorder());
        });


        borderStrokeStyleComboBox.setOnAction(event -> {
            Styles.setBorderStrokeStyle(borderStrokeStyleComboBox.getValue());
            txt.setBorder(Styles.getBorder());
        });


        holder.setAlignment(Pos.CENTER);
        holder.add(txt, 0, 0, 2, 1);
        for (int i = 0; i < 4; i++) {
            holder.add(labels[i], 0, i + 1);
        }

        holder.add(colorPicker, 1, 1);
        holder.add(borderStrokeStyleComboBox, 1, 2);
        holder.add(radii, 1, 3);
        holder.add(borderWidths, 1, 4);
        holder.add(Buttons.get(0), 0, 5);
        holder.add(Buttons.get(1), 1, 5);
        return new Scene(holder, 800, 800);
    }
}
