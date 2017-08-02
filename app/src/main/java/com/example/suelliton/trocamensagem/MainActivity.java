package com.example.suelliton.trocamensagem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.suelliton.trocamensagem.CalculaActivity.resultOne;
import static com.example.suelliton.trocamensagem.CalculaActivity.resultTwo;

public class MainActivity extends AppCompatActivity {

    public static final int requestOne = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context c = this;

        Button BverOperacoes = (Button) findViewById(R.id.BverOperacoes);

        BverOperacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.EfirstNumber);
                int EfirstNumber = Integer.parseInt(e.getText().toString());
                EditText e2 = (EditText) findViewById(R.id.EsecondNumber);
                int EsecondNumber = Integer.parseInt(e2.getText().toString());

                Bundle pacote = new Bundle();
                pacote.putInt("firstNumber", EfirstNumber);
                pacote.putInt("secondNumber", EsecondNumber);
                Intent intent = new Intent(c, CalculaActivity.class);
                intent.putExtras(pacote);
                startActivityForResult(intent, requestOne);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == requestOne) {
            Bundle dados = data.getExtras();
            int resultado = dados.getInt("resultado");
            TextView retorno = (TextView) findViewById(R.id.Tretorno);
            if (resultCode == resultOne) {
                retorno.setText("A adição foi:" + resultado);
            } else if (resultCode == resultTwo) {
                retorno.setText("A subtração foi:" + resultado);
            }
        }

    }

}
