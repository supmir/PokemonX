import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


public class SceneHandler {

    private static Pokemon[] player1 = new Pokemon[3], player2 = new Pokemon[3], bot = new Pokemon[3];
    private static ArrayList<String> allList = new PokeList().getList();

    public static Scene menu() {
        Label label1 = new Label("Welcome to Pokemon");
        //add if statement only if txt config exists
        Button contGame = new Button("Continue");
        Button newGame = new Button("New Game");
        Button credits = new Button("Credits");


        newGame.setOnAction(e -> {
            main.window.setScene(gameMode());
        });
        credits.setOnAction(e -> {
            main.window.setScene(credits());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, contGame, newGame, credits);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);
    }

    private static Scene gameMode() {
        Label label1 = new Label("Choose your game mode :");
        //add if statement only if txt config exists
        Button PvP = new Button("VS Player");
        Button PvC = new Button("VS Computer");
        Button back = new Button("Back");


        PvP.setOnAction(e -> {
            System.out.println("Not yet");
            main.window.setScene(gameMode());
        });
        PvC.setOnAction(e -> {
            main.window.setScene(selection(0, "computer"));
        });

        back.setOnAction(e -> {
            main.window.setScene(menu());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, PvP, PvC, back);
        layout1.setAlignment(Pos.CENTER);


        return new Scene(layout1, 800, 800);

    }

    private static Scene credits() {

        Button back = new Button("Back");
        back.setOnAction(e -> main.window.setScene(menu()));
        VBox layout2 = new VBox(20);
        Label names = new Label("Amir\nMarina\nAnis\nFadh");
        layout2.getChildren().addAll(names, back);
        layout2.setAlignment(Pos.CENTER);
        return new Scene(layout2, 800, 800);

    }


    public static Scene selection(int count, String mode) {

        Random r = new Random();
        ////items

        GridPane holder = new GridPane();
        holder.setPadding(new Insets(10, 10, 10, 10));
        holder.setVgap(8);
        holder.setHgap(10);

        Label txt = new Label("Player " + ("computer".equals(mode) ? "" : mode));
        GridPane.setConstraints(txt, 0, 9);

        ComboBox<String> pokeList = new ComboBox<>();
        GridPane.setConstraints(pokeList, 0, 10);


        Label stats = new Label("Name : \nType : \nAttack : \nDefense : \nHP : \nSpeed : " +
                "\nSkill 1 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 2 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 3 : \nType : \nPower : \nAccuracy : " +
                "\nSkill 4 : \nType : \nPower : \nAccuracy : ");
        GridPane.setConstraints(stats, 0, 11);
        Button choose = new Button("I choose you!");
        GridPane.setConstraints(choose, 1, 10);


        ////item config
        pokeList.setPromptText("Choose your " + (count == 0 ? "first" : (count == 1 ? "second" : "third")) + " Pokemon! ");
        pokeList.getItems().addAll(allList);


        //choose pokemon drop down and stuff
        choose.setOnAction(e -> {

            if (count == 2) {
                player1[count] = new Pokemon(pokeList.getValue());
                for (int i = 0; i < bot.length; i++) {
                    bot[i] = new Pokemon(allList.get(r.nextInt(allList.size())));
                }
                main.window.setScene(combat());
            } else {
                player1[count] = new Pokemon(pokeList.getValue());
                main.window.setScene(selection(count + 1, mode));
            }
        });


        pokeList.setOnAction(e -> {
            stats.setText(new Pokemon(pokeList.getValue()).toString());
        });

        ////layout
        holder.getChildren().addAll(txt, pokeList, stats, choose);
        holder.setAlignment(Pos.CENTER);
        return new Scene(holder, 800, 800);

    }


    public static Scene combat() {
        return combatB(0, 0);
    }

    public static Scene combat(String x) {
        return combatP(0, 0);
    }

    private static Scene combatP(int left, int right) {

        return null;
    }


    public static Scene combatB(int left, int right) {


        GridPane holder = new GridPane();
        holder.setPadding(new Insets(10, 10, 10, 10));
        holder.setVgap(8);
        holder.setHgap(10);
        Label LStatus = new Label(player1[left].getName() + "\n" + player1[left].getHp());
        Label RStatus = new Label(bot[right].getName() + "\n" + bot[right].getHp());

        GridPane.setConstraints(LStatus, 5, 0);
        GridPane.setConstraints(RStatus, 20, 0);

        Button[] skill = new Button[4];
        Button change = new Button("Switch");
        int i = 0;
        for (; i < skill.length; i++) {
            skill[i] = new Button("Skill " + (i + 1));
            GridPane.setConstraints(skill[i], 3, i + 70);
        }


        skill[0].setOnAction(event -> {
            player1[left].attack(0, 10, "Normal", bot[right]);
            RStatus.setText(bot[right].getName() + "\n" + bot[right].getHp());
        });
        skill[1].setOnAction(event -> {
            player1[left].attack(1, 10, "Normal", bot[right]);
            RStatus.setText(bot[right].getName() + "\n" + bot[right].getHp());
        });
        skill[2].setOnAction(event -> {
            player1[left].attack(2, 10, "Normal", bot[right]);
            RStatus.setText(bot[right].getName() + "\n" + bot[right].getHp());
        });
        skill[3].setOnAction(event -> {
            player1[left].attack(3, 10, "Normal", bot[right]);
            RStatus.setText(bot[right].getName() + "\n" + bot[right].getHp());
        });

        change.setOnAction(event -> {
            if (left == 2)
                main.window.setScene(combatB(0, right));
            else
                main.window.setScene(combatB(left + 1, right));
        });


        GridPane.setConstraints(change, 3, ++i + 70);


        holder.getChildren().addAll(skill);
        holder.getChildren().addAll(change, RStatus, LStatus);


        return new Scene(holder, 800, 800);
    }


}
