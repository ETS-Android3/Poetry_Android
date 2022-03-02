package com.KIPTSOFT.Shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.Toast;

import com.KIPTSOFT.Shayari.R;

public class Page_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_about);


        ScrollView ScrollView = findViewById(R.id.sc);
        AnimationDrawable animationDrawable = (AnimationDrawable) ScrollView.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
        findViewById(R.id.telegram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri1 = Uri.parse("https://t.me/ShayariappSupport");
                    startActivity(new Intent(Intent.ACTION_VIEW,uri1));
                }catch (Exception e)
                {
                    Toast.makeText(Page_about.this, "Telegram Not Install", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.gmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "kiptsoft.appfeedback@gmail.com"));
                startActivity(intent);
            }
        });

    }
}