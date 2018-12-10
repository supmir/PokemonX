package tools.getres;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class GetResource {
    private Object object;

    public Image getImage(String file) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            object = new Image(classLoader.getResource("tools/getres/images/" + file + ".png").toString());

        } catch (NullPointerException e) {
            object = new Image(classLoader.getResource("tools/getres/images/Default.png").toString());

        }
        return (Image) object;
    }

    public void playAudio(String file) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Media x = new Media(Objects.requireNonNull(classLoader.getResource("tools/getres/audios/" + file + ".wav")).toString());
        object = new MediaPlayer(x);
        ((MediaPlayer) object).play();
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
