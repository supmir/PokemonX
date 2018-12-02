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

public class combatP {
    private static Pokemon controller[][] = SceneHandler.getController();


    private static boolean accumulator(int left, int right, boolean turn) {
        boolean speedCompare, less;
        less = controller[0][left].getAccSp() < 100 && controller[1][right].getAccSp() < 100;
        while (less) {

            controller[0][left].adder();
            controller[1][right].adder();
            less = controller[0][left].getAccSp() < 100 && controller[1][right].getAccSp() < 100;
        }


        int accCompare;
        accCompare = controller[0][left].getAccSp() - controller[1][right].getAccSp();

        if (accCompare > 0) {
            turn = true;
        } else if (accCompare == 0) {
            turn = !turn;
        } else {
            turn = false;
        }

        return !turn;
    }


    public static Scene combatP(int left, int right, boolean turn) {
        String str = "PvP modeeee\n";
        final int width = 600;


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

        Label LStatus = new Label(healthCheck(0, left));
        Label RStatus = new Label(healthCheck(1, right));
        RStatus.setTextAlignment(TextAlignment.RIGHT);
        top.getChildren().addAll(LStatus, RStatus);
        top.setAlignment(LStatus, Pos.CENTER_LEFT);
        top.setAlignment(RStatus, Pos.CENTER_RIGHT);
        int i = 0, j = 0;
        if (!turn)
            j = 1;


        for (; i < skill.length; i++) {
            skill[i] = new Button(controller[j][left].getSkillName(i));
        }

        StackPane bottom = new StackPane();
        bottom.setMinWidth(width);
        bottom.setMaxWidth(width);
        VBox skillSet = new VBox(10);
        skillSet.getChildren().addAll(skill);
        skillSet.getChildren().add(change);
        bottom.getChildren().add(skillSet);
        if (!turn)
            skillSet.setAlignment(Pos.CENTER_RIGHT);


        VBox holder = new VBox(top, fightLog, bottom);
        holder.setSpacing(10);
        holder.setAlignment(Pos.CENTER);

        Scene tempScene = new Scene(holder, 800, 800);

        if (turn) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[0][left].attack(0, 10, "Normal", controller[1][right]);
                RStatus.setText(healthCheck(1, right));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));
            });
            skill[1].setOnAction(event -> {
                controller[0][left].attack(1, 10, "Normal", controller[1][right]);
                RStatus.setText(healthCheck(1, right));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            skill[2].setOnAction(event -> {
                controller[0][left].attack(2, 10, "Normal", controller[1][right]);
                RStatus.setText(healthCheck(1, right));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            skill[3].setOnAction(event -> {
                controller[0][left].attack(3, 10, "Normal", controller[1][right]);
                RStatus.setText(healthCheck(1, right));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            change.setOnAction(event -> {
                System.out.println("hi");
                if (left == 2)
                    framework.main.window.setScene(combatP(0, right, true));
                else
                    framework.main.window.setScene(combatP(left + 1, right, true));
            });
        } else {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[1][right].attack(0, 10, "Normal", controller[0][left]);
                LStatus.setText(healthCheck(0, left));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));
            });
            skill[1].setOnAction(event -> {
                controller[1][right].attack(1, 10, "Normal", controller[0][left]);
                LStatus.setText(healthCheck(0, left));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            skill[2].setOnAction(event -> {
                controller[1][right].attack(2, 10, "Normal", controller[0][left]);
                LStatus.setText(healthCheck(0, left));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            skill[3].setOnAction(event -> {
                controller[1][right].attack(3, 10, "Normal", controller[0][left]);
                LStatus.setText(healthCheck(0, left));
                framework.main.window.setScene(combatP(left, right, accumulator(left, right, turn)));

            });
            change.setOnAction(event -> {
                System.out.println("hi");
                if (left == 2)
                    framework.main.window.setScene(combatP(left, 0, false));
                else
                    framework.main.window.setScene(combatP(left, right + 1, false));
            });

        }
        return tempScene;
    }

    public static String healthCheck(int who, int which) {
        return controller[who][which].getName() + "\nHP : " + controller[who][which].getHp() + "\nAccumulated Speed : " + controller[who][which].getAccSp();
    }
}
