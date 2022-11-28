package fr.ensibs.util.graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

/**
 * Classe Graphic pour le système JavaFx.
 * @param <T> JavaFxImage
 */
public class Graphic<T extends IImage<Image>> implements IGraphic<T> {
    Canvas imageCanvas;

    public Graphic(Canvas imageCanvas) {
        this.imageCanvas = imageCanvas;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void clear() {
        imageCanvas.getGraphicsContext2D().clearRect(0, 0, imageCanvas.getWidth(), imageCanvas.getHeight());
    }

    @Override
    public void drawImage(T image) {
        this.imageCanvas.getGraphicsContext2D().drawImage(image.getImage(), 0, 0, 350, 350);
    }

    @Override
    public void drawSnapshot(Snapshot<T> snapshot) {
        double scale = 0.5;

        for (ISnapshotLayer<T> layer : snapshot.getList()) {

            T image = layer.getImage();
            imageCanvas.getGraphicsContext2D().drawImage(image.getImage(), layer.getX() * scale,
                    layer.getY() * scale,
                    (int) layer.getWidth() * scale, (int) layer.getHeight() * scale);
        }
    }
}