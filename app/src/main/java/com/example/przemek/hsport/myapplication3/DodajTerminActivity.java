package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DodajTerminActivity extends AppCompatActivity {
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_termin);
    }

    public void onSavePressed(View view) {
        EditText text = (EditText) findViewById(R.id.editText3);
        String betName = date + " " + text.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("bet", betName);
        setResult(RESULT_OK, resultIntent);
        finish();
        onBackPressed();
    }

    public void setDate(View view) {
        Intent intent = new Intent(this, SetDateActivity.class);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                date = data.getStringExtra("date1");
                System.out.println("Debug in DodajTerminActivity: " + date);

                EditText dateText = (EditText) findViewById(R.id.editText);
                dateText.setText(date);
            }
        }
    }
}
