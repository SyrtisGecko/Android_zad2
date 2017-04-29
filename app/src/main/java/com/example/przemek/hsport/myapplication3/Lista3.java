package com.example.przemek.hsport.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Lista3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista3);

        ListView lista3 = (ListView) findViewById(R.id.listViewLista3);
        lista3.setAdapter(new MyAnotherAdapter(this));
    }

}
