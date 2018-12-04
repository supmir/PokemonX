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
import java.util.Random;

public class administrator {
    static Random r = new Random();


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
            type.get(i).getItems().addAll(framework.typeList.typeList());
            type.get(i).getSelectionModel().selectFirst();
        }
        type.add(new ComboBox<>());
        type.get(5).setPrefWidth(150);
        type.get(5).setPromptText("Select number of skills");
        type.get(5).getSelectionModel().selectFirst();



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


        textFields.add(new TextField());//pokemon name CANNOT contain () because it is used as (custom) during game
        textFields.add(new TextField());//Type
        textFields.add(new TextField());//Attack
        textFields.add(new TextField());//Defense
        textFields.add(new TextField());//HP
        textFields.add(new TextField());//Speed
        textFields.add(new TextField());//Skill 1
        textFields.add(new TextField());//Type
        textFields.add(new TextField());//Power
        textFields.add(new TextField());//Accuracy
        textFields.add(new TextField());//Skill 2
        textFields.add(new TextField());//Type
        textFields.add(new TextField());//Power
        textFields.add(new TextField());//Accuracy
        textFields.add(new TextField());//Skill 3
        textFields.add(new TextField());//Type
        textFields.add(new TextField());//Power
        textFields.add(new TextField());//Accuracy
        textFields.add(new TextField());//Skill 4
        textFields.add(new TextField());//Type
        textFields.add(new TextField());//Power
        textFields.add(new TextField());//Accuracy


        textFields.get(0).setPromptText("Name");
        textFields.get(1).setPromptText("Type");
        textFields.get(2).setPromptText("Attack");
        textFields.get(3).setPromptText("Defense");
        textFields.get(4).setPromptText("HP");
        textFields.get(5).setPromptText("Speed");
        textFields.get(6).setPromptText("Skill 1");
        textFields.get(7).setPromptText("Type");
        textFields.get(8).setPromptText("Power");
        textFields.get(9).setPromptText("Accuracy");
        textFields.get(10).setPromptText("Skill 2");
        textFields.get(11).setPromptText("Type");
        textFields.get(12).setPromptText("Power");
        textFields.get(13).setPromptText("Accuracy");
        textFields.get(14).setPromptText("Skill 3");
        textFields.get(15).setPromptText("Type");
        textFields.get(16).setPromptText("Power");
        textFields.get(17).setPromptText("Accuracy");
        textFields.get(18).setPromptText("Skill 4");
        textFields.get(19).setPromptText("Type");
        textFields.get(20).setPromptText("Power");
        textFields.get(21).setPromptText("Accuracy");
        //TODO find out MIN and MAX
        final int MINA = 10, MAXA = 50;//att
        final int MIND = 10, MAXD = 50;//def
        final int MINH = 10, MAXH = 50;//hp
        final int MINS = 10, MAXS = 50;//sp
        final int MINP = 10, MAXP = 50;//pow
        final int MINC = 10, MAXC = 50;//acc


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
            if (master(22))
                txt.setText(pokeWriter.write(textFields, type));
            else
                txt.setText("Fix your errors");

        });


        return new Scene(layout1, 800, 800);

    }

    private static String rName() {
        String x = "";


        x += (char) (r.nextInt(26) + 65);
        for (int i = 0; i < r.nextInt(6) + 2; i++) {
            x += (char) (r.nextInt(26) + 97);
        }


        return x;
    }

    private static String rInt(int min, int max) {

        int range = max - min + 1;
        String x = String.valueOf(r.nextInt(range) + 10);

        return x;
    }


    public static boolean master(int x) {
        boolean master = true;
        boolean[] b = new boolean[22];


        switch (x) {
            case 0:
        }

        return master;
    }

}
