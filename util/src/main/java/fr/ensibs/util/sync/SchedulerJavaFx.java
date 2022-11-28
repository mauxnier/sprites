package fr.ensibs.util.sync;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

import static javafx.animation.Animation.INDEFINITE;

public class SchedulerJavaFx implements IScheduler {
    @Override
    public void start(int period, Runnable task) {
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.UNKNOWN, (EventHandler<ActionEvent>) task));
    }

    @Override
    public void stop() {

    }
}
