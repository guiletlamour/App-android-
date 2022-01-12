package com.example.pooquiz.Heranca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.pooquiz.Pilares;
import com.example.pooquiz.R;

public class heranca extends AppCompatActivity {

    private Button vor;
    private Button ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heranca);

        vor = findViewById(R.id.vor);
        ir = findViewById(R.id.ir);

        vor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pilares.class);
                startActivity(intent);
            }
        });

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),questHeranca.class);
                startActivity(intent);
            }
        });

    }
}
