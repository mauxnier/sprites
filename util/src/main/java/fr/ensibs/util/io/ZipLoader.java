package fr.ensibs.util.io;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
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

    @Override
    public Map<String, Object> load(ZipInputStream in) throws IOException, ParseException {
        Map<String,Object> res = new HashMap<>();
        ZipInputStream zipIn = new ZipInputStream(in);
        ZipEntry entry;
        String name, type;
        while ((entry = zipIn.getNextEntry()) != null) {
            name = entry.getName();
            // Check what is the file type
            type = getExtensionFromFileName(name);
            if (type.equals("json"))
            { // call to Json Loader
                JSONObject jsonObj = jsonloader.load(zipIn);
                res.put(name,jsonObj);
            }else if (type.equals("txt"))
            { // call to Text Loader
                String text = textloader.load(zipIn);
                res.put(name,text);
            }else{ // in case we can't recognize the format used
                throw new IOException("ZipLoaderException : unrecognized format");
            }
            zipIn.closeEntry(); // close the input stream
        }
        return res;
    }

    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws IOException {
    }

    private String getExtensionFromFileName(String filename)
    {
        return filename.substring(filename.indexOf(".")+1);
    }

}


