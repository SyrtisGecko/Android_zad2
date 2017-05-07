package com.example.przemek.hsport.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class SetDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date);
    }

    public void onDateSelected(View view) {
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        String d = date.getYear() + "-" + formatDateValue(date.getMonth()) + "-" + formatDateValue(date.getDayOfMonth());
        Intent resultIntent = new Intent();
        resultIntent.putExtra("date1", d);
        setResult(RESULT_OK, resultIntent);
        finish();
        onBackPressed();
    }

    private String formatDateValue(int value) {
        if(value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }
}
