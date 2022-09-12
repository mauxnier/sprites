package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;

public interface IImageLoader {
    IImage load(InputStream in) throws IOException;
    void save(IImage img, OutputStream out) throws IOException;
}
