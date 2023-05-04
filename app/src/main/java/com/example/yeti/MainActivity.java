package com.example.yeti;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer bm;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Start = findViewById(R.id.buttonStart);
        Button Testsound = findViewById(R.id.buttonTest);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.testsound);
        Testsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForestEntry.class);
                //intent.putExtra(key, value);
                // start the activity connect to the specified class
                if (bm != null) {
                    bm.stop();
                    bm.release();
                }
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        // Quit the app when back button is pressed on the main menu
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Initialize the media player
        bm = MediaPlayer.create(this, R.raw.piano);
        bm.setLooping(true);
        bm.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bm != null) {
            bm.stop();
            bm.release();
        }
    }
}
