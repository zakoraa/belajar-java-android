package com.example.belajar_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText ;
    private EditText emailEditText ;
    private EditText passwordEditText ;
    private Button loginButton ;
    private TextView getNameTextView ;
    private TextView getEmailTextView ;
    private TextView getPassTextView ;
    private Resources res;

    private void initView(){
         nameEditText = findViewById(R.id.nameEditText);
         emailEditText = findViewById(R.id.emailEditText);
         passwordEditText= findViewById(R.id.passwordEditText);
         loginButton = findViewById(R.id.doLoginButton);
         getNameTextView = findViewById(R.id.getNameSuccessTextView);
         getEmailTextView = findViewById(R.id.getEmailSuccessTextView);
         getPassTextView = findViewById(R.id.getPassSuccessTextView);
         res = getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

        initView();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String pass = passwordEditText.getText().toString();

                String getNameSuccess = res.getString(R.string.get_name_success, name);
                String getEmailSuccess = res.getString(R.string.get_email_success, email);
                String getPassSuccess = res.getString(R.string.get_pass_success, pass);
//                String[] fullName = res.getStringArray(R.array.full_name);
                if(name.length() == 0){
                    getNameTextView.setText("");
                }else {
                    getNameTextView.setText(getNameSuccess);
                }

                if(email.length() == 0){
                    getEmailTextView.setText("");
                }else {
                    getEmailTextView.setText(getEmailSuccess);
                }
                if(pass.length() == 0){
                    getPassTextView.setText("");
                }else {
                    getPassTextView.setText(getPassSuccess);
                }
            }
        });
    }
}