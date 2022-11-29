package fr.ensibs.model.actions;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import org.json.JSONObject;

public class SpriteActionConverter<I extends IImage<?>> implements IJsonConverter<SpriteAction<I>> {

    public SpriteAction<I> fromJson(JSONObject obj) {
        /* Visibility or Motion */
        if (obj.has("visibility")) {
            return new SpriteActionVisibility<I>(obj.getInt("time"), obj.getBoolean("visible"));
        } else {
            return new SpriteActionMotion<I>(obj.getInt("time"), obj.getInt("endTime"), obj.getInt("endX"),
                    obj.getInt("endY"));
        }
    }

    @Override
    public JSONObject toJson(SpriteAction<I> obj) {
        JSONObject jsonObject = new JSONObject();

        if (obj instanceof SpriteActionVisibility) {
            jsonObject.put("time", obj.getStartTime());
            jsonObject.put("visible", ((SpriteActionVisibility<I>) obj).isVisible());
        } else {
            jsonObject.put("time", obj.getStartTime());
            jsonObject.put("endTime", ((SpriteActionMotion<I>) obj).getEndTime());
            jsonObject.put("endX", ((SpriteActionMotion<I>) obj).getEndX());
            jsonObject.put("endY", ((SpriteActionMotion<I>) obj).getEndY());
        }
        return jsonObject;
    }
}
