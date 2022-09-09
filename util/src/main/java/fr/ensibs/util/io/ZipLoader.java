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

    @Override
    public void save(Map<String, Object> resources, ZipOutputStream out) throws IOException {
    }

    private void readContents(InputStream contentsIn) throws IOException {
        byte contents[] = new byte[4096];
        int direct;
        while ((direct = contentsIn.read(contents, 0, contents.length)) >= 0) {
            System.out.println("Read " + direct + "bytes content.");
        }
    }

}


