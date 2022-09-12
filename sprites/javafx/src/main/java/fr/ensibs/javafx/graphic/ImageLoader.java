package fr.ensibs.javafx.graphic;

import fr.ensibs.util.io.IImageLoader;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageLoader implements IImageLoader {
    @Override
    public Image load(InputStream in) throws IOException {
        //todo
        return ImageIO.read(in);
    }

    @Override
    public void save(Image img, OutputStream out) throws IOException {
        //todo
    }
}