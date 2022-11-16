package fr.ensibs.util.io;

import java.text.ParseException;
import java.util.Map;
import org.json.JSONObject;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.SnapshotLayer;

public class SnapshotLayerConverter<T extends IImage> implements IJsonConverter<SnapshotLayer<T>> {

    private final Map<String, T> map;

    public SnapshotLayerConverter(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public SnapshotLayer<T> fromJson(JSONObject obj) throws ParseException {
        try {
            T image = this.map.get(obj.getString("image"));
            if (image == null) throw new ParseException(null, 0);
            return new SnapshotLayer<>(obj.getInt("x"), obj.getInt("y"), image);
        } catch (Exception e) {
            throw new ParseException(null, 0);
        }
    }

    @Override
    public JSONObject toJson(SnapshotLayer<T> obj) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("x", obj.getX());
        jsonObject.put("y", obj.getY());
        jsonObject.put("width", obj.getWidth());
        jsonObject.put("height", obj.getHeight());
        jsonObject.put("image", obj.getImage().getName());

        return jsonObject;
    }
    
}
