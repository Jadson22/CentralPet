package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import com.cursoandroid.centralpet.centralpet.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Duvidas_freq extends AppCompatActivity {

    private Toolbar toolbar_duvidas;
    private ExpandableListView lst_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_freq);

        toolbar_duvidas = (Toolbar) findViewById(R.id.toolbar_duvidas);
        toolbar_duvidas.setTitle("Dúvidas Frequentes");
        setSupportActionBar(toolbar_duvidas);

        lst_view = (ExpandableListView) findViewById(R.id.lst_view);

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
