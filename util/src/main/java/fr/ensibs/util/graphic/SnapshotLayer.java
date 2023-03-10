package fr.ensibs.util.graphic;

public class SnapshotLayer<T extends IImage> implements ISnapshotLayer<T> {

    private int x, y;

    private final T img;

    public SnapshotLayer(int x, int y, T img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    @Override
    public T getImage() {
        return this.img;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public double getWidth() {
        return img.getWidth();
    }

    @Override
    public double getHeight() {
        return img.getHeight();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        SnapshotLayer<T> obj = (SnapshotLayer<T>) o;
        return this.x == obj.x && this.y == obj.y;
    }
}
