package com.example.afsluttende_opg_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnGetName, btnGetColor;
    private TextView txtShowName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetName = findViewById(R.id.btnGetName);
        btnGetColor = findViewById(R.id.btnGetColor);

        txtShowName = findViewById(R.id.txtShowName);


        ActivityResultLauncher<Intent> launcher;
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            String data = result.getData().getStringExtra("name");
                            txtShowName.setText(data);
                        }
                    }
                });
        ActivityResultLauncher<Intent> launcherColor;
        launcherColor = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            String dataColor = result.getData().getStringExtra("color");
                            txtShowName.setBackgroundColor(Color.parseColor(dataColor));
                        }
                    }
                });
        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetName.class);
                launcher.launch(intent);
            }
        });
        btnGetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentColor = new Intent(MainActivity.this, GetColor.class);
                launcherColor.launch(intentColor);
            }
        });
    }
}