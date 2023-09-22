package com.example.belajar_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

        EditText nameEditText = findViewById(R.id.nameEditText);
        
        Button loginButton = findViewById(R.id.doLoginButton);

        TextView loginSuccess = findViewById(R.id.loginSuccessTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String name = nameEditText.getText().toString();
                if(name.length() == 0){
                    loginSuccess.setText("");
                }else {
                    loginSuccess.setText("Login Success, Welcome " + name);
                }
            }
        });
        
        
    }
}