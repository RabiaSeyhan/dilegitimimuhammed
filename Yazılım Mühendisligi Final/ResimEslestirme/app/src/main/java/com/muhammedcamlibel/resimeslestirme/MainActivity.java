package com.muhammedcamlibel.resimeslestirme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.muhammedcamlibel.resimeslestirme.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    String deger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        deger="";
    }

    public void kaydet(View view){
        deger = editText.getText().toString();

        if (deger.equals("Apple") || deger.equals("apple")){

            textView.setText("Doğru");

            try {

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else{
            textView.setText("Yanlış");
        }

    }
}
