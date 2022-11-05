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


    TextView mBMIDisplay, mAgeDisplay, mWeightDisplay, mHeightDisplay, mBMICategory, mGender;
    Button mGotoMain;
    Intent intent;

    ImageView mImageView;
    String mBMI;
    String category;
    float intBMI;

    String height;
    String weight;

    float intHeight, intWeight;

    RelativeLayout mBackground;

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
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
        mBMIDisplay = findViewById(R.id.bmiDisplay);

        mBMICategory = findViewById(R.id.bmiCategoryDisplay);
        mGotoMain = findViewById(R.id.gotoMain);

        mImageView = findViewById(R.id.imageview);


        mGender = findViewById(R.id.genderDisplay);
        mBackground = findViewById(R.id.contentLayout);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");


        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight / 100;
        intBMI = intWeight / (intHeight * intHeight);


        mBMI = Float.toString(intBMI);
        System.out.println(mBMI);

        if (intBMI < 16) {
            mBMICategory.setText("Severe Thinness");

            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);


        } else if (intBMI < 16.9 && intBMI > 16) {
            mBMICategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageView.setImageResource(R.drawable.warning);


        } else if (intBMI < 18.4 && intBMI > 17) {
            mBMICategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageView.setImageResource(R.drawable.warning);

        } else if (intBMI < 24.9 && intBMI > 18.5) {
            mBMICategory.setText("Normal");
            mImageView.setImageResource(R.drawable.ok);

        } else if (intBMI < 29.9 && intBMI > 25) {
            mBMICategory.setText("Overweight");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageView.setImageResource(R.drawable.warning);

        } else if (intBMI < 34.9 && intBMI > 30) {
            mBMICategory.setText("Obese Class I");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageView.setImageResource(R.drawable.warning);

        } else {
            mBMICategory.setText("Obese Class II");
            mBackground.setBackgroundColor(R.color.warn);
            mImageView.setImageResource(R.drawable.crosss);

        }


        mGender.setText(intent.getStringExtra("gender"));
        mBMIDisplay.setText(mBMI);


        mGotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent1);
            }
        });


    }
}
