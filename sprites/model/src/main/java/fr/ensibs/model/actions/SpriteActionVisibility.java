package fr.ensibs.model.actions;

import fr.ensibs.model.Sprite;

public class SpriteActionVisibility extends SpriteAction {

    private final boolean visible;

    public SpriteActionVisibility(Sprite sprite, int start, boolean visible) {
        super(sprite, start);
        this.visible = visible;
    }

    @Override
    public void doAction() {
        this.getSprite().setVisible(visible);
    }
}
