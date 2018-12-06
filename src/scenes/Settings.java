package scenes;

import framework.Main;
import framework.Styles;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import tools.FourLetter;

import java.util.ArrayList;

class Settings {

    //todo settings page
    static Scene start() {
        final int width = 200;
        int x = 0;
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


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(txt, colorPicker, borderStrokeStyleComboBox);
        layout1.getChildren().addAll(radii, borderWidths);
        layout1.getChildren().addAll(Buttons);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }
}
