package fr.ensibs.model;

import fr.ensibs.javafx.graphic.Directory;
import fr.ensibs.javafx.graphic.JavaFXImage;
import fr.ensibs.javafx.graphic.JavaFXImageLoader;
import fr.ensibs.model.Sprite;
import fr.ensibs.model.SpriteConverter;
import fr.ensibs.util.graphic.ISnapshotLayer;
import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.io.IJsonConverter;
import fr.ensibs.util.io.SnapshotConverter;
import javafx.scene.image.Image;
import org.json.JSONObject;

import java.util.Map;

public class JsonConverterFactory {
    IJsonConverter converter;

    public JsonConverterFactory(JSONObject jsonObject) {
        //get the type of converter to return
        String name = jsonObject.getClass().getName();
        System.out.println(name);
        switch (name) {
            case "org.json.JSONObject":
                if (jsonObject.has("snapshot")) {
                    SnapshotConverter<JavaFXImage> snapshotConverter = new SnapshotConverter<>(imgCollection);
                    this.converter = snapshotConverter;
                } else if (jsonObject.has("sprite")) {
                    SpriteConverter<JavaFXImage> spriteConverter = new SpriteConverter<>(imgCollection);
                    this.converter = spriteConverter;
                }
                break;
            default:
        }
    }
}
