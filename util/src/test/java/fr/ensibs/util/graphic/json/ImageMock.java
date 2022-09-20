package fr.ensibs.util.graphic.json;

import fr.ensibs.util.graphic.IImage;

/**
 * A class that implements the {@link IImage} interface for testing purposes
 *
 * @author Pascale Launay
 */
public class ImageMock implements IImage
{
    /**
     * The image name
     */
    private String name;

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
    public int getWidth()
    {
        return 100;
    }

    @Override
    public int getHeight()
    {
        return 100;
    }
}

