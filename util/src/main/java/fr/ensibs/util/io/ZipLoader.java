package fr.ensibs.util.io;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipLoader implements IZipLoader {
    /**
     * Read a list of JSON objects and texts from a ZIP input stream. Each resource is
     * give as a pair (key, value) where the key is the name of the entry in the zip
     * input and the value its content loaded using the appropriate loader ({@link IJsonLoader}
     * or {@link ITextLoader}) given the extension of the entry name
     *
     * @param in input stream
     * @return the resources read from the input stream
     * @throws IOException    if an error occurs while reading from the input stream
     * @throws ParseException if an error occurs while making the JSON objects
     * @pre {@code in != null}
     * @post {@code result != null}
     */
    @Override
    public Map<String, Object> load(ZipInputStream in) throws IOException, ParseException {
        return null;
    }

    /**
     * Save a list of JSON objects and texts to a ZIP output stream. Each given resource
     * is written to the ZIP output stream with its key as entry name and its value is written
     * using the appropriate loader ({@link IJsonLoader} or {@link ITextLoader}) given the
     * type of the resource
     *
     * @param resources the resources to be written to the output stream
     * @param out       the output stream
     * @throws IOException if an error occurs while writing to the output stream
     * @pre {@code obj != null}
     * @pre {@code out != null}
     */
    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws IOException {

    }
}
