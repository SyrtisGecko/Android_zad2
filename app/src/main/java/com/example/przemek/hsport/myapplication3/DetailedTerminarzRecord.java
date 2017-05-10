package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailedTerminarzRecord extends AppCompatActivity {
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_terminarz_record);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        position = (int)bundle.getLong("id");
        String record = TerminarzActivity.terminy.get(position);

        TextView textDate = (TextView) findViewById(R.id.dispDate);
        textDate.setText(record.substring(0, 10));

        TextView textDesc = (TextView) findViewById(R.id.dispDesc);
        textDesc.setText(record.substring(11));
    }

    public void onDeleteClick(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("delConf", position);
        setResult(RESULT_OK, resultIntent);
        finish();
        onBackPressed();
    }
}
