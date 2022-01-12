package com.example.pooquiz.Polimorfismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pooquiz.Pilares;
import com.example.pooquiz.R;

public class Polimorfismo extends AppCompatActivity {

    private Button voltpoli;
    private Button vaipoli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polimorfismo);

        voltpoli = findViewById(R.id.voltpoli);
        vaipoli = findViewById(R.id.vaipoli);

        voltpoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Pilares.class);
                startActivity(intent);

            }
        });

        vaipoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuestoesPoli.class);
                startActivity(intent);
            }
        });

    }
}
