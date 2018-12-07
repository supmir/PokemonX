package scenes;

import framework.Main;
import framework.Pokemon;
import framework.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.Random;

class Selection {

    public static Scene start(int count, String mode) {
        Label top = new Label("Player" + ("computer".equals(mode) ? "" : (" " + mode)) + ", go ahead");
        top.setMinSize(400, 50);
        top.setBorder(Main.styles.getBorder());
        top.setAlignment(Pos.CENTER);
        StackPane middle = new StackPane();
        ComboBox<String> pokeList = new ComboBox<>();
        pokeList.setMinWidth(250);
        Button choose = new Button("I choose you!");
        middle.setMinWidth(400);
        middle.setMaxWidth(400);
        middle.setPadding(new Insets(10));
        middle.getChildren().addAll(pokeList, choose);
        StackPane.setAlignment(pokeList, Pos.CENTER_LEFT);
        StackPane.setAlignment(choose, Pos.CENTER_RIGHT);
        GridPane.setConstraints(middle, 0, 10);
        Label bottom = new Label("Name : \nType : \nAttack : \nDefense : \nHP : \nSpeed : " +
                "\nSkill 1 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 2 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 3 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 4 : \nType : \nPower : \nAccuracy : ");
        bottom.setMinSize(400, 430);
        bottom.setPadding(new Insets(10));
        bottom.setBorder(Main.styles.getBorder());
        GridPane.setConstraints(bottom, 0, 11);
        ////item config
        pokeList.setPromptText("Choose your " + (count == 0 ? "first" : (count == 1 ? "second" : "third")) + " Pokémon! ");
        pokeList.getItems().addAll(SceneHandler.allList);
        //choose pokemon drop down and stuff
        if ("computer".equals(mode)) {
            setComputerAction(choose, pokeList, count);
        } else {
            setNotComputerAction(choose, pokeList, count, mode);
        }

        pokeList.setOnAction(e -> bottom.setText(new Pokemon(pokeList.getValue()).toString()));
        ////layout
        VBox holder = new VBox();
        holder.setPadding(new Insets(10));
        holder.getChildren().addAll(top, middle, bottom);
        holder.setAlignment(Pos.CENTER);
        return new Scene(holder, 800, 800);

    }

    private static void setComputerAction(Button choose, ComboBox<String> pokeList, int count) {
        Random r = new Random();
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
                Main.window.setScene(start(count + 1, "computer"));
            }
        });
    }

    private static void setNotComputerAction(Button choose, ComboBox<String> pokeList, int count, String mode) {
        choose.setOnAction(e -> {
            SceneHandler.allList.remove(pokeList.getValue());
            if (count == 2 && "two".equals(mode)) {
                SceneHandler.setController(new Pokemon(pokeList.getValue()), 1, count);
                Main.window.setScene(SceneHandler.combat(true));
            } else {
                SceneHandler.setController(new Pokemon(pokeList.getValue()), "one".equals(mode) ? 0 : 1, count);
                Main.window.setScene(start("one".equals(mode) ? count : count + 1, "one".equals(mode) ? "two" : "one"));
            }
        });
    }
}
