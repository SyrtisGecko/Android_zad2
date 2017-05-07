package com.example.przemek.hsport.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminarzActivity extends AppCompatActivity {
    FileInputStream in;
    FileOutputStream os;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminarz);

        try {
            in = openFileInput("Baza_terminow");
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                sb.append(line);
                readFile(line);
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String line) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLay);
        TextView term = new TextView(this);
        term.setText(line);
        layout.addView(term);

    }

    public void dodajTermin(View view) {
        Intent intent = new Intent(this, DodajTerminActivity.class);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
//                System.out.println("Getting back after selecting bet.");
                String termin = data.getStringExtra("bet");
//                thisBet = bet;

//                ImageView yourBetImage = (ImageView) findViewById(R.id.yourBet);
//                int resID = getResources().getIdentifier(bet, "drawable", getPackageName());
//                System.out.println(bet + ", drawable, " + getPackageName());
//                yourBetImage.setImageResource(resID);

                saveToFile(termin);
            }
        }
    }

    private void saveToFile(String termin) {
        try {
            os = openFileOutput("Baza_terminow", Context.MODE_PRIVATE);

            os.write(termin.getBytes());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
