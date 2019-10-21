package com.example.cityandimage4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        CityModel cityModel = intent.getParcelableExtra("pars");

        int cityImage = cityModel.getCityImage();
        String cityName = cityModel.getCityName();
        String cityUrl = cityModel.getCityUrl();

        ImageView imageView =findViewById(R.id.imageView2);
        imageView.setImageResource(cityImage);

        TextView textView3 =findViewById(R.id.textView3);
        textView3.setText(cityName);

        TextView textView4 =findViewById(R.id.textView4);
        textView4.setText(cityUrl);



    }
}
