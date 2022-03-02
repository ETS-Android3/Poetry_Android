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

public class Status extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        findViewById(statusc1).setOnClickListener(this);
        findViewById(mahakals).setOnClickListener(this);
        findViewById(dardedills).setOnClickListener(this);
        findViewById(randoms).setOnClickListener(this);
        findViewById(lifes).setOnClickListener(this);
        findViewById(girlattitude).setOnClickListener(this);
        findViewById(funnystatus).setOnClickListener(this);
        findViewById(twolinestatus).setOnClickListener(this);

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
            case statusc1:
                myIn = new Intent(this, attitudestatus.class);
                startActivity(myIn);
                break;
            case mahakals:
                myIn = new Intent(this, MahakalS.class);
                startActivity(myIn);
                break;
            case dardedills:
                myIn = new Intent(this, DardEdilS.class);
                startActivity(myIn);
                break;
            case randoms:
                myIn = new Intent(this, RandomS.class);
                startActivity(myIn);
                break;
            case lifes:
                myIn = new Intent(this, LifeS.class);
                startActivity(myIn);
                break;
            case girlattitude:
                myIn = new Intent(this, GirlAttitude.class);
                startActivity(myIn);
                break;
            case funnystatus:
                myIn = new Intent(this, Funnystatus.class);
                startActivity(myIn);
                break;
            case twolinestatus:
                myIn = new Intent(this, twolinestatus.class);
                startActivity(myIn);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}