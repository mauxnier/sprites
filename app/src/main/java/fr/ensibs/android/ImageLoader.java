package fr.ensibs.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IImageLoader;

public class ImageLoader implements IImageLoader {

    @Override
    public IImage load(InputStream in) throws IOException {
        return null;
    }

    @Override
    public void save(Object obj, OutputStream out) throws Exception {

    }

    @Override
    public void save(IImage image, OutputStream out) throws IOException {

    }
}
