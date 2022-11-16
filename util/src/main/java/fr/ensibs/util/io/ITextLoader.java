package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface used to load/save text from/to input streams.
 *
 * @author Pascale Launay
 */
public interface ITextLoader extends ILoader<String>
{
    /**
     * Read a text from an input stream.
     *
     * @param in input stream
     * @return the text read from the input stream
     * @throws IOException    if an error occurs while reading from the input stream
     * @pre {@code in != null}
     * @post {@code result != null}
     */
    String load(InputStream in) throws IOException;

    /**
     * Save a text to an output stream
     *
     * @param text the text to be written to the output stream
     * @param out the output stream
     * @throws IOException if an error occurs while writing to the output stream
     * @pre {@code text != null}
     * @pre {@code out != null}
     */
    void save(String text, OutputStream out) throws IOException;
}