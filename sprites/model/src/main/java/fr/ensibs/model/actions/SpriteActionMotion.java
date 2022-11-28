package fr.ensibs.model.actions;

import fr.ensibs.model.Sprite;

public class SpriteActionMotion extends SpriteAction {

    private final int end;
    private final int end_Y;
    private final int end_X;

    public SpriteActionMotion(Sprite sprite, int start, int end, int end_X, int end_Y) {
        super(sprite, start);
        this.end = end;
        this.end_Y = end_Y;
        this.end_X = end_X;
    }

    public int getEndTime(){
       return this.end;
    }

    @Override
    public void doAction(int time) {
        if (time > end) {return;}
        int time_diff = this.end - time;
        int x_dist = this.getSprite().getX() - this.end_X;
        int y_dist = this.getSprite().getY() - this.end_Y;
        int x_step = x_dist / time_diff;
        int y_step = y_dist / time_diff;
        this.getSprite().setLocation(x_step, y_step);
    }
}
