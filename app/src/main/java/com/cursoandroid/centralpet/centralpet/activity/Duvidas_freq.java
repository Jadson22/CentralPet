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
        lstgrupos.add("Vacinas");
        lstgrupos.add("Doenças");
        lstgrupos.add("Alimentação");

        //cria os itens de cada grupo
        List<info_duv> lstVacinas = new ArrayList<>();
        lstVacinas.add(new info_duv("Vermífugo", null));
        lstVacinas.add(new info_duv("V8", null));
        lstVacinas.add(new info_duv("Gripe", null));

        //cria os itens de cada grupo
        List<info_duv> lstDoencas = new ArrayList<>();
        lstDoencas.add(new info_duv("Pulgas", null));
        lstDoencas.add(new info_duv("Ferida", null));
        lstDoencas.add(new info_duv("Febre", null));
        lstDoencas.add(new info_duv("Conjuntive", null));


        //cria os itens de cada grupo
        List<info_duv> lstAliment = new ArrayList<>();
        lstAliment.add(new info_duv("Pedgree", null));
        lstAliment.add(new info_duv("Vitamax", null));

        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<info_duv>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstgrupos.get(0), lstVacinas);
        lstItensGrupo.put(lstgrupos.get(1), lstDoencas);
        lstItensGrupo.put(lstgrupos.get(2), lstAliment);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        adaptador_lst adaptador = new adaptador_lst(this, lstgrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        lst_view.setAdapter(adaptador);



    }
}
