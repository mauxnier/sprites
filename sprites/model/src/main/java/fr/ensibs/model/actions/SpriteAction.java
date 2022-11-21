package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;
import fr.ensibs.model.Sprite;

public abstract class SpriteAction implements ISpriteAction{
    private Sprite sprite;
    private int start;
    public SpriteAction(Sprite sprite, int start){
        this.sprite = sprite;
        this.start = start;
    }

    @Override
    public ISprite getSprite() {
        return this.sprite;
    }

    @Override
    public int getStartTime() {
        return this.start;
    }

}