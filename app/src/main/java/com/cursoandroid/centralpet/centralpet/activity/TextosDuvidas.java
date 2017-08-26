package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

public class TextosDuvidas extends AppCompatActivity {

    private Toolbar toolbarTextoDuv;
    private TextView texto;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textos_duvidas);

        //toolbar
        toolbarTextoDuv = (Toolbar) findViewById(R.id.toolbar_textoDuv);
        toolbarTextoDuv.setTitle("Vacinação");
        setSupportActionBar(toolbarTextoDuv);

        texto = (TextView) findViewById(R.id.setText);
        titulo = (TextView) findViewById(R.id.titulo);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String opcaoescolhida = extra.getString("opcao");
            if(opcaoescolhida.equals("op0")){
                titulo.setText("Vermífugo");
                texto.setText("Vermifugo é isso");
            }else if(opcaoescolhida.equals("op1")){
                titulo.setText("Anti-pulgas");
                texto.setText("antipulgas é aquilo");
            }else if(opcaoescolhida.equals("op2")){
                titulo.setText("V8 ou V10");
                texto.setText("");
            }else if(opcaoescolhida.equals("op3")){
                titulo.setText("Tosse");
                texto.setText("");
            }else if(opcaoescolhida.equals("op4")){
                titulo.setText("");
                texto.setText("rabica");
            }else if(opcaoescolhida.equals("op5")){
                titulo.setText("");
                texto.setText("giardiase");
            }else if(opcaoescolhida.equals("op6")){
                titulo.setText("");
                texto.setText("gripe");
            }else if(opcaoescolhida.equals("op7")){
                titulo.setText("");
                texto.setText("verm");
            }else if(opcaoescolhida.equals("op8")){
                titulo.setText("");
                texto.setText("anti");
            }else if(opcaoescolhida.equals("op9")){
                titulo.setText("");
                texto.setText("v4");
            }else if(opcaoescolhida.equals("op10")){
                titulo.setText("");
                texto.setText("rabica");
            }else if(opcaoescolhida.equals("op11")){
                titulo.setText("");
                texto.setText("quadrupla");
            }

        }


    }
}
