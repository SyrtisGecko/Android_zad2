package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
