package br.edu.uffs.cc.disciplinas;

import java.util.List;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;

public class ListDisciplinaActivity extends ListActivity {
	private char filtro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_list_disciplina);
	
		filtro = 'T';
		
		Intent intent = getIntent();
		if(intent != null) {
			Bundle bundle = intent.getExtras();
			if(bundle != null) {
				filtro = bundle.getChar("filtro");				
			}
		}
		
		switch (filtro) {
			case 'T':
				
				break;
			case 'C':
				break;
			case 'D':
				
		}
		
		atualizaLista();
	}
	
	public void atualizaLista() {
		BD bd = new BD(this);
		
		List<Disciplina> list = bd.busca(filtro);
		setListAdapter(new DisciplinaAdapter(this, list, filtro == 'T'));
		
		/*
		ListView lv = getListView();
		TextView txtNenhuma = new TextView(this);
		txtNenhuma.setText(R.string.strListaVazia);
		
		if (list.size() != 0) {
			lv.setVisibility(View.VISIBLE);
			txtNenhuma.setVisibility(View.GONE);
		} else {
			lv.setVisibility(View.GONE);
			txtNenhuma.setVisibility(View.VISIBLE);
		}
		*/
	}
}