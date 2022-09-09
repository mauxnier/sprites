package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipLoader implements IZipLoader {

    JsonLoader jsonloader;
    TextLoader textloader;

    public ZipLoader(JsonLoader jsonloader, TextLoader textloader)
    {
        this.jsonloader = jsonloader;
        this.textloader = textloader;
    }

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
     */
    @Override
    public Map<String, Object> load(ZipInputStream in) throws IOException, ParseException {
        ZipInputStream zipIn = new ZipInputStream(in);
        ZipEntry entry;
        while ((entry = zipIn.getNextEntry()) != null) {
            System.out.println(entry.getName());
            readContents(zipIn);
            zipIn.closeEntry();
        }
        return null;
    }

    /**
     * Save a list of JSON objects and texts to a ZIP output stream. Each given resource
     * is written to the ZIP output stream with its key as entry name and its value is written
     * using the appropriate loader ({@link IJsonLoader} or {@link ITextLoader}) given the
     * type of the resource
     *
     * @param resources the resources to be written to the output stream
     * @param out the output stream
     * @throws IOException if an error occurs while writing to the output stream
     */
    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws IOException {
        for (Map.Entry<String, Object> entry : resources.entrySet()) {
            
        }
    }

    private void readContents(InputStream contentsIn) throws IOException {
        byte contents[] = new byte[4096];
        int direct;
        while ((direct = contentsIn.read(contents, 0, contents.length)) >= 0) {
            System.out.println("Read " + direct + "bytes content.");
        }
    }

}


