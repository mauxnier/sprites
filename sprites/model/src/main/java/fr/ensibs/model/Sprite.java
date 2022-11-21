package fr.ensibs.model;

import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Sprite<I extends IImage<Image>> extends ArrayList<I> implements ISprite<I>{

    private final String name;
    private int x,y;
    private final int duration;
    private int time;
    private boolean visible;

    public Sprite(String name, int x, int y, int duration, int time, boolean visible)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.time = time;
        this.visible = visible;
    }

    @Override
    public I getCurrentImage() {
        return this.get(this.time);
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    /**
     * Donne le temps d'affichage par image.
     * @return duration by frame
     */
    public int getDurationByFrame() {
        return (this.getDuration() / this.size());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * Retourne le temps actuel de l'image.
     * @return time
     */
    public int getCurrentTime() {
        return this.time;
    }

    @Override
    public void setCurrentTime(int time) {
        if (time >= this.size()) {
            time = 0; // repart avec l'image de base
        }
        this.time = time;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
