package fr.ensibs.util.graphic;

import java.util.List;

/**
 * A snapshot composed of different images in overlapped layers.
 *
 * @param <I> the type of images in the snapshot layers
 * @author Pascale Launay
 */
public interface ISnapshot<I extends IImage>
{
    @SuppressWarnings("unchecked")
    boolean add(Object o);

    @SuppressWarnings("unchecked")
    Object set(int i, Object o);

    void add(int i, Object o);

    @Override
    public boolean equals(Object o);

}
