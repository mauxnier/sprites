package fr.ensibs.util.io;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.graphic.SnapshotLayer;

public class SnapshotConverter<T extends IImage> implements IJsonConverter<Snapshot<T>> {

    private Map<String, T> images;

    public SnapshotConverter() {
        this.images = new HashMap<>();
    }

    public SnapshotConverter(Map<String, T> map) {
        this.images = map;
    }

    @Override
    public Snapshot<T> fromJson(JSONObject obj) throws ParseException {
        JSONArray layers = obj.getJSONArray("layers");
        SnapshotLayerConverter<T> slc = new SnapshotLayerConverter<T>(this.images);
        Snapshot<T> snapshot = new Snapshot<T>();

        if (layers != null) {
            for (int i = 0; i < layers.length(); i++) {
                System.out.println("i");
                System.out.println(i);
                System.out.println(layers.getJSONObject(i));
                SnapshotLayer<T> layer = slc.fromJson(layers.getJSONObject(i));
                snapshot.add(layer);
            }
        }
        else {
            throw new ParseException(null, 0);
        }

        return snapshot;
    }

    @Override
    public JSONObject toJson(Snapshot<T> obj) {
        SnapshotLayerConverter<T> slc = new SnapshotLayerConverter<T>(this.images);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonLayers = new JSONArray();
        List<SnapshotLayer<T>> layers = obj.getList();

        for (SnapshotLayer<T> layer : layers) {
            jsonLayers.put(slc.toJson(layer));
        }

        jsonObject.put("layers", jsonLayers);
        return jsonObject;
    }
    
}
