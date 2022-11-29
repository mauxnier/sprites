package fr.ensibs.model;

import java.text.ParseException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;

public class SceneConverter<I extends IImage<?>> implements IJsonConverter<Scene<I>> {

    private final Map<String, I> map;

    public SceneConverter(Map<String, I> map) {
        this.map = map;
    }

    @Override
    public Scene<I> fromJson(JSONObject obj) throws ParseException {
        I image = this.map.get(obj.getString("background"));
        Scene<I> scene = new Scene<I>(image);

        JSONArray sprites = obj.getJSONArray("sprites");
        SpriteConverter<I> spriteConverter = new SpriteConverter<I>(this.map);

        for (int i = 0; i < sprites.length(); i++) {
            scene.add(spriteConverter.fromJson(sprites.getJSONObject(i)));
        }

        return scene;
    }

    @Override
    public JSONObject toJson(Scene<I> obj) {
        JSONObject jsonObject = new JSONObject();

        JSONArray sprites = new JSONArray();
        SpriteConverter<I> spriteConverter = new SpriteConverter<I>(this.map);

        for (int i = 0; i < obj.size(); i++) {
            sprites.put(spriteConverter.toJson((Sprite<I>) obj.get(i)));
        }

        jsonObject.put("background", obj.getBackground().getName());
        jsonObject.put("sprites", sprites);

        return jsonObject;
    }

}
