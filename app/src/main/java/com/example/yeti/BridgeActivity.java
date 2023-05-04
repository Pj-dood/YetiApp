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

public class BridgeActivity extends AppCompatActivity {
    private MediaPlayer bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bridge);
        Button Back = findViewById(R.id.back_button);
        ImageView ForestB1 = findViewById(R.id.treeView);
        ImageView ForestB2 = findViewById(R.id.treeView2);
        ImageView BridgeB = findViewById(R.id.bridgeView);
        ImageView ForestB3 = findViewById(R.id.treeView3);
        ButterflyView butterflyView = new ButterflyView(this);
        LinearLayout layout = findViewById(R.id.layout);
        layout.addView(butterflyView);
        butterflyView.startAnimation();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.grasssound);
        ForestB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        ForestB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        ForestB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.wooden_bridge);
        BridgeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp2.start();
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
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
        // Initialize the media player
        bm = MediaPlayer.create(this, R.raw.classical_guitar);
        bm.setLooping(true);
        bm.start();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ForestEntry.class);
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