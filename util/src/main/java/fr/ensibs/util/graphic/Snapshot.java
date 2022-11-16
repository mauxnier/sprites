package fr.ensibs.util.graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.*;

public class Snapshot<I extends IImage> implements ISnapshot<I> {
    private final List<ISnapshotLayer<I>> snapshotList;

    public Snapshot() {
        this.snapshotList = new ArrayList<>();
    }

    public List<ISnapshotLayer<I>> getList() {
        return (this.snapshotList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(Object o) {
        return (this.snapshotList.add((SnapshotLayer<I>) o));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(int i, Object o) {
        this.snapshotList.add((SnapshotLayer<I>) o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object set(int i, Object o) {
        return (this.snapshotList.set(i, (SnapshotLayer<I>) o));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        return snapshotList.equals(((Snapshot<I>) obj).getList());
    }

    public void draw(Canvas imageCanvas) {
        for (ISnapshotLayer<I> layer : this.snapshotList) {
            I javaFXImage = layer.getImage();
            imageCanvas.getGraphicsContext2D().drawImage((Image) javaFXImage.getImage(), 0, 0, 350, 350);
        }
    }
}
