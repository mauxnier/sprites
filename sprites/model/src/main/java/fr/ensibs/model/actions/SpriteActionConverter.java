package fr.ensibs.model.actions;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import org.json.JSONObject;

public class SpriteActionConverter<T extends IImage<?>> implements IJsonConverter<SpriteAction<T>> {

    public SpriteAction<T> fromJson(JSONObject obj) {
        /* Visibility or Motion */
        if (obj.has("visibility")) {
            return new SpriteActionVisibility<T>(obj.getInt("time"), obj.getBoolean("visible"));
        } else {
            return new SpriteActionMotion<T>(obj.getInt("time"), obj.getInt("endTime"), obj.getInt("endX"),
                    obj.getInt("endY"));
        }
    }

    @Override
    public JSONObject toJson(SpriteAction<T> obj) {
        JSONObject jsonObject = new JSONObject();

        if (obj instanceof SpriteActionVisibility) {
            jsonObject.put("time", obj.getStartTime());
            jsonObject.put("visible", ((SpriteActionVisibility<T>) obj).isVisible());
        } else {
            jsonObject.put("time", obj.getStartTime());
            jsonObject.put("endTime", ((SpriteActionMotion<T>) obj).getEndTime());
            jsonObject.put("endX", ((SpriteActionMotion<T>) obj).getEndX());
            jsonObject.put("endY", ((SpriteActionMotion<T>) obj).getEndY());
        }
        return jsonObject;
    }
}
