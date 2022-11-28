package fr.ensibs.model.actions;

import fr.ensibs.model.ISprite;
import fr.ensibs.util.graphic.IImage;

/**
 * An action related to a sprite in a sequence
 *
 * @param <I> the type of images that compose the sprite related to this action
 * @inv {@code getSprite() != null}
 * @inv {@code getStartTime() >= 0}
 * @inv {@code getEndTime() >= getStartTime()}
 */
public interface ISpriteAction<I extends IImage> {
    /**
     * Give the sprite this action is related to
     *
     * @return the sprite of this action
     */
    ISprite<I> getSprite();

    /**
     * Give the time when this action starts in the sequence
     *
     * @return the action start time
     */
    int getStartTime();

    /**
     * Give the time when this action ends in the sequence
     *
     * @return the action end time
     */

    /**
     * Execute the current action for the given time
     *
     * @param time the time when the action has to be done
     */
    void doAction(int time);

}
