package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {
    private Button buttonSil,buttonGuncelle;
    private TextView textViewCikti;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor e;
    private String ad;
    private int yas;
    private float boy;
    private boolean bekar;
    private Set<String> arkadasListesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonGuncelle =(Button) findViewById(R.id.buttonGuncelle);
        buttonSil = (Button) findViewById(R.id.buttonSil);
        textViewCikti = (TextView) findViewById(R.id.textViewCikti);

        sharedPreferences = getSharedPreferences("KisiselBilgiler",MODE_PRIVATE);//veri okuma

        e = sharedPreferences.edit();

        ad = sharedPreferences.getString("ad","isim yok");
        yas = sharedPreferences.getInt("yas",0);
        boy = sharedPreferences.getFloat("boy",0.0f);
        bekar = sharedPreferences.getBoolean("bekar",false);
        Set<String> arkadasListesi = sharedPreferences.getStringSet("arkadasListesi",null);

        final StringBuilder sb = new StringBuilder();

        for (String s : arkadasListesi){
            sb.append(s+ " ");
        }

        textViewCikti.setText("Ad :"+ad+" Yas :"+ yas + " Boy :"+ boy + " Bekar " +bekar +" Arkadaslar " +sb.toString());
        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.remove("ad");
                e.commit();

                ad = sharedPreferences.getString("ad","isim yok");

                textViewCikti.setText("Ad :"+ad+" Yas :"+ yas + " Boy :"+ boy + " Bekar " +bekar +" Arkadaslar " +sb.toString());


            }
        });

        buttonGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.putInt("yas",28);
                e.commit();

                yas = sharedPreferences.getInt("yas",0);

                textViewCikti.setText("Ad :"+ad+" Yas :"+ yas + " Boy :"+ boy + " Bekar " +bekar +" Arkadaslar " +sb.toString());
            }
        });
    }
}
