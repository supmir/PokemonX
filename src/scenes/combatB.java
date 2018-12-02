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

public class combatB {
    private static Pokemon controller[][] = SceneHandler.getController();


    public static Scene combatB(int left, int right, boolean turn) {
        //true is left,false is right
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
        System.out.println("Hello");

        StackPane bottom = new StackPane();
        bottom.setMinWidth(width);
        bottom.setMaxWidth(width);
        VBox bLeft = new VBox(10);
        bLeft.getChildren().addAll(skill);
        bLeft.getChildren().add(change);
        bottom.getChildren().add(bLeft);
        bottom.setAlignment(bLeft, Pos.CENTER_LEFT);

//        VBox bRight = new VBox(10);
//        bRight.getChildren().addAll(skill);
//        bRight.getChildren().add(change);
//        bottom.getChildren().add(bRight);
//        bottom.setAlignment(bRight, Pos.CENTER_RIGHT);

        VBox holder = new VBox(top, fightLog, bottom);
        holder.setSpacing(10);
        holder.setAlignment(Pos.CENTER);

        Scene tempScene = new Scene(holder, 800, 800);

        if (turn) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[0][left].attack(0, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
                framework.main.window.setScene(combatB(left, right, false));
            });
            skill[1].setOnAction(event -> {
                controller[0][left].attack(1, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
                framework.main.window.setScene(combatB(left, right, false));

            });
            skill[2].setOnAction(event -> {
                controller[0][left].attack(2, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
                framework.main.window.setScene(combatB(left, right, false));

            });
            skill[3].setOnAction(event -> {
                controller[0][left].attack(3, 10, "Normal", controller[1][right]);
                RStatus.setText(controller[1][right].getName() + "\n" + controller[1][right].getHp());
                framework.main.window.setScene(combatB(left, right, false));

            });
            change.setOnAction(event -> {
                System.out.println("hi");
                if (left == 2)
                    framework.main.window.setScene(combatB(0, right, true));
                else
                    framework.main.window.setScene(combatB(left + 1, right, true));
            });
        } else {
            System.out.println("Computer turn");
            tempScene = combatB(left, right, true);
            //framework.main.window.setScene(combatB(left, right,true));


        }
        return tempScene;
    }

}
