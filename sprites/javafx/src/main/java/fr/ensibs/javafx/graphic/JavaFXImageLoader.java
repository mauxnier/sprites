package fr.ensibs.javafx.graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.io.IImageLoader;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

public class JavaFXImageLoader implements IImageLoader<JavaFXImage> {

    @Override
    public JavaFXImage load(InputStream in) {
        Image img = new Image(in);
        return new JavaFXImage(img, img.getUrl());
    }

    @Override
    public void save(JavaFXImage img, OutputStream out) throws IOException {
        Image image = img.getImage();
        BufferedImage fromFXImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(fromFXImage, "jpg", out); 
    }
}
