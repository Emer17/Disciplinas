package br.edu.uffs.cc.disciplinas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.edu.uffs.cc.disciplinas.R;

public class AltDisciplinaActivity extends Activity {
	private int operacao;
	private EditText edDescricao;
	private EditText edSemestre;
	Disciplina disciplina;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alt_disciplina);
		
		disciplina = new Disciplina();
		
		edDescricao = (EditText) findViewById(R.id.txtDescricao);
		edSemestre = (EditText) findViewById(R.id.edSemestre);
		//CheckBox chkConcluida = (CheckBox) findViewById(R.id.chkConcluida);
		Intent intent = getIntent();
		if(intent != null) {
			Bundle bundle = intent.getExtras();
			if(bundle != null) {
				disciplina.setId(bundle.getLong("id"));
				disciplina.setDescricao(bundle.getString("descricao"));
				disciplina.setSemestre(bundle.getInt("semestre"));
				disciplina.setConcluida(bundle.getBoolean("concluida"));
				
				edDescricao.setText(disciplina.getDescricao());
				edSemestre.setText(String.valueOf(disciplina.getSemestre()));
				//chkConcluida.setChecked(disciplina.getConcluida());
				
				operacao = 1; // Alteração
			} else {
				disciplina.setConcluida(false);
				
				operacao = 0; // Inclusão
			}
		}
	}
	
	public void btSalvarClick(View view) {
		if (edDescricao.getText().equals("")) {
			Toast.makeText(AltDisciplinaActivity.this, "Informe a descrição", Toast.LENGTH_SHORT).show();
			edDescricao.requestFocus();
			return;
		}
		
		disciplina.setDescricao(edDescricao.getText().toString());
		disciplina.setConcluida(disciplina.getConcluida());
		try {
			disciplina.setSemestre(Integer.parseInt(edSemestre.getText().toString()));
		} catch (NumberFormatException e) {
			Toast.makeText(AltDisciplinaActivity.this, "Semestre inválido", Toast.LENGTH_SHORT).show();
			edSemestre.requestFocus();
			return;
		} catch (Exception e) {
			Toast.makeText(AltDisciplinaActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
			return;
		}

		BD bd = new BD(this);
		
		switch (operacao) {
			case 0:
				bd.insere(disciplina);			
				Toast.makeText(this, "Disciplina inserida com sucesso!", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				bd.atualiza(disciplina);			
				Toast.makeText(this, "Disciplina atualizada com sucesso.", Toast.LENGTH_SHORT).show();
		}
		finish();		
	}
	
	public void btCancelarClick(View view) {
		finish();
	}
}