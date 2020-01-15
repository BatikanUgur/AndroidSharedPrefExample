package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button buttonKaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKaydet = (Button) findViewById(R.id.buttonKaydet);


        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("KisiselBilgiler",MODE_PRIVATE);

                SharedPreferences.Editor e = sp.edit();

                e.putString("ad","Batıkan");
                e.putInt("yas",18);
                e.putFloat("boy",186);
                e.putBoolean("bekar",true);

                Set<String> arkadasListesi = new HashSet<>();

                arkadasListesi.add("İpek");
                arkadasListesi.add("Doğukan");

                e.putStringSet("arkadasListesi",arkadasListesi);
                e.commit();




                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
