package com.muhammedcamlibel.degerlendirme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.dereceText);
        sharedPreferences =this.getSharedPreferences("com.muhammedcamlibel.ornek3", Context.MODE_PRIVATE);
        int   deger=sharedPreferences.getInt("deger",0);

        if (deger==0){
            textView.setText("Dereceniz:");
        }else{
            textView.setText("Dereceniz:"+deger);
        }


    }

    public void yildiz1(View view){
        int i =1;
        sharedPreferences.edit().putInt("deger",i).apply();
        textView.setText("Dereceniz:"+i);

    }

    public void yildiz2(View view){
        int i =2;
        sharedPreferences.edit().putInt("deger",i).apply();
        textView.setText("Dereceniz:"+i);

    }

    public void yildiz3(View view){
        int i =3;
        sharedPreferences.edit().putInt("deger",i).apply();
        textView.setText("Dereceniz:"+i);

    }

    public void yildiz4(View view){
        int i =4;
        sharedPreferences.edit().putInt("deger",i).apply();
        textView.setText("Dereceniz:"+i);

    }

    public void yildiz5(View view){
        int i =5;
        sharedPreferences.edit().putInt("deger",i).apply();
        textView.setText("Dereceniz:"+i);

    }

}
