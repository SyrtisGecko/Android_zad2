package com.example.przemek.hsport.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TerminarzActivity extends AppCompatActivity {
    ArrayList<String> terminy = new ArrayList<String>();
    FileInputStream in;
    FileOutputStream os;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminarz);

        readingFile();
    }

    private void readingFile() {
        try {
            in = openFileInput("Baza_terminow");
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                sb.append(line);
                terminy.add(line);
                System.out.println("Adding line to array from file: " + line);
//                readTerminyRecords(line);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        readTerminyRecords();
    }

    private void readTerminyRecords() {
        ListView lista = (ListView) findViewById(R.id.listViewTerminarz);
        lista.setAdapter(new MyTerminarzAdapter(this, terminy));

//        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLay);
//        TextView term = new TextView(this);
//        term.setText("");
//        for(int i = 0; i < terminy.size(); i++) {
//            term.append(terminy.get(i));
//            term.append("\n");
//        }
//        layout.addView(term);
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
                System.out.println("Debug in TerminarzActivity: " + termin);
                terminy.add(termin);
//                thisBet = bet;

//                ImageView yourBetImage = (ImageView) findViewById(R.id.yourBet);
//                int resID = getResources().getIdentifier(bet, "drawable", getPackageName());
//                System.out.println(bet + ", drawable, " + getPackageName());
//                yourBetImage.setImageResource(resID);

                saveToFile();
                readTerminyRecords();
            }
        }
    }

    private void saveToFile() {
        try {
            os = openFileOutput("Baza_terminow", Context.MODE_PRIVATE);

            if(terminy.size() > 0) {
                for (int i = 0; i < terminy.size(); i++) {
                    os.write(terminy.get(i).getBytes());
                    String endl = "\n";
                    os.write(endl.getBytes());
                }
            } else {
                String nullRecord = "";
                os.write(nullRecord.getBytes());
                System.out.println("Saving empty file");
            }

            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearAll(View view) {
        terminy = new ArrayList<String>();
        saveToFile();
        readingFile();
    }
}
