package fr.ensibs.javafx.graphic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;

public class JavaFXImageLoader implements IImageLoader {

    @Override
    public IImage load(InputStream in) {
        Image img = new Image(in);
        return new JavaFXImage(img);
    }

    @Override
    public void save(IImage img, OutputStream out) {
        // Image i = img.getImage();
    }
}
