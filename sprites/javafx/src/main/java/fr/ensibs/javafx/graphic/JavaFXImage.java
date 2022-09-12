package fr.ensibs.javafx.graphic;
import fr.ensibs.util.graphic.IImage;
import javafx.scene.image.Image;
public class JavaFXImage implements IImage {

    private Image img;

    JavaFXImage(Image img)
    {
        this.img = img;
    }

    public Image get_image(){
        return this.img;
    }

}
