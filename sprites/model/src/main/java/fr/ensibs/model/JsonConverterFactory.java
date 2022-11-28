package fr.ensibs.model;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import fr.ensibs.util.io.SnapshotConverter;

import java.util.Map;

public class JsonConverterFactory<T extends IImage<?>> {

    public JsonConverterFactory() {

    }

    public IJsonConverter<?> makeConverter(String filename, Map<String, T> imgCollection) throws Exception {
        IJsonConverter<?> converter;

        if (filename.contains("snapshot")) {
            converter = new SnapshotConverter<>(imgCollection);
        } else if (filename.contains("sprite")) {
            converter = new SpriteConverter<>(imgCollection);
        } else {
            throw new Exception("Could not make appropriate JsonConverter");
        }

        return converter;
    }
}
