package imagegetter;

import javafx.scene.image.Image;

public class ImgGet {


    public Image getBackground(String name) {
        return new Image(getClass().getClassLoader().getResource("/imagegetter/" + name + ".png").toString());
    }


//            return new Image("/imagegetter/Background.png");




}
