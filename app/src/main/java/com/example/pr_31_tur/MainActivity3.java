package com.example.pr_31_tur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{
    String UrlYandex = "https://natk.ru/stud-grad/schedule/187?group=%D0%9F%D0%A0-22.106";
    Button btnRas;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnRas = findViewById(R.id.buttonRas);
        btnRas.setOnClickListener((View.OnClickListener) MainActivity3.this);
        MainActivity3.MyGestureListener gestureListener = new MainActivity3.MyGestureListener();
        mDetector = new GestureDetectorCompat(this, gestureListener);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonRas) {

            openWebPage(UrlYandex);
        }
    }
    private void openWebPage(String url) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse(url));
        startActivity(myWebLink);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            if ((event1.getY() - event2.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD)) {
                // Свайп вниз
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);

            }
            return super.onFling(event1, event2, velocityX, velocityY);
        }
    }
}