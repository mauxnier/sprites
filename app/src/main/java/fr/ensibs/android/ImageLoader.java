package fr.ensibs.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.io.OutputStream;

import fr.ensibs.util.io.IImageLoader;

public class ImageLoader implements IImageLoader<Image> {

    @Override
    public Image load(InputStream in) {
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        return new Image(bitmap, bitmap.toString());
    }

    @Override
    public void save(Image image, OutputStream out) {

    }
}
