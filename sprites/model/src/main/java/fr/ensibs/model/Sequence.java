package fr.ensibs.model;

import java.util.List;
import java.util.Map;

import fr.ensibs.model.actions.ISpriteAction;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.Snapshot;

public class Sequence<I extends IImage> implements ISequence<I> {

    private final List<IScene<I>> scenes;
    private final List<ISpriteAction<I>> actions;
    private final I background;

    public Sequence(List<IScene<I>> scenes, List<ISpriteAction<I>> actions, I background) {
        this.scenes = scenes;
        this.actions = actions;
        this.background = background;
    }

    @Override
    public I getBackground() {
        return this.background;
    }

    @Override
    public Snapshot getCurrentSnapshot() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCurrentTime(int time) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map getImages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDuration() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List getActions() {
        return this.actions;
    }

}
