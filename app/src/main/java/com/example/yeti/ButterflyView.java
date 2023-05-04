package com.example.yeti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class ButterflyView extends View {

    private int x, y;
    private int width, height;
    private int dx = 5, dy = 5;

    public ButterflyView(Context context) {
        super(context);
        x = 0;
        y = 0;
        width = 100;
        height = 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap butterfly = BitmapFactory.decodeResource(getResources(), R.drawable.butterfly_image);
        Rect rect = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(butterfly, null, rect, null);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            // Handle touch events on the butterfly
            return true;
        }
        return false;
    }

    public void startAnimation() {
        // Create a new thread to update the position of the butterfly
        Thread animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double t = 0; // parameter for infinity shape
                while (true) {
                    // Update the position of the butterfly
                    x = (int) (getWidth() / 2 + 100 * Math.sin(t)); // x position
                    y = (int) (getHeight() / 2 + 50 * Math.sin(2 * t)); // y position
                    t += 0.1; // increment t for next position
                    // Redraw the butterfly at its new position
                    postInvalidate();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        animationThread.start(); // start the thread
    }
}

