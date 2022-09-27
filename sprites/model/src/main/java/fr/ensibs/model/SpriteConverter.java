package fr.ensibs.model;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class SpriteConverter implements IJsonConverter<Sprite<IImage>> {

    private HashMap<String, IImage> map;

    public SpriteConverter(HashMap<String, IImage> map) {
        this.map = map;
    }

    @Override
    public Sprite fromJson(JSONObject obj) throws ParseException {
        String name = obj.getString("name");
        int duration = obj.getInt("duration");
        int x = obj.getInt("x");
        int y = obj.getInt("y");
        boolean visible = obj.getBoolean("visible");
        JSONArray jsonArray = obj.getJSONArray("images");
        Sprite s = new Sprite(name,x,y,duration,0,visible);
        for (int i = 0; i < jsonArray.length(); i ++)
        {
            s.add(this.map.get(jsonArray.getString(i)));
        }
        return s;
    }

    @Override
    public JSONObject toJson(Sprite obj) {
        ArrayList<String> img_names = new ArrayList<String>();
        for (int i = 0; i < obj.size(); i ++)
        {
            img_names.add((String) obj.get(i));
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
