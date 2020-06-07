package com.muhammedcamlibel.resimeslestirme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muhammedcamlibel.resimeslestirme.R;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    String deger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView2);
        deger="";
    }


    public void kaydet(View view){

        deger = editText.getText().toString();

        if (deger.equals("Banana") || deger.equals("banana")){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            textView.setText("Doğru");

            Toast toast = Toast.makeText(getApplicationContext(), "TEBRİKLER", Toast.LENGTH_LONG);

            toast.show();

        }
        else{
            textView.setText("Yanlış");
        }
    }

}
