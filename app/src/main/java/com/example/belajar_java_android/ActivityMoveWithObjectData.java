package com.example.belajar_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityMoveWithObjectData extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    private void initView(){
        tvObject = findViewById(R.id.tv_object);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object_data);

        initView();

        Person person;
        if(Build.VERSION.SDK_INT >= 33){
            person = getIntent().getParcelableExtra(EXTRA_PERSON, Person.class);
        }else{
            person = getIntent().getParcelableExtra(EXTRA_PERSON);
        }

        String text = "Name : " + person.getName() + "\nEmail : " + person.getEmail() + "\nAge : " + person.getAge() + "\nCity : " + person.getCity();
        tvObject.setText(text);

    }
}