package fr.ensibs.android;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.messageView = findViewById(R.id.messageView);
    }

    public void start(View view)
    {
        Log.d(TAG, "Starting...");
        this.messageView.setText(R.string.started_text);
        Log.d(TAG, "Started");
    }

    public void stop(View view)
    {
        Log.d(TAG, "Stopping...");
        this.messageView.setText(R.string.stopped_text);
        Log.d(TAG, "Stopped");
    }
}