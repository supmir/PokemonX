package tools.getres;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class getRes {
    private Object object;

    public Image getImage(String file) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        object = new Image(Objects.requireNonNull(classLoader.getResource("tools/getres/images/" + file + ".png")).toString());
        return (Image) object;
    }

    public getRes playAudio(String file) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Media x = new Media(Objects.requireNonNull(classLoader.getResource("tools/getres/audios/" + file + ".wav")).toString());
        object = new MediaPlayer(x);
        ((MediaPlayer) object).play();
        return null;
    }


    public void pauseAudio() {
        ((MediaPlayer) object).pause();
    }

    public void continueAudio() {
        ((MediaPlayer) object).play();
    }

    public void stopAudio() {
        ((MediaPlayer) object).stop();
    }

}
