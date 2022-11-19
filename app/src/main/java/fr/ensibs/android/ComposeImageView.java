package fr.ensibs.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import fr.ensibs.util.graphic.Snapshot;

public class ComposeImageView extends View {

    private Snapshot<Image> snapshot;

    ComposeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect = new Rect();
        rect.left = 10;
        rect.top = 10;
        rect.right = rect.left + 10;
        rect.bottom = rect.top + 10;
        Paint paint = new Paint ();
        paint.setColor (Color. GREEN);
        canvas.drawRect (rect, paint);

        // if (snapshot != null) {
        //     for (ISnapshotLayer<Image> layer : snapshot.getList()) {
        //         Image image = layer.getImage();
        //         canvas.drawBitmap(image.getImage(), 0, 0, null);
        //     }
        // }
    }

    public void setSnapshot(Snapshot<Image> snapshot) {
        this.snapshot = snapshot;
    }
}
