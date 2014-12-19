package br.edu.uffs.cc.disciplinas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import br.edu.uffs.cc.disciplinas.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btIncluirClick(View view) {
		Intent intent = new Intent(this, AltDisciplinaActivity.class);
		startActivity(intent);
	}	
	
	public void btListarClick(View view) {
		Intent intent = new Intent(this, ListDisciplinaActivity.class);
		intent.putExtra("filtro", 'T'); // Todas
		startActivity(intent);
	}
	
	public void btConcluidaClick(View view) {
		Intent intent = new Intent(this, ListDisciplinaActivity.class);
		intent.putExtra("filtro", 'C'); // Concluídas
		startActivity(intent);
	}
	
	public void btDisponivelClick(View view) {
		Intent intent = new Intent(this, ListDisciplinaActivity.class);
		intent.putExtra("filtro", 'D'); // Disponíveis
		startActivity(intent);
	}
}
