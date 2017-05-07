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
//        resultIntent.putExtra("surname", surnameToSendBack);
//        resultIntent.putExtra("description", descriptionToSendBack);
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
//                System.out.println("Getting back after selecting bet.");
                date = data.getStringExtra("date1");
                System.out.println("Debug in DodajTerminActivity: " + date);
//                terminy.add(termin);
//                thisBet = bet;

//                ImageView yourBetImage = (ImageView) findViewById(R.id.yourBet);
//                int resID = getResources().getIdentifier(bet, "drawable", getPackageName());
//                System.out.println(bet + ", drawable, " + getPackageName());
//                yourBetImage.setImageResource(resID);

//                saveToFile();
//                readTerminyRecords();
                EditText dateText = (EditText) findViewById(R.id.editText);
                dateText.setText(date);
            }
        }
    }
}
