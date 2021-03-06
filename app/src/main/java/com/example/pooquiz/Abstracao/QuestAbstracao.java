package com.example.pooquiz.Abstracao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pooquiz.AbastracaoResposta;
import com.example.pooquiz.Questoes;
import com.example.pooquiz.R;
import java.util.ArrayList;
import java.util.List;


public class QuestAbstracao extends AppCompatActivity {

    private RadioGroup rgRespostas;
    private Button responderAbstra;
    private TextView pergunta;
    private RadioButton resposta1;
    private RadioButton resposta2;
    private RadioButton resposta3;
    private RadioButton resposta4;
    int respostaCerta = R.id.resposta2;
    int pontos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_abstracao);


        responderAbstra = findViewById(R.id.responderEncap);
        rgRespostas = findViewById(R.id.rgRespostas);
        pergunta = findViewById(R.id.pergunta);
        resposta1 = findViewById(R.id.resposta1);
        resposta2 = findViewById(R.id.resposta2);
        resposta3 = findViewById(R.id.resposta3);
        resposta4 = findViewById(R.id.resposta4);
        Lista();


        responderAbstra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radio = findViewById(rgRespostas.getCheckedRadioButtonId());
                Intent intent = new Intent(getApplicationContext(), AbastracaoResposta.class);
                if (rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
                    intent.putExtra("acertou", true);
                    pontos++;
                } else intent.putExtra("acertou", false);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                radio.setChecked(false);
            }
        });

    }

    List<Questoes> questoes = new ArrayList<Questoes>(){
        {
            add(new Questoes("Para um cadastro de cobran??as, o que ?? importante registrar dos devedores ?", R.id.resposta2, "Idade", "Valor da divida", "Peso", "Altura"));
            add(new Questoes("Caso precise identificar um carro, qual caracter??stica seria mais precisa ?", R.id.resposta3, "Cor", "Marca", "N??mero da placa", "Quantos pneus possui"));
            add(new Questoes("O que seria um atributo de pessoa", R.id.resposta4, "Caminhar", "Respirar", "Comer", "Nome"));
            add(new Questoes("O que pode ser uma a????o de um cachorro ?", R.id.resposta2, "Ra??a", "Latir", "Quantidade de patas", "Cor"));
            add(new Questoes("O que poderia ser um estado de uma bola ?", R.id.resposta3, "Volei", "Futebol", "Cheia", "Colorida"));
            add(new Questoes("O que poderia ser a a????o de uma pessoa ?", R.id.resposta2, "Cor dos cabelos", "Correr", "Idade", "Nome"));
            add(new Questoes("O que pode ser um estado de uma pessoa ?", R.id.resposta1, "Dormindo", "Profiss??o", "Tamanho dos p??s", "Altura"));
            add(new Questoes("Qual caracter??stica de uma pessoa ?? mais importante para um cadastro m??dico ?", R.id.resposta1, "Nome", "Cor dos cabelos", "Roupas", "Quanto ganha"));

        }
    };

        private void Lista() {

          if (questoes.size() > 0) {
            Questoes q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            resposta1.setText(resposta.get(0));
            resposta2.setText(resposta.get(1));
            resposta3.setText(resposta.get(2));
            resposta4.setText(resposta.get(3));
            respostaCerta = q.getRespostaCerta();
            rgRespostas.setSelected(false);
        }
        else{
            Intent intent = new Intent(this, AbastracaoResposta.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }


    }

    protected void onRestart() {
        super.onRestart();
        Lista();

    }

}







