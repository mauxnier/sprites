package fr.ensibs.javafx.graphic;

import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

public class JavaFXImage implements IImage {

    private Image img;

    JavaFXImage(Image img)
    {
        this.img = img;
    }

    public Image getImage(){
        return this.img;
    }

    /**
     * Give the name of the image.
     *
     * @return the name of the image
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Set the name of the image.
     *
     * @param name the new name of the image
     */
    @Override
    public void setName(String name) {

    }

    /**
     * Give the width of the image in pixels.
     *
     * @return the width of the image
     */
    @Override
    public int getWidth() {
        return 0;
    }

    /**
     * Give the height of the image in pixels.
     *
     * @return the height of the image
     */
    @Override
    public int getHeight() {
        return 0;
    }
}
