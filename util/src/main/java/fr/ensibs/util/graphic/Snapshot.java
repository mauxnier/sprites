package fr.ensibs.util.graphic;

import java.util.*;

public class Snapshot<I extends IImage<?>> implements ISnapshot<I> {
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
}
