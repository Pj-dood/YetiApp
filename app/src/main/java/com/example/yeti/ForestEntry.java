package com.example.yeti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ForestEntry extends AppCompatActivity {
    private MediaPlayer bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forest_entry);
        Button Start = findViewById(R.id.next_button);
        Button Back = findViewById(R.id.back_button);
        ImageView WaterB1 = findViewById(R.id.waterView1);
        ImageView WaterB2 = findViewById(R.id.waterView2);
        ImageView BirdsB = findViewById(R.id.birdsView);
        ImageView GrassB = findViewById(R.id.grassView);
        ImageView TreeB = findViewById(R.id.treeView);
        ButterflyView butterflyView = new ButterflyView(this);
        LinearLayout layout = findViewById(R.id.layout);
        layout.addView(butterflyView);
        butterflyView.startAnimation();
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BridgeActivity.class);
                //intent.putExtra(key, value);
                // start the activity connect to the specified class
                if (bm != null) {
                    bm.stop();
                    bm.release();
                }
                startActivity(intent);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra(key, value);
                // start the activity connect to the specified class
                if (bm != null) {
                    bm.stop();
                    bm.release();
                }
                startActivity(intent);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.testsound);
        WaterB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        WaterB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.birdsound);
        BirdsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
            }
        });
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.treesound);
        TreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
            }
        });
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.grasssound);
        GrassB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Initialize the media player
        bm = MediaPlayer.create(this, R.raw.classical_guitar);
        bm.setLooping(true);
        bm.start();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

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