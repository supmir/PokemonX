package scenes;

import framework.Pokemon;
import javafx.scene.Scene;
public class combat {

    private static Pokemon controller[][] = SceneHandler.getController();

    public static Scene combat() {
        return combatB.combatB(0, 0, true);
    }

    public static Scene combat(String x) {
        return combatP.combatP(0, 0, true);
    }


}