package scenes;

import framework.Pokemon;
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
import java.util.Random;

public class administrator {
    static Random r = new Random();


    public static Scene administrator() {
        Label txt = new Label("Create your own Pokémon!");
        Button back = new Button("Back");
        Button next = new Button("Next");
        HBox bottom = new HBox(20, back, next);
        bottom.setAlignment(Pos.CENTER_RIGHT);


        GridPane center = new GridPane();
        center.setAlignment(Pos.CENTER);
        center.setVgap(10);
        center.setHgap(10);

        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
        ArrayList<ComboBox<String>> comboBoxes = new ArrayList<>();

        comboBoxes.add(new ComboBox<>());
        comboBoxes.get(0).setPrefWidth(300);
        comboBoxes.get(0).setPromptText(("Pokemon type"));
        comboBoxes.get(0).getItems().addAll(framework.typeList.typeList());
        comboBoxes.get(0).getSelectionModel().selectFirst();
        comboBoxes.add(new ComboBox<>());
        comboBoxes.get(1).setPrefWidth(300);
        comboBoxes.get(1).setPromptText("Select number of skills");
        comboBoxes.get(1).getItems().addAll("1", "2", "3", "4");
        comboBoxes.get(1).getSelectionModel().selectLast();

        txt.setMinSize(400, 50);
        txt.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        txt.setAlignment(Pos.CENTER);

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


        final int labWid = 80, fieldWid = 200;
        center.getColumnConstraints().add(new ColumnConstraints(labWid));
        center.getColumnConstraints().add(new ColumnConstraints(fieldWid));

        VBox layout1 = new VBox(20);
        layout1.setPadding(new Insets(20));
        layout1.getChildren().addAll(txt, center);
        layout1.setAlignment(Pos.CENTER);
        back.setOnAction(event -> main.window.setScene(SceneHandler.menu()));
        next.setOnAction(event -> {

            main.window.setScene(skillPage(
                    textFields.get(0).getText() + "(Custom)" + "\n" +
                            comboBoxes.get(0).getValue() + "\n" +
                            textFields.get(1).getText() + "\n" +
                            textFields.get(2).getText() + "\n" +
                            textFields.get(3).getText() + "\n" +
                            textFields.get(4).getText() + "\n",
                    Integer.parseInt(comboBoxes.get(1).getValue()),
                    textFields.get(0).getText() + "(Custom)"));
        });


        return new Scene(layout1, 800, 800);

    }

