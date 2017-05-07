package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DodajTerminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_termin);
    }

    public void onSavePressed(View view) {
        EditText text = (EditText) findViewById(R.id.editText3);
        String betName = text.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("bet", betName);
//        resultIntent.putExtra("surname", surnameToSendBack);
//        resultIntent.putExtra("description", descriptionToSendBack);
        setResult(RESULT_OK, resultIntent);
        finish();
        onBackPressed();
    }
}
