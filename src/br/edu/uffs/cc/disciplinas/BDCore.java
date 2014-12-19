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
		
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Algoritmos e programação', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Circuitos digitais', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Introdução à informática', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Leitura e produção textual I', 1);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Matemática instrumental', 1);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estatística básica', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estrutura de dados I', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Geometria analítica', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Leitura e produção textual II', 2);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Sistemas digitais', 2);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Álgebra linear', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Cálculo I', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Estrutura de dados II', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Matemática discreta', 3);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Programação I', 3);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Banco de dados I', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Cálculo II', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Organização de computadores', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Probabilidade e estatística', 4);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Programação II', 4);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Banco de dados II', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Engenharia de software I', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Grafos', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Iniciação à prática científica', 5);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Teoria da computação', 5);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Cálculo numérico', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Direitos e cidadania', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Engenharia de software II', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('História da fronteira Sul', 6);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Linguagens formais e autômatos', 6);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Computação gráfica', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Construção de compiladores', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Fundamentos da crítica social', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Inteligência artificial', 7);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Sistemas operacionais', 7);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Introdução ao pensamento social', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Meio ambiente, economia e sociedade', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Planejamento e gestão de projetos', 8);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Redes de computadores', 8);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Computação distribuída', 9);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Segurança e auditoria de sistemas', 9);");
		bd.execSQL("insert into disciplina (descricao, semestre) values ('Trabalho de conclusão de curso I', 9);");

		bd.execSQL("insert into disciplina (descricao, semestre) values ('Trabalho de conclusão de curso II', 10);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		//bd.execSQL("drop table disciplina;");
		//onCreate(bd);
	}

}
