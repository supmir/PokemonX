package framework;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Styles {
    private static Color color = Color.valueOf("gray");
    private static BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
    private static double radii = 0;
    private static double borderWidths = 5;
    private static Border border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));

    public static Color getColor() {
        return color;
    }

    public static BorderStrokeStyle getBorderStrokeStyle() {
        return borderStrokeStyle;
    }

    public static double getRadii() {
        return radii;
    }

    public static double getBorderWidths() {
        return borderWidths;
    }

    public static Border getBorder() {
        return border;
    }


    public static void setColor(Color color) {
        Styles.color = color;
        updateBorder();
    }

    public static void setBorderStrokeStyle(BorderStrokeStyle borderStrokeStyle) {
        Styles.borderStrokeStyle = borderStrokeStyle;
        updateBorder();
    }

    public static void setRadii(double radii) {
        Styles.radii = radii;
        updateBorder();

    }

    public static void setBorderWidths(double borderWidths) {
        Styles.borderWidths = borderWidths;
        updateBorder();

    }


    public static void setDefault() {

        Color color = Color.valueOf("gray");
        BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
        double radii = 0;
        double borderWidths = 5;

        border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));

    }

    private static void updateBorder() {
        border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));
    }

}
