package fr.ensibs.model.actions;

import fr.ensibs.util.graphic.IImage;

public class SpriteActionMotion<T extends IImage<?>> extends SpriteAction<T> {

    private final int end;
    private final int endX;
    private final int endY;

    public SpriteActionMotion(int start, int end, int endX, int endY) {
        super(start);
        this.end = end;
        this.endX = endX;
        this.endY = endY;
    }

    public int getEndTime() {
        return this.end;
    }

    public int getEndX() {
        return this.endX;
    }

    public int getEndY() {
        return this.endY;
    }

    @Override
    public void doAction(int time) {
        if (time > end) {
            return;
        }
        int time_diff = this.end - time;
        int x_dist = this.getSprite().getX() - this.end_X;
        int y_dist = this.getSprite().getY() - this.end_Y;
        int x_step = x_dist / time_diff;
        int y_step = y_dist / time_diff;
        this.getSprite().setLocation(x_step, y_step);
    }
}
