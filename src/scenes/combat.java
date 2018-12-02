package scenes;

import framework.Pokemon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

public class combat {

    private static Pokemon controller[][] = SceneHandler.getController();

    public static Scene combat() {
        return combatB(0, 0);
    }

    public static Scene combat(String x) {
        return combatP(0, 0);
    }


    public static Scene combatP(int left, int right) {


        int attacker = 1, defender = 0;
        GridPane holder = new GridPane();
        holder.setPadding(new Insets(10, 10, 10, 10));
        holder.setVgap(8);
        holder.setHgap(10);
        Label LStatus = new Label(controller[0][left].getName() + "\n" + controller[0][left].getHp());
        Label RStatus = new Label(controller[1][right].getName() + "\n" + controller[1][right].getHp());
        Button[] skill = new Button[4];
        Button change = new Button("Switch");
        GridPane.setConstraints(LStatus, 5, 0);
        GridPane.setConstraints(RStatus, 20, 0);


        int i = 0;
        for (; i < skill.length; i++) {
            skill[i] = new Button("Skill " + (i + 1));
            GridPane.setConstraints(skill[i], 3, i + 70);
        }
        GridPane.setConstraints(change, 3, ++i + 70);

        if (true) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[0][left].attack(0, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[1].setOnAction(event -> {
                controller[0][left].attack(1, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[2].setOnAction(event -> {
                controller[0][left].attack(2, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[3].setOnAction(event -> {
                controller[0][left].attack(3, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            change.setOnAction(event -> {
                if (left == 2)
                    framework.main.window.setScene(combatB(0, right));
                else
                    framework.main.window.setScene(combatB(left + 1, right));
            });
        } else {
        }


        holder.getChildren().addAll(skill);
        holder.getChildren().addAll(change, RStatus, LStatus);


        return new Scene(holder, 800, 800);
    }


    public static Scene combatB(int left, int right) {
        String str = "Hello\n";
        final int width = 600;
        int attacker = 1, defender = 0;


        Label fightLog = new Label(str);
        fightLog.setMinSize(width, 300);
        fightLog.setMaxSize(width, 300);
        fightLog.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        fightLog.setAlignment(Pos.TOP_LEFT);
        Button[] skill = new Button[4];
        Button change = new Button("Switch");


        StackPane top = new StackPane();
        top.setMinWidth(width);
        top.setMaxWidth(width);
        top.setPadding(new Insets(0));

        Label LStatus = new Label(controller[0][left].getName() + "\nHP : " + controller[0][left].getHp());
        Label RStatus = new Label(controller[1][right].getName() + "\nHP : " + controller[1][right].getHp());
        RStatus.setTextAlignment(TextAlignment.RIGHT);
        top.getChildren().addAll(LStatus, RStatus);
        top.setAlignment(LStatus, Pos.CENTER_LEFT);
        top.setAlignment(RStatus, Pos.CENTER_RIGHT);


        int i = 0;
        for (; i < skill.length; i++) {
            skill[i] = new Button(controller[0][left].getSkillName(i));
        }

        if (true) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[0][left].attack(0, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[1].setOnAction(event -> {
                controller[0][left].attack(1, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[2].setOnAction(event -> {
                controller[0][left].attack(2, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            skill[3].setOnAction(event -> {
                controller[0][left].attack(3, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
            });
            change.setOnAction(event -> {
                if (left == 2)
                    framework.main.window.setScene(combatB(0, right));
                else
                    framework.main.window.setScene(combatB(left + 1, right));
            });
        } else {
        }

        StackPane bottom = new StackPane();
        bottom.setMinWidth(width);
        bottom.setMaxWidth(width);
        VBox bLeft = new VBox(10);
        VBox bRight = new VBox(10);
        bLeft.getChildren().addAll(skill);
        bLeft.getChildren().add(change);
        bRight.getChildren().addAll(skill);
        bRight.getChildren().add(change);
        bottom.getChildren().add(bLeft);
        bottom.setAlignment(bLeft, Pos.CENTER_LEFT);
        bottom.getChildren().add(bRight);
        bottom.setAlignment(bRight, Pos.CENTER_RIGHT);

        VBox holder = new VBox(top, fightLog, bottom);
        holder.setSpacing(10);
        holder.setAlignment(Pos.CENTER);
        return new Scene(holder, 800, 800);
    }

}
