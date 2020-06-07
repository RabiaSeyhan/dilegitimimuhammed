package com.muhammedcamlibel.kelimekaydetme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView kelime;
    TextView anlami;
    Button button;
    String gelenKelime;
    String gelenAnlami;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kelime = findViewById(R.id.kelime);
        anlami = findViewById(R.id.anlami);
        button = findViewById(R.id.button);

        database= this.openOrCreateDatabase("Veritabani",MODE_PRIVATE,null);

        Intent intent = getIntent();
        String info = intent.getStringExtra("info");

        if (info.equals("new")){
            kelime.setText("");
            anlami.setText("");
            button.setVisibility(View.VISIBLE);
        }else{

            int idkelime = intent.getIntExtra("kelimeId",1);
            button.setVisibility(View.INVISIBLE);
            try{
                Cursor cursor =database.rawQuery("SELECT * FROM veritabani WHERE id = ?",new String[]{String.valueOf(idkelime)});
                int kelimeIx = cursor.getColumnIndex("kelime");
                int anlamiIx = cursor.getColumnIndex("anlami");

                while (cursor.moveToNext()){
                    kelime.setText(cursor.getString(kelimeIx));
                    anlami.setText(cursor.getString(anlamiIx));
                }

                cursor.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }






    }

    public void kaydet(View view){

        try{
            gelenKelime = kelime.getText().toString();
            gelenAnlami = anlami.getText().toString();
            database = this.openOrCreateDatabase("Veritabani",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS veritabani (id INTEGER PRIMARY KEY, kelime VARCHAR, anlami VARCHAR)");
            String sqlString ="INSERT INTO veritabani(kelime , anlami) VALUES (? , ?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlString);
            sqLiteStatement.bindString(1,gelenKelime);
            sqLiteStatement.bindString(2,gelenAnlami);
            sqLiteStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }


        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);


    }

}
