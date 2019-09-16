package com.livedatademo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tvData);
        //MainActivityDataGenerator mainActivityDataGenerator = new MainActivityDataGenerator();
        final MainActivityDataGenerator mainActivityDataGenerator = ViewModelProviders.of(this).get(MainActivityDataGenerator.class);
        LiveData<String> myRandomNumber = mainActivityDataGenerator.getNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvData.setText(s);
            }
        });

        findViewById(R.id.btnGenerateId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityDataGenerator.generateNumber();
            }
        });

    }
}