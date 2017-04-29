package com.example.przemek.hsport.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Lista3 extends AppCompatActivity {

    String[] ltxt1 = {"Position One", "Position Two", "Position Three", "Position Four", "Position Five",
            "Position Six", "Position Seven", "Position Eight", "Position Nine", "Position Ten"};
    String[] ltxt2 = {"Text 1", "Text 2", "Text 3", "Text 4", "Text 5", "Text 6", "Text 7", "Text 8", "Text 9", "Text 0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista3);
    }
}
