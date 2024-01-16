package com.firstapp.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private Button girisButton;

    private SharedPreferences sp;

    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        girisButton = (Button) findViewById(R.id.buttonGiris);

        sp = getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor = sp.edit();

        girisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUsername.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("12345"))
                {
                    editor.putString("username", editTextUsername.toString());
                    editor.putString("password", editTextPassword.toString());
                    editor.commit();

                    startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
                }
            }
        });
    }
}