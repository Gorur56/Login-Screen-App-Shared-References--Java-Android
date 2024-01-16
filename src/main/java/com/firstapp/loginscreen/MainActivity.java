package com.firstapp.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private Button girisButton;

    private SharedPreferences sp;

    private SharedPreferences.Editor editor;

    private String username;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        girisButton = (Button) findViewById(R.id.buttonGiris);

        sp = getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","Kullanıcı adı yok");
        password = sp.getString("password","Şifre yok");

        if (username.equals("admin") && password.equals("12345"))
        {
            //Çıkış yapmadığımda arka plandan açınca tekrar Ana sayfa gelmesi için
            startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
            finish(); // back tuşuna bastığımızda uygulamadan çıkış yapması için anasayfaya dönmeyecektir.
        }

        girisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUsername.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("12345"))
                {
                    editor.putString("username", editTextUsername.getText().toString());
                    editor.putString("password", editTextPassword.getText().toString());
                    editor.commit();

                    startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
                    finish(); // back tuşuna bastığımızda uygulamadan çıkış yapması için anasayfaya dönmeyecektir.
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Giriş Hatalı", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}