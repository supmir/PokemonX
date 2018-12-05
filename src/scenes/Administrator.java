package scenes;

import tools.FourLetter;
import tools.TypeList;
import framework.Pokemon;
import framework.Main;
import framework.PokeWriter;
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
import java.util.Random;

public class Administrator {
    private static Random r = new Random();


    public static Scene start() {
        //declarations


        Label txt = new Label("Create your own Pokémon!");
        Button back = new Button("Back");
        Button next = new Button("Next");
        HBox bottom = new HBox(20, back, next);
        GridPane center = new GridPane();
        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
        ArrayList<ComboBox<String>> comboBoxes = new ArrayList<>();
        comboBoxes.add(new ComboBox<>());
        comboBoxes.add(new ComboBox<>());
        {
            txt.setMinSize(600, 50);
            txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
            txt.setAlignment(Pos.CENTER);
            bottom.setAlignment(Pos.CENTER_RIGHT);
            center.setAlignment(Pos.CENTER);
            center.setVgap(10);
            center.setHgap(10);
            final int labWid = 80,
                    fieldWid = 200;
            center.getColumnConstraints().add(new ColumnConstraints(labWid));
            center.getColumnConstraints().add(new ColumnConstraints(fieldWid));
            comboBoxes.get(0).setPrefWidth(300);
            comboBoxes.get(0).setPromptText(("Pokemon type"));
            comboBoxes.get(0).getItems().addAll(TypeList.getList());
            comboBoxes.get(0).getSelectionModel().selectFirst();
            comboBoxes.get(1).setPrefWidth(300);
            comboBoxes.get(1).setPromptText("Select number of skills");
            comboBoxes.get(1).getItems().addAll("1", "2", "3", "4");
            comboBoxes.get(1).getSelectionModel().selectLast();
        }
//adding stuff into their holder
        {
            labels.add(new Label("Name :"));
            labels.add(new Label("Type :"));
            labels.add(new Label("Attack :"));
            labels.add(new Label("Defense :"));
            labels.add(new Label("HP :"));
            labels.add(new Label("Speed :"));
            labels.add(new Label("Number of Skills :"));
            labels.get(6).setPrefWidth(200);
            textFields.add(new TextField(rName()));//pokemon name CANNOT contain () because it is used as (custom) during game
            textFields.add(new TextField(rInt()));//Attack
            textFields.add(new TextField(rInt()));//Defense
            textFields.add(new TextField(rInt()));//HP
            textFields.add(new TextField(rInt()));//Speed
            center.add(labels.get(0), 0, 0);
            center.add(labels.get(1), 0, 1);
            center.add(labels.get(2), 0, 2);
            center.add(labels.get(3), 0, 3);
            center.add(labels.get(4), 0, 4);
            center.add(labels.get(5), 0, 5);
            center.add(labels.get(6), 0, 6, 2, 1);
            center.add(textFields.get(0), 1, 0);
            center.add(comboBoxes.get(0), 1, 1);
            center.add(textFields.get(1), 1, 2);
            center.add(textFields.get(2), 1, 3);
            center.add(textFields.get(3), 1, 4);
            center.add(textFields.get(4), 1, 5);
            center.add(comboBoxes.get(1), 0, 7, 2, 1);
            center.add(bottom, 0, 8, 2, 1);
        }


        VBox layout1 = new VBox(20);
        layout1.setPadding(new Insets(20));
        layout1.getChildren().addAll(txt, center);
        layout1.setAlignment(Pos.CENTER);
        //action listeners
        {
            back.setOnAction(event -> Main.window.setScene(SceneHandler.menu()));
            next.setOnAction(event -> {

                Main.window.setScene(skillPage(
                        textFields.get(0).getText() + "(Custom)" + "\n" +
                                comboBoxes.get(0).getValue() + "\n" +
                                textFields.get(1).getText() + "\n" +
                                textFields.get(2).getText() + "\n" +
                                textFields.get(3).getText() + "\n" +
                                textFields.get(4).getText() + "\n",
                        Integer.parseInt(comboBoxes.get(1).getValue()),
                        textFields.get(0).getText() + "(Custom)"));
            });
            textFields.get(0).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (textFields.get(0).getText().matches("")) {
                        textFields.get(0).setText(rName());
                        txt.setText("Pokémon name can't be that. " + FourLetter.getPhrase(1));
                    } else {
                        txt.setText(FourLetter.getPhrase(2));
                    }
                }
            });
            textFields.get(1).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (textFields.get(1).getText().matches("[1-4]\\d")) {
                        txt.setText(FourLetter.getPhrase(2));
                    } else {
                        textFields.get(1).setText(rInt());
                        txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                    }
                }
            });
            textFields.get(2).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (textFields.get(2).getText().matches("[1-4]\\d")) {
                        txt.setText(FourLetter.getPhrase(2));
                    } else {
                        textFields.get(2).setText(rInt());
                        txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                    }
                }
            });
            textFields.get(3).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (textFields.get(3).getText().matches("[1-4]\\d")) {
                        txt.setText(FourLetter.getPhrase(2));
                    } else {
                        textFields.get(3).setText(rInt());
                        txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                    }
                }
            });
            textFields.get(4).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (textFields.get(4).getText().matches("[1-4]\\d")) {
                        txt.setText(FourLetter.getPhrase(2));
                    } else {
                        textFields.get(4).setText(rInt());
                        txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                    }
                }
            });

        }

        return new Scene(layout1, 800, 800);

    }

    private static Scene skillPage(String line, int skillCount, String name) {
        if (skillCount == 0) {
            return saved(line + "$", name);
        }

        GridPane center = new GridPane();
        center.setPadding(new Insets(10));
        center.setVgap(10);
        center.setHgap(10);

        center.setAlignment(Pos.CENTER);
        final int labWid = 80, fieldWid = 200;
        center.getColumnConstraints().add(new ColumnConstraints(labWid));
        center.getColumnConstraints().add(new ColumnConstraints(fieldWid));

        Label txt = new Label("Create your own Pokémon!");
        txt.setMinSize(600, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);

        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
        Button cancel = new Button("Cancel");
        Button next = new Button("Next");


        labels.add(new Label("Skill " + (5 - skillCount) + " :"));
        labels.add(new Label("Type :"));
        labels.add(new Label("Power :"));
        labels.add(new Label("Accuracy :"));

        textFields.add(new TextField(rName()));//Skill i
        ComboBox<String> comboBox = new ComboBox<>();
        textFields.add(new TextField(rInt()));//Power
        textFields.add(new TextField(rInt()));//Accuracy

        comboBox.getItems().addAll(TypeList.getList());
        comboBox.setPrefWidth(300);
        comboBox.getSelectionModel().selectFirst();


        center.add(labels.get(0), 0, 1);
        center.add(labels.get(1), 0, 2);
        center.add(labels.get(2), 0, 3);
        center.add(labels.get(3), 0, 4);
        center.add(textFields.get(0), 1, 1);
        center.add(comboBox, 1, 2);
        center.add(textFields.get(1), 1, 3);
        center.add(textFields.get(2), 1, 4);

        cancel.setOnAction(event -> Main.window.setScene(SceneHandler.menu()));
        next.setOnAction(event -> {

            Main.window.setScene(skillPage(
                    line + textFields.get(0).getText() + "\n" +
                            comboBox.getValue() + "\n" +
                            textFields.get(1).getText() + "\n" +
                            textFields.get(2).getText() + "\n"
                    , skillCount - 1, name));
        });

        textFields.get(0).focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (textFields.get(0).getText().matches("")) {
                    textFields.get(0).setText(rName());
                    txt.setText("Skill name can't be that. " + FourLetter.getPhrase(1));
                } else {
                    txt.setText(FourLetter.getPhrase(2));
                }
            }
        });
        textFields.get(1).focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (textFields.get(1).getText().matches("[1-4]\\d")) {
                    txt.setText(FourLetter.getPhrase(2));
                } else {
                    textFields.get(1).setText(rInt());
                    txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                }
            }
        });
        textFields.get(2).focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (textFields.get(2).getText().matches("[1-4]\\d")) {
                    txt.setText(FourLetter.getPhrase(2));
                } else {
                    textFields.get(2).setText(rInt());
                    txt.setText("Put something between 10-49. " + FourLetter.getPhrase(1));
                }
            }
        });


        HBox bottom = new HBox(10);
        bottom.getChildren().addAll(cancel, next);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        center.add(bottom, 0, 5, 2, 1);
        center.setAlignment(Pos.CENTER);
        VBox holder = new VBox();
        holder.getChildren().addAll(txt, center);
        holder.setAlignment(Pos.CENTER);


        return new Scene(holder, 800, 800);
    }

    private static Scene saved(String line, String name) {
        PokeWriter.writePokemon(line);
        Label top = new Label("Your Pokémon is saved!");
        top.setMinSize(600, 50);
        top.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        top.setAlignment(Pos.CENTER);


        Label middle = new Label("Name : \nType : \nAttack : \nDefense : \nHP : \nSpeed : " +
                "\nSkill 1 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 2 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 3 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 4 : \nType : \nPower : \nAccuracy : ");

        middle.setMinSize(400, 430);
        middle.setPadding(new Insets(10));
        middle.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        middle.setText(new Pokemon(name).toString());

        Button done = new Button("Back to Menu");
        done.setAlignment(Pos.BOTTOM_CENTER);

        done.setOnAction(event -> Main.window.setScene(SceneHandler.menu()));

        ////layout
        VBox holder = new VBox(10);
        holder.setPadding(new Insets(10));
        holder.getChildren().addAll(top, middle, done);
        holder.setAlignment(Pos.CENTER);

        return new Scene(holder, 800, 800);
    }

    private static String rName() {
        String x = "";


        x += (char) (r.nextInt(26) + 65);
        for (int i = 0; i < r.nextInt(6) + 2; i++) {
            x += (char) (r.nextInt(26) + 97);
        }


        return x;
    }

    private static String rInt() {
        return rInt(10, 49);
    }

    private static String rInt(int min, int max) {

        int range = max - min + 1;
        return String.valueOf(r.nextInt(range) + 10);
    }

}
