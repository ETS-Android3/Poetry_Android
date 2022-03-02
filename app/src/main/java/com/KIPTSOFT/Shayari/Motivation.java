package com.KIPTSOFT.Shayari;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Motivation extends AppCompatActivity {
    RecyclerView recyclerView;
    String s1[];
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        recyclerView =  findViewById(R.id.r1);

       /* CardView textView12 = findViewById(R.id.c1);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) textView12.getBackground();
        textView12.setEnterFadeDuration(2000);
        textView12.setExitFadeDuration(4000);
        textView12.start();*/
       /* RecyclerView constraintLayout = findViewById(R.id.r1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        //********************************************
        //**********************************************

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5449642119113086/1666381173");
        // MobileAds.initialize(this,"ca-app-pub-5449642119113086/3305902539");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //*************************************
        //  getActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.backbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        //**********************************************



        s1 = getResources().getStringArray(R.array.motivation);

        String[] firstName = s1;
        List<String> strList = Arrays.asList(firstName);
        Collections.shuffle(strList);
        firstName = strList.toArray(new String[strList.size()]);

        AdpMotivation AdpMotivation = new AdpMotivation(Motivation.this,firstName);
        recyclerView.setAdapter(AdpMotivation);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
class AdpMotivation extends RecyclerView.Adapter<AdpMotivation.MyViewHolder> {
    String data[];
    Context context;
    public AdpMotivation(Context c1,String s1[])
    {
        context = c1;
        data = s1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
        holder.whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, data[position]);
                try {
                    context.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, "Whatsapp Not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIn;
                myIn = new Intent(context,Allinone.class);
                myIn.putExtra("tit",data[position]);
                context.startActivity(myIn);
            }
        });
        holder.gridLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_row));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT  , data[position]);
                intent.setType("text/plain");
                context.startActivity(intent);
            }
        });
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", data[position]);
                if (clipboard == null || clip == null) return;
                Toast.makeText(holder.itemView.getContext(), "copied", Toast.LENGTH_SHORT).show();
                clipboard.setPrimaryClip(clip);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView textView2,button,down ;
        ImageView whatsapp;
        LinearLayout gridLayout;
        ImageView c1;
        TextView allineone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.a1);
            allineone = itemView.findViewById(R.id.allinone);
            button = itemView.findViewById(R.id.share1);
            textView2 =itemView.findViewById(R.id.copy1);
            whatsapp = itemView.findViewById(R.id.whatsapp1);
            gridLayout=itemView.findViewById(R.id.gridanmation);
            c1=itemView.findViewById(R.id.c1);
        }
    }

}
