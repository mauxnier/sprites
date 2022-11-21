package fr.ensibs.util.io;

import fr.ensibs.util.graphic.IImage;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipLoader<T extends IImage<?>> implements IZipLoader {

    private final IJsonLoader jsonLoader;
    private final ITextLoader textLoader;
    private final IImageLoader<T> imageLoader;

    public ZipLoader(IJsonLoader jsonLoader, ITextLoader textLoader)
    {
        this.jsonLoader = jsonLoader;
        this.textLoader = textLoader;
        this.imageLoader = null;
    }

    public ZipLoader(IJsonLoader jsonLoader, ITextLoader textLoader, IImageLoader<T> imageLoader)
    {
        this.jsonLoader = jsonLoader;
        this.textLoader = textLoader;
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
        Map<String, Object> res = new HashMap<>();
        ZipEntry entry;
        String name, type;
        while ((entry = in.getNextEntry()) != null) {
            name = entry.getName();
            type = getExtensionFromFileName(name);

            switch (type) {
                case "json":
                    JSONObject jsonObj = jsonLoader.load(in);
                    res.put(name, jsonObj);
                    break;
                case "txt":
                    String text = textLoader.load(in);
                    res.put(name, text);
                    break;
                case "jpg":
                case "jpeg":
                case "png":
                    assert imageLoader != null;
                    T img = imageLoader.load(in);
                    System.out.println(img);
                    res.put(name, img);
                    break;
                default:
                    throw new IOException("ZipLoaderException: unrecognized format " + type);
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
     * @throws IOException if an error occurs while writing to the output stream
     */
    @SuppressWarnings("unchecked")
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
                    jsonLoader.save((JSONObject) entryValue, out);
                    break;
                case "txt":
                    textLoader.save((String) entryValue, out);
                    break;
                case "jpg":
                case "jpeg":
                case "png":
                    assert imageLoader != null;
                    imageLoader.save((T) entryValue, out);
                    break;
                default:
                    throw new IOException("ZipLoaderException: file type unknown " + type);
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
        return filename.substring(filename.indexOf(".")+1);
    }
}


