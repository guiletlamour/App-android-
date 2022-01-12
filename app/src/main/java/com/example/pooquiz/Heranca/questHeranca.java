package com.example.pooquiz.Heranca;

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

public class questHeranca extends AppCompatActivity {

    private Button respostaheran;
    private RadioGroup grupoheran;
    private RadioButton heran1;
    private RadioButton heran2;
    private RadioButton heran3;
    private RadioButton heran4;
    private TextView perguntaheran;
    int respostaCerta = R.id.heran2;
    int pontos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_heranca);


        respostaheran = findViewById(R.id.respostaheran);
        grupoheran = findViewById(R.id.grupoheran);
        heran1 = findViewById(R.id.heran1);
        heran2 = findViewById(R.id.heran2);
        heran3 = findViewById(R.id.heran3);
        heran4 = findViewById(R.id.heran4);
        perguntaheran = findViewById(R.id.perguntaheran);
        Listaheran();

        respostaheran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioHeran = findViewById(grupoheran.getCheckedRadioButtonId());
                Intent intent = new Intent(getApplicationContext(), AbastracaoResposta.class);
                if (grupoheran.getCheckedRadioButtonId() == respostaCerta) {
                    intent.putExtra("acertou", true);
                    pontos++;
                } else intent.putExtra("acertou", false);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                radioHeran.setChecked(false);

            }
        });
    }

    List<Questoes> questoesHeran = new ArrayList<Questoes>(){
        {
            add(new Questoes("É possível um pai herdar características físicas de um filho ?", R.id.heran1, "Não", "Sim", "Talvez", "Depende"));
            add(new Questoes("É possível um filhos herdar características fisícas do pai ?", R.id.heran2, "Não", "Sim", "Talvez", "Depende"));
            add(new Questoes("É possível um pai herdar o comportamento de um filho ?", R.id.heran3, "O modo de falar", "Sim", "Não", "A forma de andar"));
            add(new Questoes("Um filho pode herdar do pai quais atributos?", R.id.heran4, "Mesma roupa", "Profissão", "Dinheiro", "A cor dos olhos"));
            add(new Questoes("O que seria um atributo herdado?", R.id.heran2, "Dinheiro", "Cor dos cabelos", "Idade", "Profissão"));
            add(new Questoes("O que seria um comportamento herdado?", R.id.heran3, "Cor dos olhos", "Idade", "A forma de falar", "Profissão"));
            add(new Questoes(" Uma criança que herda atributos do pai, necessáriamente é identica a ele ?", R.id.heran2, "Sim", "Não", "Talvez", "Sim"));
            add(new Questoes("Normalmente o filho possui comportamentos e atributos herdados de quem ?", R.id.heran1, "Dos pais", "Profissão", "Dinheiro", "Herança"));
        }
    };

    private void Listaheran(){

        if (questoesHeran.size() > 0) {
            Questoes q = questoesHeran.remove(0);
            perguntaheran.setText(q.getPergunta());
            List<String> respostasheran = q.getRespostas();
            heran1.setText(respostasheran.get(0));
            heran2.setText(respostasheran.get(1));
            heran3.setText(respostasheran.get(2));
            heran4.setText(respostasheran.get(3));
            respostaCerta = q.getRespostaCerta();
            grupoheran.setSelected(false);
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
        Listaheran();

    }

}
