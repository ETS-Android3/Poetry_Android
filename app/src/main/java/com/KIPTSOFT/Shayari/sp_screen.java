package com.KIPTSOFT.Shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Toast;

public class sp_screen extends AppCompatActivity {
    Animation top, bottom;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sp_screen);


        // top = AnimationUtils.loadAnimation(this, R.anim.top);
        // top = AnimationUtils.loadAnimation(this, R.anim.bottom);
       /* TextView imageView = findViewById(R.id.textsp);
        TextView text = findViewById(R.id.text);
//ImageView imageView1 = findViewById(R.id.side);
        text.animate().translationYBy(-400).setDuration(400).setStartDelay(0);
        imageView.animate().translationYBy(600).setDuration(600).setStartDelay(0);
      //  imageView1.animate().translationX(-100).setDuration(1000).setStartDelay(1000);
       // imageView.setAnimation(top);
        //text.setAnimation(bottom);*/
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(sp_screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        checkConnectivity();
    }

    private void checkConnectivity() {


        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        if ((info == null || !info.isConnected() || !info.isAvailable())) {
            Toast.makeText(getApplicationContext(), "No Internet Network", Toast.LENGTH_SHORT).show();
            finish();
        } else {

        }



    }
}