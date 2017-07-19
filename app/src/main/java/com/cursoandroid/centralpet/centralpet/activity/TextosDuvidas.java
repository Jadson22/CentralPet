package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

public class TextosDuvidas extends AppCompatActivity {

    public TextView texto;
    public int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textos_duvidas);

        texto = (TextView) findViewById(R.id.setText);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String opcaoescolhida = extra.getString("opcao");
            if(opcaoescolhida.equals("op0")){
                texto.setText("Vermifugo é isso");
            }else if(opcaoescolhida.equals("op1")){
                texto.setText("antipulgas é aquilo");
            }else if(opcaoescolhida.equals("op2")){
                texto.setText("v8 é o caralho");
            }else if(opcaoescolhida.equals("op3")){
                texto.setText("tosse pq deu certo");
            }

        }


    }
}
