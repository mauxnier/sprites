package fr.ensibs.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import fr.ensibs.util.graphic.ISnapshotLayer;
import fr.ensibs.util.graphic.Snapshot;

public class ComposeImageView extends View {

    private Snapshot<Image> snapshot;

    public ComposeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (snapshot != null) {
             for (ISnapshotLayer<Image> layer : snapshot.getList()) {
                 Image image = layer.getImage();
                 canvas.drawBitmap(image.getImage(), 0, 0, null);
             }
        }
    }

    public void setSnapshot(Snapshot<Image> snapshot) {
        this.snapshot = snapshot;
    }
}
