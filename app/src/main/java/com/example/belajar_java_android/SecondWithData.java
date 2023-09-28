package com.example.belajar_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondWithData extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_with_data);
        TextView textViewWData = findViewById(R.id.tv_data);
        String data = getIntent().getStringExtra(EXTRA_NAME);
        String text = "Hello " + data;
        textViewWData.setText(text);


    }
}