package com.KIPTSOFT.Shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static com.KIPTSOFT.Shayari.R.*;
import static com.KIPTSOFT.Shayari.R.id.*;

public class FestivalIsolated extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_isolated);
        findViewById(dewali).setOnClickListener(this);
        findViewById(holi).setOnClickListener(this);


        //********************************************
        //  getActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.backbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        //**********************************************



    }





    @Override
    public void onClick(View v) {
        Intent myIn;
        switch (v.getId()) {
            case dewali:
                myIn = new Intent(this, FDewali.class);
                startActivity(myIn);
                break;
            case holi:
                myIn = new Intent(this, FHoli.class);
                startActivity(myIn);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}