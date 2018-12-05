package scenes;

import framework.Main;
import framework.Pokemon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Selection {

    public static Scene start(int count, String mode) {

        Random r = new Random();
        ////items


        Label top = new Label("Player " + ("computer".equals(mode) ? "" : (mode + "")) + ", go ahead");
        top.setMinSize(400, 50);
        top.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        top.setAlignment(Pos.CENTER);

        StackPane middle = new StackPane();
        ComboBox<String> pokeList = new ComboBox<>();
        pokeList.setMinWidth(250);
        Button choose = new Button("I choose you!");
        middle.setMinWidth(400);
        middle.setMaxWidth(400);
        middle.setPadding(new Insets(10));
        middle.getChildren().addAll(pokeList, choose);
        middle.setAlignment(pokeList, Pos.CENTER_LEFT);
        middle.setAlignment(choose, Pos.CENTER_RIGHT);
        GridPane.setConstraints(middle, 0, 10);


        Label bottom = new Label("Name : \nType : \nAttack : \nDefense : \nHP : \nSpeed : " +
                "\nSkill 1 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 2 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 3 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 4 : \nType : \nPower : \nAccuracy : ");

        bottom.setMinSize(400, 430);
        bottom.setPadding(new Insets(10));
        bottom.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));


        GridPane.setConstraints(bottom, 0, 11);
        ////item config
        pokeList.setPromptText("Choose your " + (count == 0 ? "first" : (count == 1 ? "second" : "third")) + " Pokémon! ");
        pokeList.getItems().addAll(SceneHandler.allList);


        //choose pokemon drop down and stuff
        if (mode.equals("computer")) {
            choose.setOnAction(e -> {
                SceneHandler.allList.remove(pokeList.getValue());
                if (count == 2) {
                    SceneHandler.setController(new Pokemon(pokeList.getValue()), 0, count);
                    for (int i = 0; i < 3; i++) {
                        SceneHandler.setController(new Pokemon(SceneHandler.allList.get(r.nextInt(SceneHandler.allList.size()))), 1, i);
                    }
                    Main.window.setScene(SceneHandler.combat(false));
                } else {
                    SceneHandler.setController(new Pokemon(pokeList.getValue()), 0, count);
                    Main.window.setScene(start(count + 1, mode));
                }
            });
        } else {
            choose.setOnAction(e -> {
                SceneHandler.allList.remove(pokeList.getValue());
                if (count == 2 && mode.equals("two")) {
                    SceneHandler.setController(new Pokemon(pokeList.getValue()), 1, count);
                    Main.window.setScene(SceneHandler.combat(true));
                } else {
                    SceneHandler.setController(new Pokemon(pokeList.getValue()), mode.equals("one") ? 0 : 1, count);
                    Main.window.setScene(start(mode.equals("one") ? count : count + 1, mode.equals("one") ? "two" : "one"));
                }
            });

        }


        pokeList.setOnAction(e -> {
            bottom.setText(new Pokemon(pokeList.getValue()).toString());
        });

        ////layout
        VBox holder = new VBox();
        holder.setPadding(new Insets(10));
        holder.getChildren().addAll(top, middle, bottom);
        holder.setAlignment(Pos.CENTER);

        return new Scene(holder, 800, 800);

    }


}
