package tools.AudioPlayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {


    public Audio(String file) {
        System.out.println(1);
        System.out.println(this.getClass().getResource(file + ".wav").toString());
        System.out.println(2);

        System.out.println(this.getClass().getResource(file + ".wav"));
        Media x = new Media(this.getClass().getResource(file + ".wav").toString());


        MediaPlayer player = new MediaPlayer(x);

        player.play();

//        AudioClip cymbal = new AudioClip(this.getClass().getResource(file + ".wav").toString());
//        cymbal.setCycleCount(10);
//        cymbal.play();
    }


}


