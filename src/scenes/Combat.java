package scenes;

import framework.Main;
import javafx.scene.Node;
import tools.FourLetter;
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

import java.util.Random;

public class Combat {
    private static Pokemon[][] controller = SceneHandler.getController();
    private static String str = "Let the battle begin!!!\n";
    private static int L, R;
    private static boolean T, M;
    private static String strC = "Computer : Hello, you ready to get CRUSHED?";

    private final static int
            fightWidth = 600,
            fightHeight = 300,
            dFightWidth = fightWidth + 20,
            dFightHeight = fightHeight - 1,
            computerWidth = 400,
            computerHeight = 200,
            buttonWidth = 200;

    static void setController(Pokemon[][] controller) {
        Combat.controller = controller;
    }

    public static Pokemon[][] getController() {
        return controller;
    }

    public static void appendStr(String str, boolean turn, boolean notComputer) {

        Combat.str += (turn ? (notComputer ?
                "Player 1 : " :
                "Computer : ") :
                "Player 2 : ") + str;
    }

    static void setStr(String str) {
        Combat.str = str;
    }

    static void setStrC(String strC) {
        Combat.strC = strC;
    }

    private static boolean accumulator(int left, int right, boolean turn) {
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
        } else if (accCompare == 0) {//todo this will cause bug because accumulator counts even if its just a second check
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

    public static Scene start(boolean notComputer) {//pvp notComputer is true
        return start(0, 0, accumulator(0, 0, false), notComputer);
    }


    private static Node getTopNode(int left, int right) {

        StackPane top = new StackPane();
        top.setMinWidth(fightWidth);
        top.setMaxWidth(fightWidth);
        top.setPadding(new Insets(0));
        Label LStatus = new Label(healthCheck(0, left));
        Label RStatus = new Label(healthCheck(1, right));
        RStatus.setTextAlignment(TextAlignment.RIGHT);
        top.getChildren().addAll(LStatus, RStatus);
        StackPane.setAlignment(LStatus, Pos.CENTER_LEFT);
        StackPane.setAlignment(RStatus, Pos.CENTER_RIGHT);


        return top;
    }

    private static Node getMiddleNode() {
        Label fightLog = new Label(str);
        fightLog.setMinSize(fightWidth, fightHeight);
        fightLog.setAlignment(Pos.BOTTOM_LEFT);
//todo differentiate player moves (use color); arrayList of strings, color using controller code
        //.split of string also works
        ScrollPane middle = new ScrollPane();
        middle.setMinSize(dFightWidth, dFightHeight);
        middle.setPrefSize(dFightWidth, dFightHeight);
        middle.setMaxSize(dFightWidth, dFightHeight);
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
        return middle;
    }

    private static void setComputerBottomNode(StackPane bottom, int left, int right, boolean turn) {

        Label computer = new Label(strC);
        computer.setMinSize(computerWidth + 20, dFightHeight);
        computer.setAlignment(Pos.BOTTOM_LEFT);
        ScrollPane computerHolder = new ScrollPane();
        computerHolder.setPrefSize(computerWidth, computerHeight);
        computerHolder.setMinSize(computerWidth, computerHeight);
        computerHolder.setMaxSize(computerWidth, computerHeight);
        computerHolder.setContent(computer);
        computerHolder.setBorder(new Border(new BorderStroke(Paint.valueOf("gray"), BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        computerHolder.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        computerHolder.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        computerHolder.setVvalue(computerHolder.getVmax());
        computerHolder.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.getDeltaY() != 0) {
                event.consume();
            }
        });


        StackPane.setAlignment(computerHolder, Pos.CENTER_RIGHT);
        bottom.getChildren().add(0, computerHolder);
        if (!accumulator(left, right, turn)) {
            computer.setText(strC + "\nComputer : " + FourLetter.getPhrase(1));
            strC = computer.getText();
        }
    }

    private static void setLeftButton(Button[] skill, Button change, int left, int right, boolean turn, boolean notComputer) {

        skill[0].setOnAction(event -> {
            controller[0][left].attacks(0, controller[1][right], turn, notComputer);
            Main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));
        });
        skill[1].setOnAction(event -> {
            controller[0][left].attacks(1, controller[1][right], turn, notComputer);
            Main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

        });
        skill[2].setOnAction(event -> {
            controller[0][left].attacks(2, controller[1][right], turn, notComputer);
            Main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

        });
        skill[3].setOnAction(event -> {
            controller[0][left].attacks(3, controller[1][right], turn, notComputer);
            Main.window.setScene(start(left, right, accumulator(left, right, turn), notComputer));

        });
        change.setOnAction(event -> {
            if (left == 2) {
                Main.window.setScene(start(0, right, accumulator(0, right, turn), notComputer));
            } else {
                Main.window.setScene(start(left + 1, right, accumulator(left + 1, right, turn), notComputer));
            }
        });
    }

    private static void setNotComputerButton(Button[] skill, Button change, int left, int right, boolean turn) {

        if (accumulator(left, right, turn)) {//set button turn and position according to speed accumulator true is left turn
            setLeftButton(skill, change, left, right, turn, true);
        } else {
            skill[0].setOnAction(event -> {
                controller[1][right].attacks(0, controller[0][left], turn, true);
                Main.window.setScene(start(left, right, accumulator(left, right, turn), true));
            });
            skill[1].setOnAction(event -> {
                controller[1][right].attacks(1, controller[0][left], turn, true);
                Main.window.setScene(start(left, right, accumulator(left, right, turn), true));

            });
            skill[2].setOnAction(event -> {
                controller[1][right].attacks(2, controller[0][left], turn, true);
                Main.window.setScene(start(left, right, accumulator(left, right, turn), true));

            });
            skill[3].setOnAction(event -> {
                controller[1][right].attacks(3, controller[0][left], turn, true);
                Main.window.setScene(start(left, right, accumulator(left, right, turn), true));

            });
            change.setOnAction(event -> {

                if (right == 2)
                    Main.window.setScene(start(left, 0, accumulator(left, 0, turn), true));
                else
                    Main.window.setScene(start(left, right + 1, accumulator(left, right + 1, turn), true));
            });
        }
    }

    private static void setComputerButton(Button change, int left, int right, boolean turn) {
        change.setOnAction(event -> {
            Random r = new Random();
            if (r.nextInt(10) == 0) {
                if (right == 2)
                    Main.window.setScene(start(left, 0, accumulator(left, 0, turn), false));
                else
                    Main.window.setScene(start(left, right + 1, accumulator(left, right + 1, turn), false));
            } else
                controller[1][right].attacks(r.nextInt(4), controller[0][left], turn, false);
            Main.window.setScene(start(left, right, accumulator(left, right, turn), false));
        });

    }

    private static Node getBottomNode(int left, int right, boolean turn, boolean notComputer) {
        Button[] skill = new Button[4];
        Button change = new Button("Switch");
        for (int i = 0; i < skill.length; i++) {
            skill[i] = new Button(controller[accumulator(left, right, turn) ? 0 : 1][accumulator(left, right, turn) ? left : right].getSkillName(i));
            skill[i].setMinWidth(buttonWidth);
            skill[i].setMaxWidth(buttonWidth);
        }
        change.setMinWidth(buttonWidth);
        change.setMaxWidth(buttonWidth);
        StackPane bottom = new StackPane();
        bottom.setPadding(new Insets(10, -10, 10, -10));
        bottom.setMinWidth(fightWidth);
        bottom.setMaxWidth(fightWidth);
        VBox skillSet = new VBox(10);
        skillSet.getChildren().addAll(skill);
        skillSet.getChildren().add(change);
        bottom.getChildren().add(skillSet);
        skillSet.setAlignment(Pos.CENTER_LEFT);


        if (notComputer) {//set button turn and position according to speed accumulator, true is right turn because not left
            if (!accumulator(left, right, turn))
                skillSet.setAlignment(Pos.CENTER_RIGHT);
            setNotComputerButton(skill, change, left, right, turn);
        } else {//not left, but not notComputer so computer turn
            //todo check whose turn
            setComputerBottomNode(bottom, left, right, turn);
            if (!accumulator(left, right, turn)) {
                change.setText("Move computer");
                skillSet.getChildren().removeAll(skill);
                setComputerButton(change, left, right, turn);
            } else {
                setLeftButton(skill, change, left, right, turn, false);

            }

        }


        return bottom;
    }


    public static Scene start(int left, int right, boolean turn, boolean notComputer) {
        //setup for both modes

        if ((lifeCheck() & 0b00000001) == 0) {//check right
            return SceneHandler.endGame("one");
        }
        if ((lifeCheck() >> 4 & 0b00000001) == 0) {//check left
            if (notComputer)
                return SceneHandler.endGame("two");
            else
                return SceneHandler.endGame("Computer");
        }

        //back to both
        VBox holder = new VBox(getTopNode(left, right), getMiddleNode(), getBottomNode(left, right, turn, notComputer));
        holder.setSpacing(10);
        holder.setAlignment(Pos.CENTER);


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

        L = left;
        R = right;
        T = turn;
        M = notComputer;

        return tempScene;
    }


    private static String healthCheck(int who, int which) {
        return controller[who][which].getName() + "\nHP : " + controller[who][which].getHp() + "\nAccumulated Speed : " + controller[who][which].getAccSp();
    }

    private static int lifeCheck() {
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

        return stat;
    }

    static void reset() {
        setStr("Let the battle begin!!!\n");
//        setController(new Pokemon());
    }

    public static int getL() {
        return L;
    }

    public static int getR() {
        return R;
    }

    public static boolean getT() {
        return T;
    }

    public static boolean getM() {
        return M;
    }

    public static String getStr() {
        return str;
    }

    public static String getStrC() {
        return strC;
    }

}
