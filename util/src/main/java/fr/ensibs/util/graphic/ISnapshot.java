package fr.ensibs.util.graphic;

import java.util.List;

/**
 * A snapshot composed of different images in overlapped layers.
 *
 * @param <I> the type of images in the snapshot layers
 * @author Pascale Launay
 */
public interface ISnapshot<I extends IImage> extends List<ISnapshotLayer<I>>
{
}
