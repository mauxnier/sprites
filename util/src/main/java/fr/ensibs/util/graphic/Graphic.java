package fr.ensibs.util.graphic;

public class Graphic<T extends IImage<?>> implements IGraphic<T> {

    public Graphic() {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void drawImage(T image) {

    }

    @Override
    public void drawSnapshot(Snapshot<T> snapshot) {

    }

    @Override
    public void clear() {

    }
}