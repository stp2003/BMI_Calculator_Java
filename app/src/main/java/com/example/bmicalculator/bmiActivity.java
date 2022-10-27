package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

public class bmiActivity extends AppCompatActivity {


    TextView mbmidisplay, magedisplay, mweightdisplay, mheightdisplay, mbmicategory, mgender;
    Button mgotomain;
    Intent intent;

    ImageView mimageview;
    String mbmi;
    String cateogory;
    float intbmi;

    String height;
    String weight;

    float intheight, intweight;

    RelativeLayout mbackground;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");


        intent = getIntent();
        mbmidisplay = findViewById(R.id.bmiDisplay);

        mbmicategory = findViewById(R.id.bmiCategoryDisplay);
        mgotomain = findViewById(R.id.gotoMain);

        mimageview = findViewById(R.id.imageview);


        mgender = findViewById(R.id.genderDisplay);
        mbackground = findViewById(R.id.contentLayout);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");


        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;
        intbmi = intweight / (intheight * intheight);


        mbmi = Float.toString(intbmi);
        System.out.println(mbmi);

        if (intbmi < 16) {
            mbmicategory.setText("Severe Thinness");

            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);


        } else if (intbmi < 16.9 && intbmi > 16) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);


        } else if (intbmi < 18.4 && intbmi > 17) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);

        } else if (intbmi < 24.9 && intbmi > 18.5) {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);

        } else if (intbmi < 29.9 && intbmi > 25) {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);

        } else if (intbmi < 34.9 && intbmi > 30) {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);

        } else {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(R.color.warn);
            mimageview.setImageResource(R.drawable.crosss);

        }


        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}