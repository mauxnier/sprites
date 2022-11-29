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
        int timeDiff = this.end - time;
        int xDist = this.getSprite().getX() - this.endX;
        int yDist = this.getSprite().getY() - this.endY;
        int xStep = xDist / timeDiff;
        int yStep = yDist / timeDiff;
        this.getSprite().setLocation(xStep, yStep);
    }
}
