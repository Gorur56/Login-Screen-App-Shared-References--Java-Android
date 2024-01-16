package com.firstapp.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnaEkranActivity extends AppCompatActivity {
    private Button buttonCikti;
    private TextView textViewCikti;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        buttonCikti = (Button) findViewById(R.id.buttonLogOut);
        textViewCikti = (TextView) findViewById(R.id.textViewCikti);

        sp = getSharedPreferences("GirisBilgi", MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username", "Kullanıcı adı yok");
        password = sp.getString("password", "Şifre yok");

        textViewCikti.setText("Username: " + username + " Password: "+ password);

        buttonCikti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("username");
                editor.putString("password","null"); //İkiside aynı anlama gelir. Biri null atar diğeri değeri siler.
                editor.commit();
                startActivity(new Intent(AnaEkranActivity.this,MainActivity.class));
                finish(); // Ekranı hafızadan siler. back tuşuna bastığımızda uygulamadan çıkış yapması için Login 'e dönmeyecektir.
            }
        });
    }
}