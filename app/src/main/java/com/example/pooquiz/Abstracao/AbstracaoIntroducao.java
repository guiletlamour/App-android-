package com.example.pooquiz.Abstracao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pooquiz.Pilares;
import com.example.pooquiz.R;

public class AbstracaoIntroducao extends AppCompatActivity {

    private Button volt;
    private Button quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstracao_introducao);

        volt = findViewById(R.id.volt);
        quest = findViewById(R.id.quest);

        volt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent (getApplicationContext(), Pilares.class);
                startActivity(intent1);
            }
        });

      quest.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent2  = new Intent (getApplicationContext(), QuestAbstracao.class);
              startActivity(intent2);

          }
      });
    }
}
