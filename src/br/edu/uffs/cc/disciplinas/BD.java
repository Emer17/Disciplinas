package br.edu.uffs.cc.disciplinas;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class BD {
	private SQLiteDatabase bd;
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
	}
	
	public void insere(Disciplina disciplina) {
		ContentValues valores = new ContentValues();
		valores.put("descricao", disciplina.getDescricao());
		valores.put("semestre", disciplina.getSemestre());
		valores.put("concluida", disciplina.getConcluida());
		
		bd.insert("disciplina", null, valores);
	}
	
	public void atualiza(Disciplina disciplina){
		ContentValues valores = new ContentValues();
		valores.put("descricao", disciplina.getDescricao());
		valores.put("semestre", disciplina.getSemestre());
		valores.put("concluida", disciplina.getConcluida() ? "S" : "N");
		
		bd.update("disciplina", valores, "_id = ?", new String[]{"" + disciplina.getId()});
	}
	
	public void exclui(Disciplina disciplina) {
		bd.delete("disciplina", "_id = " + disciplina.getId(), null);
	}
	
	public List<Disciplina> busca(char filtro) {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		String[] colunas = new String[]{"_id", "descricao", "semestre", "concluida"};
		
		Cursor cursor = null;
		try {
			switch (filtro) {
				case 'T':
					cursor = bd.query("disciplina", colunas, null, null, null, null, "semestre, descricao");
					break;
				case 'C':
					cursor = bd.query("disciplina", colunas, "concluida = 'S'", null, null, null, "semestre, descricao");
					break;
				case 'D':
					String where = "_id not in ( " +
							       "  select r.id_disciplina " +
							       "  from disciplina_pre_requisito r " + 
							       "  join disciplina d " +
							       "  on r.id_pre_requisito = d._id " +
							       "  where d.concluida = 'N' " +
							       ") " +
							       "and concluida = 'N' ";
					cursor = bd.query("disciplina", colunas, where, null, null, null, "semestre, descricao");
			}
		
			if (cursor.getCount() > 0) {
				cursor.moveToFirst();			
				do {
					Disciplina d = new Disciplina();
					d.setId(cursor.getLong(0));
					d.setDescricao(cursor.getString(1));
					d.setSemestre(cursor.getInt(2));
					d.setConcluida(cursor.getString(3).equals("S"));
					lista.add(d);
				} while (cursor.moveToNext());
			}
		} catch (Exception e) {
			Toast.makeText(null, e.getMessage(), Toast.LENGTH_LONG).show();
		}		
		return lista;
	}
}
