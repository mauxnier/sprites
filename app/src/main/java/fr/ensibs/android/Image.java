package fr.ensibs.android;
import android.graphics.Bitmap;

import fr.ensibs.util.graphic.IImage;

public class Image implements IImage<Bitmap> {
    private Bitmap img;
    private String name;

    Image(Bitmap img, String name) {
        this.img = img;
        this.name = name;
    }

    public Bitmap getImage(){
        return this.img;
    }

    public void setImage(Bitmap image) {
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
