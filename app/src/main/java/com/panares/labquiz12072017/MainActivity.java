package com.panares.labquiz12072017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText et_user;
    EditText et_pass;
    Button btn_Rem;
    Button btn_Login;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_user = (EditText) findViewById(R.id.etUser);
        et_pass = (EditText) findViewById(R.id.etPass);
        btn_Rem = (Button) findViewById(R.id.btnRemMe);
        btn_Login = (Button) findViewById(R.id.btnLogin);
        preferences = (getPreferences(Context.MODE_PRIVATE));

        et_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String user = preferences.getString("username","");
                String pwd = preferences.getString("password","");

                if (user.equals(et_user.getText())){
                    et_pass.setText(pwd);
                    et_pass.setBackgroundColor(Color.YELLOW);
                }
                else{
                    et_pass.setBackgroundColor(Color.WHITE);
                }
            }
        });

    }

    public void rememberMe (View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_user.getText().toString());
        editor.putString("password", et_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preference Saved!", Toast.LENGTH_SHORT).show();

    }

    public void login (View view){

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}
