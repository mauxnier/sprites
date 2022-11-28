package fr.ensibs.model;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import fr.ensibs.util.io.SnapshotConverter;
import javafx.scene.image.Image;
import org.json.JSONObject;

import java.util.Map;

public class JsonConverterFactory<T extends IImage<Image>> {

    public JsonConverterFactory() {

    }

    public IJsonConverter<?> makeConverter(JSONObject jsonObject, Map<String, T> imgCollection) {
        IJsonConverter<?> converter = null;

        if (jsonObject.has("snapshot")) {
            converter = new SnapshotConverter<>(imgCollection);
        } else if (jsonObject.has("sprite")) {
            converter = new SpriteConverter<>(imgCollection);
        }

        return converter;
    }
}
