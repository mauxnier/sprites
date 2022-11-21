package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;
import fr.ensibs.util.graphic.IImage;

/*
Implementation of the interface ISpriteAction
 */
public class SpriteAction<T extends IImage<?>> implements ISpriteAction<T> {
    public SpriteAction() {
        System.out.println("To do");
    }

    @Override
    public ISprite<T> getSprite() {
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