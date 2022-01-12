package com.example.pooquiz.Polimorfismo;

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

public class QuestoesPoli extends AppCompatActivity {

    private Button responderpoli;
    private TextView perguntapoli;
    private RadioGroup radiopoli;
    private RadioButton questpoli1;
    private RadioButton questpoli2;
    private RadioButton questpoli3;
    private RadioButton questpoli4;
    int respostaCerta = R.id.questpoli2;
    int pontos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes_poli);

        responderpoli = findViewById(R.id.responderpoli);
        perguntapoli = findViewById(R.id.perguntapoli);
        radiopoli = findViewById(R.id.radiopoli);
        questpoli1 = findViewById(R.id.questpoli1);
        questpoli2 = findViewById(R.id.questpoli2);
        questpoli3 = findViewById(R.id.questpoli3);
        questpoli4 = findViewById(R.id.questpoli4);
        Listapoli();

        responderpoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioHeran = findViewById(radiopoli.getCheckedRadioButtonId());
                Intent intent = new Intent(getApplicationContext(), AbastracaoResposta.class);
                if (radiopoli.getCheckedRadioButtonId() == respostaCerta) {
                    intent.putExtra("acertou", true);
                    pontos++;
                } else intent.putExtra("acertou", false);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                radioHeran.setChecked(false);

            }
        });
    }
    List<Questoes> questoesPoli = new ArrayList<Questoes>(){
        {
            add(new Questoes("O que pode ser um comportamento de uma pessoa ?", R.id.questpoli4, "Nome", "Idade", "Telefone", "Correr"));
            add(new Questoes("Realizo o comportamento de Correr, o que pode ser um parâmetro desse comportamento ?", R.id.questpoli3, "Idade", "Nome", "Tempo", "Altura"));
            add(new Questoes("Em uma corrida cronometrei o tempo e a quantidade de kilometrôs, kilometrôs e tempo são parâmetros diferentes ?", R.id.questpoli4, "Não", "Talvez", "Depende", "Sim"));
            add(new Questoes("O que pode ser um parâmetro do comportamento falar ?", R.id.questpoli3, "Caminhar", "Respirar", "Altura da voz", "Nome"));
            add(new Questoes("Se eu acrescento a um comportamento um parâmetro esse comportamento ainda é o mesmo ?", R.id.questpoli2, "Sim", "Não", "Talvez", "Depende"));
            add(new Questoes("Acrescentar um parâmetro a um comportamento com o mesmo nome de outro é fazer polimorfismo ?", R.id.questpoli3, "Não", "Talvez", "Sim", "Depende"));
            add(new Questoes("Comportamentos com o mesmo nome e parâmetros iguais são diferentes ?", R.id.questpoli1, "Não", "Sim", "Talvez", "Depende"));
            add(new Questoes("Comportamentos com tipos de atributos diferêntes são iguais ?", R.id.questpoli4, "Sim", "Idênticos", "Gêmios", "Não"));
        }
    };

    private void Listapoli(){

        if (questoesPoli.size() > 0) {
            Questoes q = questoesPoli.remove(0);
            perguntapoli.setText(q.getPergunta());
            List<String> respostaspoli = q.getRespostas();
            questpoli1.setText(respostaspoli.get(0));
            questpoli2.setText(respostaspoli.get(1));
            questpoli3.setText(respostaspoli.get(2));
            questpoli4.setText(respostaspoli.get(3));
            respostaCerta = q.getRespostaCerta();
            radiopoli.setSelected(false);
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
        Listapoli();
    }
    }

