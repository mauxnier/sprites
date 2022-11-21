package fr.ensibs.model;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

public class SpriteConverter<T extends IImage<Image>> implements IJsonConverter<Sprite<T>> {

    private final Map<String, T> map;

    public SpriteConverter(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public Sprite<T> fromJson(JSONObject obj) {
        String name = obj.getString("name");
        int duration = obj.getInt("duration");
        int x = obj.getInt("x");
        int y = obj.getInt("y");
        boolean visible = obj.getBoolean("visible");
        JSONArray jsonArray = obj.getJSONArray("images");
        Sprite<T> spriteObj = new Sprite<>(name, x, y, duration, 0, visible);

        // Parsing des images composant le sprite
        for (int i = 0; i < jsonArray.length(); i ++) {
            spriteObj.add(this.map.get(jsonArray.getString(i)));
        }

        return spriteObj;
    }

    @Override
    public JSONObject toJson(Sprite<T> obj) {
        ArrayList<String> img_names = new ArrayList<>();

        // Ajout des noms des images à la liste
        for (int i = 0; i < obj.size(); i ++) {
            img_names.add(obj.getName());
        }

        JSONArray array = new JSONArray(img_names.toArray());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", obj.getName());
        jsonObject.put("duration", obj.getDuration());
        jsonObject.put("images", array);
        jsonObject.put("x", obj.getX());
        jsonObject.put("y", obj.getY());
        jsonObject.put("visible", obj.isVisible());
        return jsonObject;
    }
}
