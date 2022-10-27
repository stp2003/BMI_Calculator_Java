package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TextView mCurrentHeight;
    TextView mCurrentWeight, mCurrentAge;
    ImageView mIncrementAge, mDecrementAge, mIncrementWeight, mDecrementWeight;
    SeekBar mSeeBarForHeight;
    Button mCalculateBMI;
    RelativeLayout mMale, mFemale;

    int int_weight = 55;
    int int_age = 22;
    int current_progress;
    String m_int_progress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "22";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mCurrentAge = findViewById(R.id.currentAge);
        mCurrentWeight = findViewById(R.id.currentWeight);
        mCurrentHeight = findViewById(R.id.currentHeight);
        mIncrementAge = findViewById(R.id.incrementAge);
        mDecrementAge = findViewById(R.id.decrementAge);
        mIncrementWeight = findViewById(R.id.incrementWeight);
        mDecrementWeight = findViewById(R.id.decrementWeight);
        mCalculateBMI = findViewById(R.id.calculateBMI);
        mSeeBarForHeight = findViewById(R.id.seekBarForHeight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);


        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfUser = "Male";

            }
        });


        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfUser = "Female";
            }
        });

        mSeeBarForHeight.setMax(300);
        mSeeBarForHeight.setProgress(170);
        mSeeBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                current_progress = progress;
                m_int_progress = String.valueOf(current_progress);
                mCurrentHeight.setText(m_int_progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int_weight = int_weight + 1;
                weight2 = String.valueOf(int_weight);
                mCurrentWeight.setText(weight2);
            }
        });

        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int_age = int_age + 1;
                age2 = String.valueOf(int_age);
                mCurrentAge.setText(age2);
            }
        });


        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int_age = int_age - 1;
                age2 = String.valueOf(int_age);
                mCurrentAge.setText(age2);
            }
        });


        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int_weight = int_weight - 1;
                weight2 = String.valueOf(int_weight);
                mCurrentWeight.setText(weight2);
            }
        });


        mCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeOfUser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (m_int_progress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                } else if (int_age == 0 || int_age < 0) {
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (int_weight == 0 || int_weight < 0) {
                    Toast.makeText(getApplicationContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, bmiActivity.class);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", m_int_progress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);

                }
            }
        });

    }
}

