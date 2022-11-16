package fr.ensibs.android;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;
import fr.ensibs.util.io.ILoader;

public class ImageLoader implements ILoader {

    @Override
    public Object load(InputStream in) throws Exception {
        return BitmapFactory.decodeStream(in);
    }

    @Override
    public void save(Object obj, OutputStream out) throws Exception {

    }
}
