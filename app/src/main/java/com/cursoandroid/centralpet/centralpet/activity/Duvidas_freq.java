package com.cursoandroid.centralpet.centralpet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Switch;
import android.widget.Toast;

import com.cursoandroid.centralpet.centralpet.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Duvidas_freq extends AppCompatActivity {

    private Toolbar toolbar_duvidas;
    private ExpandableListView lst_view;
    private String [] opcao = {"op0", "op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8", "op9", "op10", "op11"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_freq);

        toolbar_duvidas = (Toolbar) findViewById(R.id.toolbar_duvidas);
        toolbar_duvidas.setTitle("Dúvidas Frequentes");
        setSupportActionBar(toolbar_duvidas);

        lst_view = (ExpandableListView) findViewById(R.id.lst_view);

        lst_view.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                //Toast.makeText(Duvidas_freq.this, "clic", Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                    switch (i1){
                        case 0 : Intent intent = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent.putExtra("opcao", opcao[0]);
                            startActivity(intent);
                            break;
                        case 1 : Intent intent1 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent1.putExtra("opcao", opcao[1]);
                            startActivity(intent1);
                            break;
                        case 2 : Intent intent2 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent2.putExtra("opcao", opcao[2]);
                            startActivity(intent2);
                            break;
                        case 3 : Intent intent3 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent3.putExtra("opcao", opcao[3]);
                            startActivity(intent3);
                            break;
                        case 4 : Intent intent4 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent4.putExtra("opcao", opcao[4]);
                            startActivity(intent4);
                            break;
                        case 5 : Intent intent5 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent5.putExtra("opcao", opcao[5]);
                            startActivity(intent5);
                            break;
                        case 6 : Intent intent6 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                            intent6.putExtra("opcao", opcao[6]);
                            startActivity(intent6);
                            break;
                    }break;
                    case 1:
                        switch (i1){
                            case 0 : Intent intent7 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                                intent7.putExtra("opcao", opcao[7]);
                                startActivity(intent7);
                                break;
                            case 1 : Intent intent8 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                                intent8.putExtra("opcao", opcao[8]);
                                startActivity(intent8);
                                break;
                            case 2 : Intent intent9 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                                intent9.putExtra("opcao", opcao[9]);
                                startActivity(intent9);
                                break;
                            case 3 : Intent intent10 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                                intent10.putExtra("opcao", opcao[10]);
                                startActivity(intent10);
                                break;
                            case 4 : Intent intent11 = new Intent(Duvidas_freq.this, TextosDuvidas.class);
                                intent11.putExtra("opcao", opcao[11]);
                                startActivity(intent11);
                                break;
                        }break;
                    case 2:
                        switch (i1){
                            case 0 : Toast.makeText(Duvidas_freq.this, "pulgas", Toast.LENGTH_SHORT).show();
                                break;
                            case 1 : Toast.makeText(Duvidas_freq.this, "ferida", Toast.LENGTH_SHORT).show();
                                break;
                            case 2 : Toast.makeText(Duvidas_freq.this, "febre", Toast.LENGTH_SHORT).show();
                                break;
                            case 3 : Toast.makeText(Duvidas_freq.this, "conjuntivite", Toast.LENGTH_SHORT).show();
                                break;
                        }break;
                    case 3:
                        switch (i1){
                            case 0 : Toast.makeText(Duvidas_freq.this, "pedgree", Toast.LENGTH_SHORT).show();
                                break;
                            case 1 : Toast.makeText(Duvidas_freq.this, "vitamax", Toast.LENGTH_SHORT).show();
                                break;
                        }break;

                }
                return true;
            }
        });

        //cria os grupos
        List<String> lstgrupos = new ArrayList<>();
        lstgrupos.add("Vacinas - Cães");
        lstgrupos.add("Vacinas - Gatos");
        lstgrupos.add("Doenças");
        lstgrupos.add("Alimentação");

        //cria os itens de cada grupo
        List<info_duv> lstVacinasCaes = new ArrayList<>();
        lstVacinasCaes.add(new info_duv("Vermífugo", ""));
        lstVacinasCaes.add(new info_duv("Anti-pulgas", ""));
        lstVacinasCaes.add(new info_duv("V8 ou V10", ""));
        lstVacinasCaes.add(new info_duv("Tosse", ""));
        lstVacinasCaes.add(new info_duv("Anti-rábica", ""));
        lstVacinasCaes.add(new info_duv("Giardíase", ""));
        lstVacinasCaes.add(new info_duv("Gripe canina", ""));

        List<info_duv> lstVacinasGatos = new ArrayList<>();
        lstVacinasGatos.add(new info_duv("Vermífugo", ""));
        lstVacinasGatos.add(new info_duv("Anti-pulgas", ""));
        lstVacinasGatos.add(new info_duv("V4", ""));
        lstVacinasGatos.add(new info_duv("Anti-rábica", ""));
        lstVacinasGatos.add(new info_duv("Quadrupla felina", ""));

        //cria os itens de cada grupo
        List<info_duv> lstDoencas = new ArrayList<>();
        lstDoencas.add(new info_duv("Pulgas", ""));
        lstDoencas.add(new info_duv("Ferida", ""));
        lstDoencas.add(new info_duv("Febre", ""));
        lstDoencas.add(new info_duv("Conjuntive", ""));


        //cria os itens de cada grupo
        List<info_duv> lstAliment = new ArrayList<>();
        lstAliment.add(new info_duv("Pedgree", ""));
        lstAliment.add(new info_duv("Vitamax", ""));

        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<info_duv>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstgrupos.get(0), lstVacinasCaes);
        lstItensGrupo.put(lstgrupos.get(1), lstVacinasGatos);
        lstItensGrupo.put(lstgrupos.get(2), lstDoencas);
        lstItensGrupo.put(lstgrupos.get(3), lstAliment);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        adaptador_lst adaptador = new adaptador_lst(this, lstgrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        lst_view.setAdapter(adaptador);

    }
}
