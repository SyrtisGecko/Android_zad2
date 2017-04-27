package com.example.przemek.hsport.myapplication3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.AdapterView.*;

public class Lista1 extends Activity implements OnItemClickListener{

    String[] listViewLista1content = {"Text 1", "Text 2", "Text 3", "Text 4", "Text 5", "Text 6",
                                       "Text 7", "Text 8", "Text 9", "Text 10", "Text 11", "Text 12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listViewLista1content);

        ListView list = (ListView) findViewById(R.id.listViewLista1);
        list.setOnItemClickListener(this);
        list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        System.out.println("Kliknieto " + position + " " + id);
        Toast.makeText(getApplicationContext(), "You have clicked option: " + position, Toast.LENGTH_SHORT).show();
    }
}
