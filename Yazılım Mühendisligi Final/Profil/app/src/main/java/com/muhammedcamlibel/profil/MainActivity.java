package com.muhammedcamlibel.profil;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    TextView AdText,SoyadText,ProfilText,K_adiText,MailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdText = findViewById(R.id.textView4);
        SoyadText = findViewById(R.id.textView5);
        ProfilText = findViewById(R.id.textView);
        K_adiText = findViewById(R.id.textView2);
        MailText = findViewById(R.id.textView3);

        try{

            database = this.openOrCreateDatabase("Profil",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS profil(id INTEGER PRIMARY KEY,ad VARCHAR,soyad VARCHAR,kullaniciAdi VARCHAR,mail VARCHAR)");
            database.execSQL("INSERT INTO profil (ad,soyad,kullaniciAdi,mail) VALUES ('Muhammed','Çamlıbel','Camlibell','Camlibel1998@gmail.com')");



        }catch (Exception e){
            e.printStackTrace();
        }

        yazdir();
    }

 public void yazdir(){
        try{
            Cursor cursor = database.rawQuery("SELECT * FROM profil WHERE id =1",null);
            int adIx = cursor.getColumnIndex("ad");
            int soyadIx = cursor.getColumnIndex("soyad");
            int kullaniciIx = cursor.getColumnIndex("kullaniciAdi");
            int mailIx = cursor.getColumnIndex("mail");

            while(cursor.moveToNext()){
                AdText.setText("AD : "+cursor.getString(adIx));
                SoyadText.setText("SOYAD : "+cursor.getString(soyadIx));
                K_adiText.setText("KULLANICI ADI : "+cursor.getString(kullaniciIx));
                MailText.setText("MAİL :"+cursor.getString(mailIx));
            }

            cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }
 }




}


