package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;

public class SpriteAction implements ISpriteAction{
    public SpriteAction(){
        // TO DO
        return;
    }

    @Override
    public ISprite getSprite() {
        return null;
    }

    @Override
    public int getStartTime() {
        return 0;
    }

    @Override
    public int getEndTime() {
        return 0;
    }

    @Override
    public void doAction(int time) {

    }

    @Override
    public boolean isDone() {
        return false;
    }
}