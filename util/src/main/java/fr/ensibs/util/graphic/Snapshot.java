package fr.ensibs.util.graphic;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Snapshot<I extends IImage> implements ISnapshot {

    private List<SnapshotLayer> snapshotList;

    public List<SnapshotLayer> getList() {
        return (this.snapshotList);
    }

    @Override
    public int size() {
        return (this.snapshotList.size());
    }

    @Override
    public boolean isEmpty() {
        return (this.snapshotList.isEmpty());
    }

    @Override
    public boolean contains(Object o) {
        return (this.snapshotList.contains(o));
    }

    @Override
    public Iterator<SnapshotLayer> iterator() {
        return (this.snapshotList.iterator());
    }

    @Override
    public Object[] toArray() {
        return (this.snapshotList.toArray());
    }

    @Override
    public boolean add(Object o) {
        return (this.snapshotList.add((SnapshotLayer) o));
    }

    @Override
    public boolean remove(Object o) {
        return (this.snapshotList.remove(o));
    }

    @Override
    public boolean addAll(Collection collection) {
        return (this.snapshotList.addAll(collection));
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return (this.snapshotList.addAll(collection));
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int i) {
        return (this.snapshotList.get(i));
    }

    @Override
    public Object set(int i, Object o) {
        return (this.snapshotList.set(i, (SnapshotLayer) o));
    }

    @Override
    public void add(int i, Object o) {

    }

    @Override
    public Object remove(int i) {
        return (this.snapshotList.remove(i));
    }

    @Override
    public int indexOf(Object o) {
        return (this.snapshotList.indexOf(o));
    }

    @Override
    public int lastIndexOf(Object o) {
        return (this.snapshotList.lastIndexOf(o));
    }

    @Override
    public ListIterator<SnapshotLayer> listIterator() {
        return this.snapshotList.listIterator();
    }

    @Override
    public ListIterator<SnapshotLayer> listIterator(int i) {
        return this.snapshotList.listIterator(i);
    }

    @Override
    public List<SnapshotLayer> subList(int i, int i1) {
        return this.snapshotList.subList(i, i1);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.snapshotList.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.snapshotList.removeAll(collection);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.snapshotList.containsAll(collection);
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return this.snapshotList.toArray(objects);
    }

    public boolean equals(Snapshot obj) {
        return snapshotList.equals(obj.getList());
    }
}