    private static Scene skillPage(String line, int skillCount, String name) {
        if (skillCount == 0) {
            return done(line + "$", name);
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
        txt.setMinSize(400, 50);
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

        comboBox.getItems().addAll(framework.typeList.typeList());
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

        cancel.setOnAction(event -> main.window.setScene(SceneHandler.menu()));
        next.setOnAction(event -> {

            main.window.setScene(skillPage(
                    line + textFields.get(0).getText() + "\n" +
                            comboBox.getValue() + "\n" +
                            textFields.get(1).getText() + "\n" +
                            textFields.get(2).getText() + "\n"
                    , skillCount - 1, name));
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

    private static Scene done(String line, String name) {
        pokeWriter.write(line);
        Label top = new Label("Your Pokémon is saved!");
        top.setMinSize(400, 50);
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

        done.setOnAction(event -> main.window.setScene(SceneHandler.menu()));

        ////layout
        VBox holder = new VBox(10);
        holder.setPadding(new Insets(10));
        holder.getChildren().addAll(top, middle, done);
        holder.setAlignment(Pos.CENTER);

        return new Scene(holder, 800, 800);
    }

/*
        {
        textFields.get(0).focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (textFields.get(0).getText().matches(".*\\(Custom\\).*") || textFields.get(0).getText().matches("")) {
                    textFields.get(0).setText(rName());
                    txt.setText("Name can't be that");
                } else {
                    System.out.println(textFields.get(0).getText());
                    txt.setText("Cool name!");
                }


            }
        });
        textFields.get(6).focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (textFields.get(6).getText().matches("")) {
                    textFields.get(6).setText(rName());
                    txt.setText("Skill name can't be that");
                } else {
                    System.out.println(textFields.get(6).getText());
                    txt.setText("Cool name!");
                }
            }
        });

        textFields.get(10).focusedProperty().addListener((arg0, oldValue, newValue) -> {//10
            if (!newValue) {
                if (textFields.get(10).getText().matches("")) {
                    textFields.get(10).setText(rName());
                    txt.setText("Skill name can't be that");
                } else {
                    System.out.println(textFields.get(10).getText());
                    txt.setText("Cool name!");
                }
            }
        });

        textFields.get(14).focusedProperty().addListener((arg0, oldValue, newValue) -> {//14
            if (!newValue) {
                if (textFields.get(14).getText().matches("")) {
                    textFields.get(14).setText(rName());
                    txt.setText("Skill name can't be that");
                } else {
                    System.out.println(textFields.get(14).getText());
                    txt.setText("Cool name!");
                }
            }
        });
        textFields.get(18).focusedProperty().addListener((arg0, oldValue, newValue) -> {//18
            if (!newValue) {
                if (textFields.get(18).getText().matches("")) {
                    textFields.get(18).setText(rName());
                    txt.setText("Skill name can't be that");
                } else {
                    System.out.println(textFields.get(18).getText());
                    txt.setText("Cool name!");
                }
            }
        });
    }

//START OF SUPER LONG ANNOYING CODE
        {
            textFields.get(2).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(2).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(2).setText(rInt(MINA, MAXA));
                        txt.setText("Put something between " + MINA + "-" + MAXA);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(3).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(3).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(3).setText(rInt(MIND, MAXD));
                        txt.setText("Put something between " + MIND + "-" + MAXD);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(4).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(4).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(4).setText(rInt(MINH, MAXH));
                        txt.setText("Put something between " + MINH + "-" + MAXH);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(5).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(5).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(5).setText(rInt(MINS, MAXS));
                        txt.setText("Put something between " + MINS + "-" + MAXS);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });


            textFields.get(8).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(8).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(8).setText(rInt(MINP, MAXP));
                        txt.setText("Put something between " + MINP + "-" + MAXP);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(9).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(9).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(9).setText(rInt(MINC, MAXC));
                        txt.setText("Put something between " + MINC + "-" + MAXC);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });


            textFields.get(12).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(12).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(12).setText(rInt(MINP, MAXP));
                        txt.setText("Put something between " + MINP + "-" + MAXP);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(13).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(13).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(13).setText(rInt(MINC, MAXC));
                        txt.setText("Put something between " + MINC + "-" + MAXC);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });


            textFields.get(16).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(16).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(16).setText(rInt(MINP, MAXP));
                        txt.setText("Put something between " + MINP + "-" + MAXP);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(17).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(17).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(17).setText(rInt(MINC, MAXC));
                        txt.setText("Put something between " + MINC + "-" + MAXC);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });


            textFields.get(20).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(20).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(20).setText(rInt(MINP, MAXP));
                        txt.setText("Put something between " + MINP + "-" + MAXP);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
            textFields.get(21).focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) {
                    if (!textFields.get(21).getText().matches("\0|[1-4]\\d")) {
                        textFields.get(21).setText(rInt(MINC, MAXC));
                        txt.setText("Put something between " + MINC + "-" + MAXC);
                    } else {
                        txt.setText("Nice");
                    }
                }
            });
        }
*/
//
//        for (int i = 0; i < 23; i++) {
//            final int first = 6, second = 8 + first;
//            if (i < first) {
//                center.add(labels.get(i), 0, 1 + i);
//                center.add(i != 1 ? textFields.get(i) : type.get(0), 1, 1 + i);
//            } else if (i < second) {
//                center.add(labels.get(i), 2, 1 + i - first);
//                center.add(i != 7 ? (i != 11 ? textFields.get(i) : type.get(2)) : type.get(1), 3, 1 + i - first);
//
//            } else if (i != 22) {
//
//                center.add(labels.get(i), 4, 1 + i - second);
//                center.add(i != 15 ? (i != 19 ? textFields.get(i) : type.get(4)) : type.get(3), 5, 1 + i - second);
//
//            } else {
//                center.add(bottom, 4, 1 + i - second, 2, 1);
//            }
//        }


    private static String rName() {
        String x = "";


        x += (char) (r.nextInt(26) + 65);
        for (int i = 0; i < r.nextInt(6) + 2; i++) {
            x += (char) (r.nextInt(26) + 97);
        }


        return x;
    }


    private static String rInt() {
        return rInt(10, 50);
    }

    private static String rInt(int min, int max) {

        int range = max - min + 1;
        String x = String.valueOf(r.nextInt(range) + 10);

        return x;
    }

}
