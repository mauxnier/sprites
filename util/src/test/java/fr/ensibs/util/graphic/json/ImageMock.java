package fr.ensibs.util.graphic.json;

import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

/**
 * A class that implements the {@link IImage} interface for testing purposes
 *
 * @author Pascale Launay
 */
public class ImageMock implements IImage<Image>
{
    /**
     * The image name
     */
    private String name;

    private Image img;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public double getWidth()
    {
        return 100;
    }

    @Override
    public double getHeight()
    {
        return 100;
    }

    @Override
    public Image getImage() {
        return this.img;
    }

    @Override
    public void setImage(Image image) {
        this.img = image;
    }
}

