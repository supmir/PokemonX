package scenes;

import framework.Main;
import framework.Styles;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import popups.AlertBoxHelper;

import java.util.ArrayList;

class Settings {
    static Scene start() {
        Styles temp = Main.getStyles();
        final double width = 400;
        Label txt = new Label("Settings");
        txt.setPrefSize(width, 50);
        txt.setBorder(temp.getBorder());
        txt.setAlignment(Pos.CENTER);


        ArrayList<Button> Buttons = new ArrayList<>();
        //add if statement only if txt config exists

        Buttons.add(new Button("Reset"));
        Buttons.add(new Button("Save and Back"));


        for (Button button : Buttons) {
            button.setPrefWidth(width);
            button.setAlignment(Pos.CENTER);
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
            labels[i].setAlignment(Pos.CENTER);

        }

        ColorPicker colorPicker = new ColorPicker(temp.getColor());
        colorPicker.setPrefWidth(width * 4 / 6);
        ComboBox<BorderStrokeStyle> borderStrokeStyleComboBox = new ComboBox<>();
        borderStrokeStyleComboBox.setPrefWidth(width * 4 / 6);

        Slider radii = new Slider(0, 20, temp.getRadii());
        Slider borderWidths = new Slider(0, 20, temp.getBorderWidths());
        radii.setSnapToTicks(false);
        radii.setPrefWidth(width * 4 / 6);

        borderWidths.setSnapToTicks(false);
        borderWidths.setPrefWidth(width * 4 / 6);


        radii.valueProperty().addListener((arg0, oldValue, newValue) -> {
            temp.setRadii(newValue.doubleValue());
            txt.setBorder(temp.getBorder());
        });
        borderWidths.valueProperty().addListener((arg0, oldValue, newValue) -> {
            temp.setBorderWidths(newValue.doubleValue());
            txt.setBorder(temp.getBorder());
        });
        borderStrokeStyleComboBox.getItems().addAll(
                BorderStrokeStyle.NONE,
                BorderStrokeStyle.DASHED,
                BorderStrokeStyle.DOTTED,
                BorderStrokeStyle.SOLID
        );
        borderStrokeStyleComboBox.getSelectionModel().select(temp.getBorderStrokeStyle());

        Buttons.get(0).setOnAction(event -> {
            Main.styles.setDefault();
            Main.window.setScene(SceneHandler.settings());
        });
        Buttons.get(1).setOnAction(e -> {

            temp.writeStyles();
            AlertBoxHelper.display("Style saved.", "Your changes has been saved.");
            Main.styles = temp;
            Main.window.setScene(SceneHandler.menu());
        });


        colorPicker.setOnAction(event -> {
            temp.setColor(colorPicker.getValue());
            txt.setBorder(temp.getBorder());
        });


        borderStrokeStyleComboBox.setOnAction(event -> {
            temp.setBorderStrokeStyle(borderStrokeStyleComboBox.getValue());
            txt.setBorder(temp.getBorder());
        });


        holder.setAlignment(Pos.CENTER);
        holder.add(txt, 0, 0, 2, 1);
        for (int i = 0; i < 4; i++) {
            holder.add(labels[i], 0, i + 1);
        }


        HBox buttonHolder = new HBox(10);
        buttonHolder.getChildren().addAll(Buttons);


        holder.add(colorPicker, 1, 1);
        holder.add(borderStrokeStyleComboBox, 1, 2);
        holder.add(radii, 1, 3);
        holder.add(borderWidths, 1, 4);
        holder.add(buttonHolder, 0, 5, 2, 1);

        GridPane.setHalignment(colorPicker, HPos.CENTER);
        GridPane.setHalignment(borderStrokeStyleComboBox, HPos.CENTER);
        GridPane.setHalignment(radii, HPos.CENTER);
        GridPane.setHalignment(borderWidths, HPos.CENTER);
        GridPane.setHalignment(buttonHolder, HPos.CENTER);


        final int labWid = 100,
                fieldWid = 250;
        holder.getColumnConstraints().add(new ColumnConstraints(labWid));
        holder.getColumnConstraints().add(new ColumnConstraints(fieldWid));

        RowConstraints[] rowConstraints = new RowConstraints[6];
        for (int i = 0; i < rowConstraints.length; i++) {
            rowConstraints[i] = new RowConstraints();
            rowConstraints[i].setMinHeight(20);
        }


        holder.getRowConstraints().addAll(rowConstraints);




        return new Scene(holder, 800, 800);
    }
}
