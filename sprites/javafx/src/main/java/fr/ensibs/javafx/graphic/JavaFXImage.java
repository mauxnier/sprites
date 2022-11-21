package fr.ensibs.javafx.graphic;

import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

public class JavaFXImage implements IImage<Image> {

    private Image img;
    private String name;

    JavaFXImage(Image img, String name) {
        this.img = img;
        this.name = name;
    }

    @Override
    public Image getImage() {
        return this.img;
    }

    @Override
    public void setImage(Image image) {
        this.img = image;
    }

    /**
     * Give the name of the image.
     *
     * @return the name of the image
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the image.
     *
     * @param name the new name of the image
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Give the width of the image in pixels.
     *
     * @return the width of the image
     */
    public double getWidth() {
        return this.img.getWidth();
    }

    /**
     * Give the height of the image in pixels.
     *
     * @return the height of the image
     */
    public double getHeight() {
        return this.img.getHeight();
    }
}
