package com.example.suelliton.trocamensagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculaActivity extends AppCompatActivity {
    public static final int resultOne = 1;
    public static final int resultTwo = 2;
    public static final int resultThree = 3;
    public static final int resultFour = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula);

        Intent intent = getIntent();
        Bundle pacoteRecebido = intent.getExtras();

        final int firstNumber = pacoteRecebido.getInt("firstNumber");
        final int secondNumber = pacoteRecebido.getInt("secondNumber");

        TextView TfirstNumber = (TextView) findViewById(R.id.TfirstNumber);
        TextView TsecondNumber = (TextView) findViewById(R.id.TsecondNumber);

        String message1 = TfirstNumber.getText().toString();
        String message2 = TsecondNumber.getText().toString();
        TfirstNumber.setText(message1 + firstNumber);
        TsecondNumber.setText(message2 + secondNumber);


        Button Bsomar = (Button) findViewById(R.id.Bsomar);
        Button Bsubtrair = (Button) findViewById(R.id.Bsubtrair);
        Button Bdividir = (Button) findViewById(R.id.Bdividir);
        Button Bmultiplicar = (Button) findViewById(R.id.Bmultiplicar);

        Bsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado = firstNumber + secondNumber;
                Bundle data = new Bundle();
                data.putInt("resultado", resultado);
                Intent intent = new Intent();
                intent.putExtras(data);
                setResult(resultOne, intent);
                finish();
            }
        });
        Bsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultado = firstNumber - secondNumber;
                Bundle data = new Bundle();
                data.putInt("resultado", resultado);
                Intent intent = new Intent();
                intent.putExtras(data);
                setResult(resultTwo, intent);
                finish();
            }
        });
    }
}
