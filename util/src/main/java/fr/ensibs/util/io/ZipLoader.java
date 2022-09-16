package fr.ensibs.util.io;

import fr.ensibs.util.graphic.IImage;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipLoader implements IZipLoader {

    private Loader<JSONObject> jsonloader;
    private Loader<String> textloader;
    private Loader<Image> imageLoader;

    public ZipLoader(Loader<JSONObject> jsonloader, Loader<String> textloader)
    {
        this.jsonloader = jsonloader;
        this.textloader = textloader;
    }

    public ZipLoader(Loader<JSONObject> jsonloader, Loader<String> textloader, Loader<Image> imageLoader)
    {
        this.jsonloader = jsonloader;
        this.textloader = textloader;
        this.imageLoader = imageLoader;
    }

    /**
     * Read a list of JSON objects and texts from a ZIP input stream. Each resource is
     * give as a pair (key, value) where the key is the name of the entry in the zip
     * input and the value its content loaded using the appropriate loader ({@link }
     * or {@link }) given the extension of the entry name
     *
     * @param in input stream
     * @return the resources read from the input stream
     */
    @Override
    public Map<String, Object> load(ZipInputStream in) throws Exception {
        Map<String,Object> res = new HashMap<>();
        ZipEntry entry;
        String name, type;
        while ((entry = in.getNextEntry()) != null) {
            name = entry.getName();
            // Check what is the file type
            System.out.println("Call to getExtensionFileName");
            type = getExtensionFromFileName(name);
            if (type.equals("json"))
            { // call to Json Loader
                JSONObject jsonObj = jsonloader.load(in);
                res.put(name,jsonObj);
            }else if (type.equals("txt"))
            { // call to Text Loader
                String text = textloader.load(in);
                res.put(name,text);
            }else{ // in case we can't recognize the format used
                throw new IOException("ZipLoaderException : unrecognized format");
            }
            in.closeEntry(); // close the input stream
        }

        return res;
    }

    /**
     * Save a list of JSON objects and texts to a ZIP output stream. Each given resource
     * is written to the ZIP output stream with its key as entry name and its value is written
     * using the appropriate loader ({@link } or {@link }) given the
     * type of the resource
     *
     * @param resources the resources to be written to the output stream
     * @param out the output stream
     * @return 
     * @throws IOException if an error occurs while writing to the output stream
     */
    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws Exception {
        for (Map.Entry<String, Object> entry : resources.entrySet()) {
            String entryName = entry.getKey();
            Object entryValue = entry.getValue();

            System.out.println(entryName);
            System.out.println(entryValue);

            String type = getExtensionFromFileName(entryName);
            out.putNextEntry(new ZipEntry(entryName));

            switch (type) {
                case "json":
                    jsonloader.save((JSONObject) entryValue, out);
                    break;
                case "txt":
                    textloader.save((String) entryValue, out);
                    break;
                case "jpg":
                case "jpeg":
                case "png":
                    imageLoader.save((Image) entryValue, out);
                    break;
                default:
                    throw new IOException("Error: file type unknown");
            }

            out.closeEntry();
        }
    }

    /**
     * Return the extension of a filename.
     * @param filename the name of file
     * @return the extension
     */
    private String getExtensionFromFileName(String filename) {
        System.out.println(filename.substring(filename.indexOf(".")+1));
        return filename.substring(filename.indexOf(".")+1);
    }
}


