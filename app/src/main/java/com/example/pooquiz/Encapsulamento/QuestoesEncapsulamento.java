package com.example.pooquiz.Encapsulamento;

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


public class QuestoesEncapsulamento extends AppCompatActivity {


    private TextView perguntasEncap;
    private RadioGroup respostaGrupoEncap;
    private RadioButton respostaE1;
    private RadioButton respostaE2;
    private RadioButton respostaE3;
    private RadioButton respostaE4;
    private Button responderEncap;
    int respostaCerta = R.id.respostaE2;
    int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes_encapsulamento);

        perguntasEncap = findViewById(R.id.perguntasEncap);
        respostaGrupoEncap = findViewById(R.id.respostaGrupoEncap);
        respostaE1 = findViewById(R.id.respostaE1);
        respostaE2 = findViewById(R.id.respostaE2);
        respostaE3 = findViewById(R.id.respostaE3);
        respostaE4 = findViewById(R.id.respostaE4);
        responderEncap = findViewById(R.id.responderEncap);
        ListaEncap();

        responderEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioEncap = findViewById(respostaGrupoEncap.getCheckedRadioButtonId());
                Intent intent = new Intent(getApplicationContext(), AbastracaoResposta.class);
                if (respostaGrupoEncap.getCheckedRadioButtonId() == respostaCerta) {
                    intent.putExtra("acertou", true);
                    pontos++;
                } else intent.putExtra("acertou", false);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                radioEncap.setChecked(false);
            }
        });

        }

    List<Questoes> questoesEncap = new ArrayList<Questoes>(){
        {
            add(new Questoes(" Se o comportamente de uma pessoa é visível a todos, ele é um comportamento ... ?", R.id.respostaE3, "Oculto", "Privado", "Publico", "Fechado"));
            add(new Questoes(" É possível interferir em um comportamento privado, que não esteja sendo visto ?", R.id.respostaE2, "Sim", "Não", "Talvez", "Depende"));
            add(new Questoes(" É possível intervir em um comportamento público ?", R.id.respostaE3, "Não", "Talvez", "Sim", "Depende"));
            add(new Questoes(" É possível ver um comportamento privado ? ", R.id.respostaE1, "Não", "Talvez", "Depende", "Sim"));
            add(new Questoes(" Um comportamento oculto feito por uma pessoa pode ser copiado por outra pessoa?", R.id.respostaE2, "Sim", "Não", "Talvez", "Depende"));
            add(new Questoes(" É possível cópiar um comportamnete feito em público?", R.id.respostaE4, "Talvez", "Depende", "Não", "Sim"));
            add(new Questoes(" Um comportamento feito em um quarto fechado é ...?", R.id.respostaE3, "Publico", "Aberto", "Privado", "Claro"));
            add(new Questoes(" Um comportamento visto só porque o está realizando é ...?", R.id.respostaE2, "Publico", "Privado", "Aberto", "Escuro"));

        }
    };

    private void ListaEncap(){

        if (questoesEncap.size() > 0) {
            Questoes q = questoesEncap.remove(0);
            perguntasEncap.setText(q.getPergunta());
            List<String> respostasEncap = q.getRespostas();
            respostaE1.setText(respostasEncap.get(0));
            respostaE2.setText(respostasEncap.get(1));
            respostaE3.setText(respostasEncap.get(2));
            respostaE4.setText(respostasEncap.get(3));
            respostaCerta = q.getRespostaCerta();
            respostaGrupoEncap.setSelected(false);
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
        ListaEncap();

    }

         }

