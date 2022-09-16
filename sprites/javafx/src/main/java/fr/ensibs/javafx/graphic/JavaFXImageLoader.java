package fr.ensibs.javafx.graphic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.Loader;
import javafx.scene.image.Image;

public class JavaFXImageLoader implements Loader<IImage> {

    @Override
    public IImage load(InputStream in) throws IOException {
        Image img = new Image(in);
        JavaFXImage res = new JavaFXImage(img);
        return res;
    }

    @Override
    public void save(IImage img, OutputStream out) throws IOException {
        Image i = img.getImage();

    }
    
}
