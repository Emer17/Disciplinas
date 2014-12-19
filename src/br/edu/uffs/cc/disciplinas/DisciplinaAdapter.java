package br.edu.uffs.cc.disciplinas;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import br.edu.uffs.cc.disciplinas.R;

public class DisciplinaAdapter extends BaseAdapter {
	private Context context;
	private List<Disciplina> lista;
	private boolean editavel; 
	
	public DisciplinaAdapter(Context ctx, List<Disciplina> lista, boolean editavel) {
		this.context = ctx;
		this.lista = lista;
		this.editavel = editavel;
	}
	
	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {
		return lista.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return lista.get(arg0).getId();
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		final int auxPosition = position;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.disciplina_layout, null);
		
		TextView txtDescricao = (TextView) layout.findViewById(R.id.txtDescricao);
		txtDescricao.setText(lista.get(position).getDescricao());
		
		CheckBox chkConcluida = (CheckBox) layout.findViewById(R.id.chkConcluida);
		chkConcluida.setChecked(lista.get(position).getConcluida());
		
		Button btEditar = (Button) layout.findViewById(R.id.btEditar);
		Button btExcluir = (Button) layout.findViewById(R.id.btExcluir);
		
		btEditar.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AltDisciplinaActivity.class);
				intent.putExtra("id", lista.get(auxPosition).getId());
				intent.putExtra("descricao", lista.get(auxPosition).getDescricao());
				intent.putExtra("semestre", lista.get(auxPosition).getSemestre());
				intent.putExtra("concluida", lista.get(auxPosition).getConcluida());
				
				AltDisciplinaActivity.sender = context;
				context.startActivity(intent);
			}
		});
		
		btExcluir.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				BD bd = new BD(context);
				bd.exclui(lista.get(auxPosition));
				
				((ListDisciplinaActivity)context).atualizaLista();
			}
		});
		
		chkConcluida.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				BD bd = new BD(context);
				Disciplina disciplina = lista.get(auxPosition);
				disciplina.setConcluida(isChecked);
				bd.atualiza(disciplina);
			}
		});

		if (editavel) {
			chkConcluida.setVisibility(View.VISIBLE);
			btEditar.setVisibility(View.VISIBLE);
			btExcluir.setVisibility(View.VISIBLE);
		} else {
			
			chkConcluida.setVisibility(View.GONE);
			btEditar.setVisibility(View.GONE);
			btExcluir.setVisibility(View.GONE);
			
		}
		/*
		txtDescricao.setVisibility(View.VISIBLE);
		layout.setVisibility(View.VISIBLE);		
		*/
		return layout;
	}
}
