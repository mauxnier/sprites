package fr.ensibs.android;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import fr.ensibs.util.io.ILoader;
import fr.ensibs.util.io.JsonLoader;
import fr.ensibs.util.io.TextLoader;
import fr.ensibs.util.io.ZipLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import fr.ensibs.android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final JsonLoader jsonLoader = new JsonLoader();
    private final TextLoader textLoader = new TextLoader();
    private final ILoader imgLoader = new ImageLoader();

    private final ZipLoader<Image> zipLoader = new ZipLoader<>(jsonLoader, textLoader, imgLoader);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            InputStream stream = this.getAssets().open("zip.zip");
            ZipInputStream zis = new ZipInputStream(stream);
            Map<String, Object> content = zipLoader.load(zis);

            Set<String> keys = content.keySet();

            for (String key : keys ) {
                System.out.println(key);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}