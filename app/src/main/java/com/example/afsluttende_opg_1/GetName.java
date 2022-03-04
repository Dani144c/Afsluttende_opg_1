package com.example.afsluttende_opg_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GetName extends AppCompatActivity {

    private RadioGroup rgChoose;
    private RadioButton rbMother, rbFather, rbCat, rbDog;
    private Button btnSend;
    private EditText etInsertText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        rgChoose = findViewById(R.id.rgChoose);
        rbMother = findViewById(R.id.rbMother);
        rbFather = findViewById(R.id.rbFather);
        rbCat = findViewById(R.id.rbCat);
        rbDog = findViewById(R.id.rbDog);

        btnSend = findViewById(R.id.btnSend);
        etInsertText = findViewById(R.id.etInsertText);

        btnSend.setOnClickListener(new View.OnClickListener() {
            private String name;

            @Override
            public void onClick(View view) {
                if(rbFather.isChecked()){
                    name = "Father: " + etInsertText.getText().toString();
                }
                if(rbMother.isChecked()){
                    name = "Mother: " + etInsertText.getText().toString();
                }
                if(rbCat.isChecked()){
                    name = "Cat: " + etInsertText.getText().toString();
                }
                if(rbDog.isChecked()){
                    name = "Dog: " + etInsertText.getText().toString();
                }
                Intent intent = getIntent();
                intent.putExtra("name", name);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}