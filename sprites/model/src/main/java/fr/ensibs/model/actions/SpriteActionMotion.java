package fr.ensibs.model.actions;

import fr.ensibs.model.Sprite;

public class SpriteActionMotion extends SpriteAction {

    private final int end;

    public SpriteActionMotion(Sprite sprite, int start, int end) {
        super(sprite, start);
        this.end = end;
    }

    public int getEndTime(){
       return this.end;
    }

    @Override
    public void doAction() {

    }
}
