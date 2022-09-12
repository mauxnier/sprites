package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IImageLoader {
    Image load(InputStream in) throws IOException;
    void save(Image img, OutputStream out) throws IOException;
}
