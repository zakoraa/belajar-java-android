package com.example.belajar_java_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private EditText nameEditText ;
    private EditText emailEditText ;
    private EditText passwordEditText ;
    private Button loginButton ;
    private TextView getNameTextView ;
    private TextView getEmailTextView ;
    private TextView getPassTextView ;
    private Resources res;
    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;
    private HomeFragment homeFragment;
    private Button buttonNav;
    private Button buttonNavWData;
    private MainActivity main;

    private void initView(){
         nameEditText = findViewById(R.id.nameEditText);
         emailEditText = findViewById(R.id.emailEditText);
         passwordEditText= findViewById(R.id.passwordEditText);
         loginButton = findViewById(R.id.doLoginButton);
         getNameTextView = findViewById(R.id.getNameSuccessTextView);
         getEmailTextView = findViewById(R.id.getEmailSuccessTextView);
         getPassTextView = findViewById(R.id.getPassSuccessTextView);
         res = getResources();
         homeFragment = new HomeFragment();
         profileFragment = new ProfileFragment();
         settingsFragment = new SettingsFragment();
         bottomNavigationView = findViewById(R.id.bottomView);
         buttonNav = findViewById(R.id.btn_nav);
         buttonNavWData = findViewById(R.id.btn_nav_w_data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.mainActivity);

        buttonNav.setOnClickListener(v->{
            if(v.getId() == R.id.btn_nav){
                Intent moveIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(moveIntent);
            }
        });

        buttonNavWData.setOnClickListener(v->{
            if(v.getId() == R.id.btn_nav_w_data){
                String name = nameEditText.getText().toString().trim();
                Intent moveIntent = new Intent(MainActivity.this, SecondWithData.class);
                moveIntent.putExtra(SecondWithData.EXTRA_NAME, name);
                startActivity(moveIntent);

            }
        });

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;
                case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                return true;
            case R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, settingsFragment).commit();
                return true;

        }
        return false;
    }

}