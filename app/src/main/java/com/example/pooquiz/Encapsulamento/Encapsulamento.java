package com.example.pooquiz.Encapsulamento;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.pooquiz.Pilares;
import com.example.pooquiz.R;


public class Encapsulamento extends AppCompatActivity {

     private Button vol;
     private Button vai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encapsulamento);

     vol = findViewById(R.id.vol);
     vai = findViewById(R.id.vai);

     vol.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(), Pilares.class);
             startActivity(intent);
         }
     });

     vai.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(), QuestoesEncapsulamento.class);
             startActivity(intent);
         }
     });

    }
}
