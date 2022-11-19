package fr.ensibs.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.io.IImageLoader;
import fr.ensibs.util.io.JsonLoader;
import fr.ensibs.util.io.SnapshotConverter;
import fr.ensibs.util.io.TextLoader;
import fr.ensibs.util.io.ZipLoader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import fr.ensibs.android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final JsonLoader jsonLoader = new JsonLoader();
    private final TextLoader textLoader = new TextLoader();
    private final IImageLoader imgLoader = new ImageLoader();

    private final ZipLoader<Image> zipLoader = new ZipLoader<Image>(jsonLoader, textLoader, imgLoader);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            InputStream stream = this.getAssets().open("examples.zip");
            ZipInputStream zis = new ZipInputStream(stream);
            Map<String, Object> content = zipLoader.load(zis);

            Map<String, Image> imgCollection = this.getImgFromDirectory(content);
            SnapshotConverter<Image> snapshotConverter = new SnapshotConverter<>(imgCollection);
            JSONObject json = (JSONObject) content.get("snapshot.json");
            Snapshot<Image> snapshot = snapshotConverter.fromJson(json);

            ComposeImageView imageView = findViewById(R.id.image);
            imageView.setSnapshot(snapshot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Image> getImgFromDirectory(Map<String, Object> content) {
        Map<String, Image> imgCollection = new HashMap<>();

        for (Map.Entry<String, Object> entry : content.entrySet()) {
            String name = entry.getValue().getClass().getName();
            if (name.equals(Image.class.getName())) {
                imgCollection.put(entry.getKey(), (Image) entry.getValue()); // si un fichier est une image alors on l'ajoute à la nouvelle collection
            }
        }
        return imgCollection;
    }
}