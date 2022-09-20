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
        Log.v(TAG, "on create");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v(TAG, "on start");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.v(TAG, "on restart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v(TAG, "on resume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v(TAG, "on pause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v(TAG, "on stop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v(TAG, "on destroy");
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