package br.edu.uffs.cc.disciplinas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
	private static final String NOME_BD = "database";
	private static final int VERSAO_BD = 1;
	
	public BDCore(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		StringBuilder SQL;
		SQL = new StringBuilder();
		SQL.append("create table disciplina ( ");
		SQL.append("  _id integer primary key autoincrement, ");
		SQL.append("  descricao varchar(50) not null, ");
		SQL.append("  semestre integer not null, ");
		SQL.append("  concluida char(1) default 'N' not null ");
		SQL.append("); ");
		
		bd.execSQL(SQL.toString());
		
		SQL = new StringBuilder();
		SQL.append("create table disciplina_pre_requisito ( ");
		SQL.append("  _id integer primary key autoincrement, ");
		SQL.append("  id_disciplina integer not null, ");
		SQL.append("  id_pre_requisito integer not null, ");
		SQL.append("  foreign key (id_disciplina) references disciplina (_id), ");
		SQL.append("  foreign key (id_pre_requisito) references disciplina(_id) ");
		SQL.append("  foreign key (id_pre_requisito) references disciplina(_id) ");
		SQL.append("); ");
		
		bd.execSQL(SQL.toString());
		
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Algoritmos e programa��o', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Circuitos digitais', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Introdu��o � inform�tica', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Leitura e produ��o textual I', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Matem�tica instrumental', 1);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estat�stica b�sica', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estrutura de dados I', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Geometria anal�tica', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Leitura e produ��o textual II', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Sistemas digitais', 2);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('�lgebra linear', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('C�lculo I', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estrutura de dados II', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Matem�tica discreta', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Programa��o I', 3);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Banco de dados I', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('C�lculo II', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Organiza��o de computadores', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Probabilidade e estat�stica', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Programa��o II', 4);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Banco de dados II', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Engenharia de software I', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Grafos', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Inicia��o � pr�tica cient�fica', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Teoria da computa��o', 5);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('C�lculo num�rico', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Direitos e cidadania', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Engenharia de software II', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Hist�ria da fronteira Sul', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Linguagens formais e aut�matos', 6);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Computa��o gr�fica', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Constru��o de compiladores', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Fundamentos da cr�tica social', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Intelig�ncia artificial', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Sistemas operacionais', 7);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Introdu��o ao pensamento social', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Meio ambiente, economia e sociedade', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Planejamento e gest�o de projetos', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Redes de computadores', 8);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Computa��o distribu�da', 9);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Seguran�a e auditoria de sistemas', 9);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Trabalho de conclus�o de curso I', 9);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Trabalho de conclus�o de curso II', 10);");
		
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (7, 1);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (9, 4);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (10, 2);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (11, 8);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (12, 5);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (13, 7);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (15, 1);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (17, 12);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (18, 10);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (19, 6);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (20, 1);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (21, 16);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (22, 15);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (22, 20);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (23, 13);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (25, 13);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (26, 5);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (26, 7);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (28, 22);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (30, 25);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (31, 8);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (31, 11);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (32, 25);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (34, 23);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (35, 18);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (38, 22);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (39, 35);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (40, 39);");
		bd.execSQL("insert into disciplina_pre_requisito (id_disciplina, id_pre_requisito) values (43, 42);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		//bd.execSQL("drop table disciplina;");
		//onCreate(bd);
	}

}
