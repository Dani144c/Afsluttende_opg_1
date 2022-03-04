package com.example.afsluttende_opg_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GetColor extends AppCompatActivity {

    private Spinner spnRed, spnGreen, spnBlue;
    private TextView tvColor, tvText;
    private Button btnSendColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_color);

        spnRed = findViewById(R.id.spnRed);
        spnGreen = findViewById(R.id.spnGreen);
        spnBlue = findViewById(R.id.spnBlue);
        tvColor = findViewById(R.id.tvColor);
        btnSendColor = findViewById(R.id.btnSendColor);
        tvText = findViewById(R.id.tvText);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("00");
        arrayList.add("10");
        arrayList.add("20");
        arrayList.add("30");
        arrayList.add("40");
        arrayList.add("50");
        arrayList.add("60");
        arrayList.add("70");
        arrayList.add("80");
        arrayList.add("90");
        arrayList.add("A0");
        arrayList.add("B0");
        arrayList.add("C0");
        arrayList.add("D0");
        arrayList.add("E0");
        arrayList.add("F0");
        arrayList.add("FF");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(GetColor.this, android.R.layout.simple_spinner_item, arrayList);

        spnRed.setAdapter(adapter);
        spnGreen.setAdapter(adapter);
        spnBlue.setAdapter(adapter);

        spnRed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = "#" + spnRed.getSelectedItem().toString() + spnGreen.getSelectedItem().toString() + spnBlue.getSelectedItem().toString();
                tvColor.setBackgroundColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spnGreen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = "#" + spnRed.getSelectedItem().toString() + spnGreen.getSelectedItem().toString() + spnBlue.getSelectedItem().toString();
                tvColor.setBackgroundColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spnBlue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = "#" + spnRed.getSelectedItem().toString() + spnGreen.getSelectedItem().toString() + spnBlue.getSelectedItem().toString();
                tvColor.setBackgroundColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btnSendColor.setOnClickListener(new View.OnClickListener() {
            private String color;
            @Override
            public void onClick(View view) {
                color = "#" + spnRed.getSelectedItem().toString() + spnGreen.getSelectedItem().toString() + spnBlue.getSelectedItem().toString();
                Intent intentColor = getIntent();
                intentColor.putExtra("color", color);
                setResult(Activity.RESULT_OK, intentColor);
                finish();
            }
        });
    }
}