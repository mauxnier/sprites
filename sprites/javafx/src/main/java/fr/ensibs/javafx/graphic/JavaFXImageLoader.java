package fr.ensibs.javafx.graphic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.ILoader;
import javafx.scene.image.Image;

public class JavaFXImageLoader implements ILoader<JavaFXImage> {

    @Override
    public JavaFXImage load(InputStream in) {
        Image img = new Image(in);
        return new JavaFXImage(img);
    }

    @Override
    public void save(JavaFXImage img, OutputStream out) throws IOException {
        Image image = img.getImage();
        out.write(image.getUrl().getBytes()); //TODO je pense que c'est image.getUrl() qu'on veut save mais pas sûr sûr
    }
}
