package com.example.pooquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.pooquiz.Abstracao.AbstracaoIntroducao;
import com.example.pooquiz.Encapsulamento.Encapsulamento;
import com.example.pooquiz.Heranca.heranca;
import com.example.pooquiz.Polimorfismo.Polimorfismo;

public class Pilares extends AppCompatActivity {

    private Button abstracao;
    private Button encap;
    private Button heran1;
    private Button polimorfismo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilares);


        abstracao = findViewById(R.id.abstracao);
        encap = findViewById(R.id.encap);
        heran1 = findViewById(R.id.heran1);
        polimorfismo = findViewById(R.id.polimorfismo);



        abstracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbstracaoIntroducao.class);
                startActivity(intent);
            }
        });


        encap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Encapsulamento.class);
                startActivity(intent);

            }
        });

        heran1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), heranca.class);
                startActivity(intent);

            }
        });

        polimorfismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Polimorfismo.class);
                startActivity(intent);
            }
        });

    }
}
