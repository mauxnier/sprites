package fr.ensibs.util.graphic;

public class SnapshotLayer<I extends IImage> implements ISnapshotLayer {

    private int x,y;

    private IImage img;

    public SnapshotLayer(int x, int y, IImage img)
    {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    @Override
    public IImage getImage() {
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
    public int getWidth() {
        return img.getWidth();
    }

    @Override
    public int getHeight() {
        return img.getHeight();
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean equals(SnapshotLayer o)
    {
        return this.x == o.getX() && this.y == o.getY() && this.img == o.getImage();
    }

}
