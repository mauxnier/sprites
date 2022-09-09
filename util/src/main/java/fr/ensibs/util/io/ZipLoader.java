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

    IJsonLoader jsonloader;
    ITextLoader textloader;

    public ZipLoader(IJsonLoader jsonloader, ITextLoader textloader)
    {
        this.jsonloader = jsonloader;
        this.textloader = textloader;
    }

    @Override
    public Map<String, Object> load(ZipInputStream in) throws IOException, ParseException {
        Map<String,Object> res = new HashMap<>();
        ZipInputStream zipIn = in;
        ZipEntry entry;
        String name, type;
        while ((entry = zipIn.getNextEntry()) != null) {
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
            zipIn.closeEntry(); // close the input stream
        }

        return res;
    }

    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws IOException {
    }

    private String getExtensionFromFileName(String filename)
    {
        System.out.println(filename.substring(filename.indexOf(".")+1));
        return filename.substring(filename.indexOf(".")+1);
    }

}


