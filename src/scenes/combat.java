package scenes;

import framework.Pokemon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

public class combat {
    private static Pokemon[][] controller = SceneHandler.getController();
    private static String str = "PvP modeeee\n";

    public static void setStr(String str) {
        combat.str += str;
    }

    public static boolean accumulator(int left, int right, boolean turn) {
        boolean less;
        less = controller[0][left].getAccSp() <= 100 && controller[1][right].getAccSp() <= 100;
        while (less) {

            controller[0][left].adder();
            controller[1][right].adder();
            less = controller[0][left].getAccSp() <= 100 && controller[1][right].getAccSp() <= 100;
        }
        int accCompare;
        accCompare = controller[0][left].getAccSp() - controller[1][right].getAccSp();

        if (accCompare > 0) {
            turn = true;
        } else if (accCompare == 0) {
            int speedCompare;
            speedCompare = controller[0][left].getSpeed() - controller[1][right].getSpeed();

            if (speedCompare > 0) {
                turn = true;
            } else if (speedCompare == 0) {
                turn = !turn;
            } else {
                turn = false;
            }

        } else {
            turn = false;
        }

        return turn;
    }

    public static Scene combat(boolean notComputer) {//pvp notComputer is true
        return start(0, 0, accumulator(0, 0, false), notComputer);
    }

    public static Scene start(int left, int right, boolean turn, boolean notComputer) {
        //setup for both modes
        int j = 0;
        if ((lifeCheck() & 0b00000001) == 0) {//check right
            return SceneHandler.endGame("one");
        }
        if ((lifeCheck() >> 4 & 0b00000001) == 0) {//check left
            return SceneHandler.endGame("two");
        }
        final int width = 600, height = 300, dW = width + 20, dH = height;
        Label fightLog = new Label(str);
        fightLog.setMinSize(width, height);
        fightLog.setAlignment(Pos.BOTTOM_LEFT);
        ScrollPane middle = new ScrollPane();
        middle.setMinSize(dW, dH);
        middle.setPrefSize(dW, dH);
        middle.setMaxSize(dW, dH);
        middle.setContent(fightLog);
        middle.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        middle.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        middle.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        middle.setVvalue(middle.getVmax());
        middle.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.getDeltaY() != 0) {
                event.consume();
            }
        });
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
        Button[] skill = new Button[4];
        Button change = new Button("Switch");

        //computer mode setup
        if (notComputer)
            if (!accumulator(left, right, turn))
                j = 1;

        //back to both
        for (int i = 0; i < skill.length; i++) {
            skill[i] = new Button(controller[j][left].getSkillName(i));
        }

        StackPane bottom = new StackPane();
        bottom.setMinWidth(width);
        bottom.setMaxWidth(width);
        VBox skillSet = new VBox(10);
        skillSet.getChildren().addAll(skill);
        skillSet.getChildren().add(change);
        bottom.getChildren().add(skillSet);


        //computer mode setup
        if (notComputer)
            if (!accumulator(left, right, turn))
                skillSet.setAlignment(Pos.CENTER_RIGHT);

        //back to both
        VBox holder = new VBox(top, middle, bottom);
        holder.setSpacing(10);
        holder.setAlignment(Pos.CENTER);


        if (accumulator(left, right, turn)) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[0][left].attack(0, controller[1][right]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));
            });
            skill[1].setOnAction(event -> {
                controller[0][left].attack(1, controller[1][right]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            skill[2].setOnAction(event -> {
                controller[0][left].attack(2, controller[1][right]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            skill[3].setOnAction(event -> {
                controller[0][left].attack(3, controller[1][right]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            change.setOnAction(event -> {
                if (left == 2)
                    framework.main.window.setScene(start(0, right, accumulator(0, right, turn), notComputer));
                else
                    framework.main.window.setScene(start(left + 1, right, accumulator(left + 1, right, turn), notComputer));
            });
        } else if (notComputer) {//set button turn and position according to speed accumulator
            skill[0].setOnAction(event -> {
                controller[1][right].attack(0, controller[0][left]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));
            });
            skill[1].setOnAction(event -> {
                controller[1][right].attack(1, controller[0][left]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            skill[2].setOnAction(event -> {
                controller[1][right].attack(2, controller[0][left]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            skill[3].setOnAction(event -> {
                controller[1][right].attack(3, controller[0][left]);
                framework.main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

            });
            change.setOnAction(event -> {
                if (right == 2)
                    framework.main.window.setScene(start(left, 0, accumulator(left, 0, turn), notComputer));
                else
                    framework.main.window.setScene(start(left, right + 1, accumulator(left, right + 1, turn), notComputer));
            });

        } else {
            controller[1][right].attack(1, controller[0][left]);
            return start(left, right, accumulator(left, right, turn), notComputer);
        }


        Scene tempScene = new Scene(holder, 800, 800);
        if (!controller[0][left].isAlive()) {
            if (left != 2) {
                tempScene = start(left + 1, right, accumulator(left + 1, right, turn), notComputer);
            } else {
                tempScene = start(0, right, accumulator(0, right, turn), notComputer);
            }
        }
        if (!controller[1][right].isAlive()) {
            if (right != 2) {
                tempScene = start(left, right + 1, accumulator(left, right + 1, turn), notComputer);
            } else {
                tempScene = start(right, 0, accumulator(left, 0, turn), notComputer);
            }
        }
        return tempScene;
    }


    public static String healthCheck(int who, int which) {
        return controller[who][which].getName() + "\nHP : " + controller[who][which].getHp() + "\nAccumulated Speed : " + controller[who][which].getAccSp();
    }

    public static int lifeCheck() {
        int stat = 0;
        for (int i = 0; i < controller[0].length; i++) {
            stat = stat | (controller[0][i].isAlive() ? 1 : 0);
            stat = stat << 1;
        }
        if (stat != 0b0000) {
            stat = stat | 1;
            stat = stat << 1;
        }
        for (int i = 0; i < controller[1].length; i++) {
            stat = stat | (controller[1][i].isAlive() ? 1 : 0);
            stat = stat << 1;
        }
        if ((stat & 0b00001111) != 0b0000) {
            stat = stat | 1;
        }

        System.out.println("Final " + Integer.toBinaryString(stat));
        return stat;
    }
}
