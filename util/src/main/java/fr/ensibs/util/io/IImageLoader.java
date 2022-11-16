package fr.ensibs.util.io;

import fr.ensibs.util.graphic.IImage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface used to load/save image from/to input streams.
 */
public interface IImageLoader<T extends IImage> extends ILoader<T>
{
    /**
     * Read an image from an input stream.
     *
     * @param in input stream
     * @return the image read from the input stream
     * @throws IOException    if an error occurs while reading from the input stream
     * @pre {@code in != null}
     * @post {@code result != null}
     */
    T load(InputStream in) throws IOException;

    /**
     * Save an image to an output stream
     *
     * @param image the image to be written to the output stream
     * @param out the output stream
     * @throws IOException if an error occurs while writing to the output stream
     * @pre {@code image != null}
     * @pre {@code out != null}
     */
    void save(T image, OutputStream out) throws IOException;
}