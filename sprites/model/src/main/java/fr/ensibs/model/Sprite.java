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
        int step = this.duration / this.size();
        int n_sprite = this.time / step;
        return this.get(n_sprite % this.size());
    }

    @Override
    public int getDuration() {
        return this.duration;
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

    @Override
    public void setCurrentTime(int time) {
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
