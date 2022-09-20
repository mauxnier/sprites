package fr.ensibs.sprites;

import fr.ensibs.util.graphic.IImage;

import java.util.List;

/**
 * A movie composed of sequences.
 *
 * @param <I> the type of images that compose the movie
 * @author Pascale Launay
 * @inv {@code getDuration() >= 0}
 */
public interface IMovie<I extends IImage> extends List<ISequence<I>>, IPlayable<I>
{
    /**
     * Give the movie total duration (in ms). The movie duration is the
     * sum of its sequences durations
     *
     * @return the movie duration
     */
    int getDuration();
}
