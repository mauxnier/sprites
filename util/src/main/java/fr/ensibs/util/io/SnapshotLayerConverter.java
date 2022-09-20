package fr.ensibs.util.io;

import java.text.ParseException;
import java.util.HashMap;
import org.json.JSONObject;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.SnapshotLayer;

public class SnapshotLayerConverter implements IJsonConverter<SnapshotLayer> {

    private HashMap<String, IImage> map;

    public SnapshotLayerConverter(HashMap<String, IImage> map) {
        this.map = map;
    }

    @Override
    public SnapshotLayer fromJson(JSONObject obj) throws ParseException {
        return new SnapshotLayer(obj.getInt("x"), obj.getInt("y"), this.map.get(obj.getString("name")));
    }

    @Override
    public JSONObject toJson(SnapshotLayer obj) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("x", obj.getX());
        jsonObject.put("y", obj.getY());
        jsonObject.put("name", obj.getImage().getName());

        return jsonObject;
    }
    
}
