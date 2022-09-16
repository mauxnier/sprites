package fr.ensibs.javafx.graphic;

import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.ILoader;
import javafx.scene.image.Image;

public class JavaFXImageLoader implements ILoader<IImage> {

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
