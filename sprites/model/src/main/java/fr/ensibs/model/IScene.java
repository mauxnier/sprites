package fr.ensibs.model;

import java.util.List;

import fr.ensibs.util.graphic.IImage;

/**
 * A scene having a background image and composed of sprites. The size of the
 * scene is the same as the size of its background
 *
 * @param <I> the type of images that compose the scene
 * @author Pascale Launay
 * @inv {@code getBackground() != null}
 */
public interface IScene<I extends IImage<?>> extends List<Sprite<I>>, IPlayable<I> {

    /**
     * Give the background of the scene.
     *
     * @return the background image
     */
    I getBackground();
}
