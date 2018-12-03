package scenes;

import javafx.scene.Scene;
public class combat {

    public static Scene combat() {
        return combatB.start(0, 0, true);
    }

    public static Scene combat(String x) {
        return combatP.start(0, 0, combatP.accumulator(0, 0, false));
    }
}