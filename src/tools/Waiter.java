package tools;

import javafx.concurrent.Task;
import scenes.Credits;

public class Waiter {


    public static void waiter() {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> {
            Credits.pop();

        });
        new Thread(sleeper).start();
    }
}
