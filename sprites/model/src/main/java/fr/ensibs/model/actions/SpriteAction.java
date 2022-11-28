package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;
import fr.ensibs.model.Sprite;
import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

public abstract class SpriteAction<T extends IImage<Image>> implements ISpriteAction<T> {
    private final Sprite<T> sprite;
    private final int start;

    public SpriteAction(Sprite<T> sprite, int start) {
        this.sprite = sprite;
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