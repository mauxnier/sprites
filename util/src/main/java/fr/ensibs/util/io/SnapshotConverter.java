package fr.ensibs.util.io;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.graphic.SnapshotLayer;

public class SnapshotConverter implements IJsonConverter<Snapshot> {

    private HashMap<String, IImage> images;

    public SnapshotConverter(HashMap<String, IImage> map) {
        this.images = map;
    }

    @Override
    public Snapshot fromJson(JSONObject obj) throws ParseException {
        JSONArray layers = obj.optJSONArray("layers");
        SnapshotLayerConverter slc = new SnapshotLayerConverter(this.images);
        Snapshot snapshot = new Snapshot();

        for (int i = 0; i < layers.length(); i++) {
            SnapshotLayer layer = slc.fromJson(layers.getJSONObject(i));
            snapshot.add(layer);
        }

        return snapshot;
    }

    @Override
    public JSONObject toJson(Snapshot obj) {
        SnapshotLayerConverter slc = new SnapshotLayerConverter(this.images);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonLayers = new JSONArray();
        List<SnapshotLayer> layers = obj.getList();

        for (SnapshotLayer layer : layers) {
            jsonLayers.put(slc.toJson(layer));
        }

        jsonObject.put("layers", jsonLayers);
        return jsonObject;
    }
    
}
