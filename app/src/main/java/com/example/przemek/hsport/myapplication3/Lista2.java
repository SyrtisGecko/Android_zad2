package com.example.przemek.hsport.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] listViewLista2content = {"Text for multi 1", "Text for multi 2", "Text for multi 3",
                                    "Text for multi 4", "Text for multi 5", "Text for multi 6",
                                    "Text for multi 7", "Text for multi 8", "Text for multi 9",
                                    "Text for multi 10", "Text for multi 11", "Text for multi 12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listViewLista2content);

        ListView list = (ListView) findViewById(R.id.listViewLista2);
        list.setOnItemClickListener(this);
        list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView list = (ListView) findViewById(R.id.listViewLista2);

        String text = "";
        SparseBooleanArray selected = list.getCheckedItemPositions();
        for(int i = 0; i < selected.size(); i++) {
            if(selected.valueAt(i)) {
                int index = selected.keyAt(i);
                text += " " + String.valueOf(index + 1);
            }
        }
        Toast.makeText(getApplicationContext(), "You have selected:" + text, Toast.LENGTH_SHORT).show();
    }
}
