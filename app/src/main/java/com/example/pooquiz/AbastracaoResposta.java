package com.example.pooquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pooquiz.Abstracao.QuestAbstracao;


public class AbastracaoResposta extends AppCompatActivity {

    private ImageView imagemResposta;
    private TextView textoResposta;
    private Button responderNovamente;
    private Button novoPilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastracao_resposta);

        imagemResposta = findViewById(R.id.imagemResposta);
        textoResposta = findViewById(R.id.textoResposta);
        responderNovamente = findViewById(R.id.responderNovamente);
        novoPilar = findViewById(R.id.novoPilar);


        Intent intent = getIntent();
        int pontos = intent.getIntExtra("pontos", 0);

        if (intent.hasExtra("acertou")) {
            responderNovamente.setVisibility(View.INVISIBLE);
            novoPilar.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imagemResposta.setImageResource(R.drawable.verified);
                textoResposta.setText("Acertou! Pontos: " + pontos);
            } else {
                imagemResposta.setImageResource(R.drawable.errou);
                textoResposta.setText("Errou! Pontos: " + pontos);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        } else {
            responderNovamente.setVisibility(View.VISIBLE);
            novoPilar.setVisibility(View.VISIBLE);
            textoResposta.setText("Resultado " + pontos + " pontos!");

            if (pontos >= 3)
                imagemResposta.setImageResource(R.drawable.smile);
            else
                imagemResposta.setImageResource(R.drawable.sad);
        }

          responderNovamente.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent  = new Intent (getApplicationContext(), QuestAbstracao.class);
                  startActivity(intent);
                  finish();
              }
          });

         novoPilar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), Pilares.class);
                 startActivity(intent);
                 finish();
             }
         });


        }

}











