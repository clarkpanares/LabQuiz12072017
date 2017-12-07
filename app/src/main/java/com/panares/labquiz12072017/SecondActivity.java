package com.panares.labquiz12072017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtVUser;
    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtVUser = (TextView) findViewById(R.id.txtV_User);
        Logout = (Button) findViewById(R.id.btnLogout);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user = preferences.getString("username","");

        txtVUser.setText(user);
    }

    public void logout (View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
