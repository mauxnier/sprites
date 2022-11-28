package fr.ensibs.model;

import java.text.ParseException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;

public class SceneConverter<T extends IImage> implements IJsonConverter<Scene<T>> {

    private final Map<String, T> map;

    public SceneConverter(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public Scene<T> fromJson(JSONObject obj) throws ParseException {
        T image = this.map.get(obj.getString("background"));
        Scene<T> scene = new Scene<T>(image);

        JSONArray sprites = obj.getJSONArray("sprites");
        SpriteConverter<T> spriteConverter = new SpriteConverter<T>(this.map);

        for (int i = 0; i < sprites.length(); i++) {
            scene.add(spriteConverter.fromJson(sprites.getJSONObject(i)));
        }

        return scene;
    }

    @Override
    public JSONObject toJson(Scene<T> obj) {
        JSONObject jsonObject = new JSONObject();

        JSONArray sprites = new JSONArray();
        SpriteConverter<T> spriteConverter = new SpriteConverter<T>(this.map);

        for (int i = 0; i < obj.size(); i++) {
            sprites.put(spriteConverter.toJson((Sprite<T>) obj.get(i)));
        }

        jsonObject.put("background", obj.getBackground().getName());
        jsonObject.put("sprites", sprites);

        return jsonObject;
    }

}
