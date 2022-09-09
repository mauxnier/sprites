package fr.ensibs.util.io;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

/**
 * Interface used to load/save JSON objects from/to input streams.
 *
 * @author Pascale Launay
 */
public interface IJsonLoader
{
    /**
     * Read an object from an input stream.
     *
     * @param in input stream
     * @return the instance read from the input stream
     * @throws IOException    if an error occurs while reading from the input stream
     * @throws ParseException if an error occurs while making the object
     * @pre {@code in != null}
     * @post {@code result != null}
     */
    JSONObject load(InputStream in) throws IOException, ParseException;

    /**
     * Save a JSON object to an output stream
     *
     * @param obj the instance to be written to the output stream
     * @param out the output stream
     * @throws IOException if an error occurs while writing to the output stream
     * @pre {@code obj != null}
     * @pre {@code out != null}
     */
    void save(JSONObject obj, OutputStream out) throws IOException;
}
