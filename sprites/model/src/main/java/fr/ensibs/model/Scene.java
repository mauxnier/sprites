package fr.ensibs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.graphic.SnapshotLayer;

public class Scene<I extends IImage> extends ArrayList<ISprite<I>> implements IScene {

    private IImage background;

    public Scene(IImage background) {
        this.background = background;
    }

    @Override
    public Snapshot<I> getCurrentSnapshot() {
        Snapshot<I> snapshot = new Snapshot<>();
        for (ISprite sprite : this) {
            if (sprite.isVisible()) {
                snapshot.add(new SnapshotLayer<I>(sprite.getX(), sprite.getY(), (I) sprite.getCurrentImage()));
            }
        }

        return snapshot;
    }

    @Override
    public void setCurrentTime(int time) {
        for (ISprite sprite : this) {
            sprite.setCurrentTime(time);
        }
    }

    @Override
    public Map<String, I> getImages() {
        Map<String, I> images = new HashMap<>();

        for (ISprite<I> sprite : this) {
            images.put(sprite.getName(), sprite.getCurrentImage());
        }

        return images;
    }

    @Override
    public IImage getBackground() {
        return this.background;
    }

}
