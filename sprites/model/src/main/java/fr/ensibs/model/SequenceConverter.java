package fr.ensibs.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.ensibs.model.actions.ISpriteAction;
import fr.ensibs.model.actions.SpriteActionConverter;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;

public class SequenceConverter<I extends IImage<?>> implements IJsonConverter<Sequence<I>> {

    private final Map<String, I> map;

    public SequenceConverter(Map<String, I> map) {
        this.map = map;
    }

    @Override
    public Sequence<I> fromJson(JSONObject obj) throws ParseException {
        SceneConverter<I> sceneConverter = new SceneConverter<I>(this.map);
        Scene<I> scene = sceneConverter.fromJson(obj);

        JSONArray actionsJSON = obj.getJSONArray("actions");
        ArrayList<ISpriteAction<I>> actions = new ArrayList<ISpriteAction<I>>();
        SpriteActionConverter<I> spriteActionConverter = new SpriteActionConverter<I>();

        for (int i = 0; i < actionsJSON.length(); i++) {
            actions.add(spriteActionConverter.fromJson(actionsJSON.getJSONObject(i)));
        }

        return new Sequence<I>(actions, scene.getBackground());
    }

    @Override
    public JSONObject toJson(Sequence<I> obj) {
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
