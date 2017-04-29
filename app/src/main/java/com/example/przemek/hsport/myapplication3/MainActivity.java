package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] lista = {"Position 1", "Position 2", "Position 3"};
    String[] p = {"1", " 2", " 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner options = (Spinner) findViewById(R.id.spinner1);
        if(options != null) {
            options.setOnItemSelectedListener(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            options.setAdapter(adapter);
        }
    }

    public void launchLista1(View view) {
        Intent intent = new Intent(this, Lista1.class);
        startActivity(intent);
    }

    public void launchLista2(View view) {
        Intent intent = new Intent(this, Lista2.class);
        startActivity(intent);
    }

    public void launchGrid1(View view) {
        Intent intent = new Intent(this, Grid1.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "You have chosen: " + p[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
