package com.muhammedcamlibel.kelimekaydetme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> kelimeArray;
    ArrayList<Integer> idArray;
    ListView listView;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kelimeArray = new ArrayList<String>();
        idArray = new ArrayList<Integer>();
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,kelimeArray);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("kelimeId",idArray.get(position));
                intent.putExtra("info","old");


                startActivity(intent);

            }
        });

        getData();
    }


    public void getData(){

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Veritabani",MODE_PRIVATE,null);
            Cursor cursor = database.rawQuery("SELECT * FROM veritabani",null);
            int kelimeIx = cursor.getColumnIndex("kelime");
            int idIx = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                kelimeArray.add(cursor.getString(kelimeIx));
                idArray.add(cursor.getInt(idIx));
            }

            arrayAdapter.notifyDataSetChanged();

            cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
          hangi menüyü ekleyecegimizi seçiyoruz
         */

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.kelime_kaydet,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // hangi item seçildiginde napılacagı

        if (item.getItemId()== R.id.kaydet){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("info","new");
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
