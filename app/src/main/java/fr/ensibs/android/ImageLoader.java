package fr.ensibs.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IImageLoader;

public class ImageLoader implements IImageLoader {

    @Override
    public IImage load(InputStream in) throws IOException {
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        return new Image(bitmap, bitmap.toString());
    }

    @Override
    public void save(Object obj, OutputStream out) throws Exception {

    }

    @Override
    public void save(IImage image, OutputStream out) throws IOException {

    }
}
