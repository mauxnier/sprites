package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;
import fr.ensibs.model.Sprite;
import fr.ensibs.util.graphic.IImage;

public abstract class SpriteAction<T extends IImage> implements ISpriteAction<T> {
    private Sprite<T> sprite;
    private final int start;

    public SpriteAction(int start) {
        this.start = start;
    }

    @Override
    public ISprite<T> getSprite() {
        return this.sprite;
    }

    @Override
    public int getStartTime() {
        return this.start;
    }

}