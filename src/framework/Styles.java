package framework;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import tools.StyleWriter;


public class Styles {
    private Color color = Color.valueOf("gray");
    private BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
    private double radii = 0;
    private double borderWidths = 5;
    private Border border;

    public Styles() {
        this.border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));
    }

    public Styles(Color color, BorderStrokeStyle borderStrokeStyle, double radii, double borderWidths) {
        this.color = color;
        this.borderStrokeStyle = borderStrokeStyle;
        this.radii = radii;
        this.borderWidths = borderWidths;
        this.border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));
    }

    public void writeStyles() {
        StyleWriter.writeStyles(color.toString(), borderStrokeStyle.toString(), radii, borderWidths);
    }

    public Color getColor() {
        return color;
    }

    public BorderStrokeStyle getBorderStrokeStyle() {
        return borderStrokeStyle;
    }

    public double getRadii() {
        return radii;
    }

    public double getBorderWidths() {
        return borderWidths;
    }

    public Border getBorder() {
        return border;
    }


    public void setColor(Color color) {
        this.color = color;
        updateBorder();
    }

    public void setBorderStrokeStyle(BorderStrokeStyle borderStrokeStyle) {
        this.borderStrokeStyle = borderStrokeStyle;
        updateBorder();
    }

    public void setRadii(double radii) {
        this.radii = radii;
        updateBorder();

    }

    public void setBorderWidths(double borderWidths) {
        this.borderWidths = borderWidths;
        updateBorder();

    }


    public void setDefault() {

        Color color = Color.valueOf("gray");
        BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
        double radii = 0;
        double borderWidths = 5;

        border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));
    }

    private void updateBorder() {
        border = new Border(new BorderStroke(color, borderStrokeStyle, new CornerRadii(radii), new BorderWidths(borderWidths)));
    }

}
