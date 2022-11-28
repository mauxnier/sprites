package fr.ensibs.model.actions;

import fr.ensibs.util.graphic.IImage;

public class SpriteActionVisibility<T extends IImage> extends SpriteAction<T> {

    private final boolean visible;

    public SpriteActionVisibility(int start, boolean visible) {
        super(start);
        this.visible = visible;
    }

    @Override
    public void doAction(int time) {
        if (time == this.getStartTime()) {
            this.getSprite().setVisible(visible);
        }
    }

    public boolean isVisible() {
        return visible;
    }
}
