package com.example.belajar_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText ;

    private Button loginButton ;

    private TextView loginSuccess ;

    private void initView(){
         nameEditText = findViewById(R.id.nameEditText);
         loginButton = findViewById(R.id.doLoginButton);
         loginSuccess = findViewById(R.id.loginSuccessTextView);
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
                if(name.length() == 0){
                    loginSuccess.setText("");
                }else {
                    loginSuccess.setText("Login Success, Welcome " + name);
                }
                Log.v("RS", "This is Verbose");
                Log.d("RS", "This is Debug");
                Log.i("RS", "This is Info");
                Log.w("RS", "This is Warn");
                Log.e("RS", "This is Error");

            }
        });

        
    }
}