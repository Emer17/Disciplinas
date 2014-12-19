package br.edu.uffs.cc.disciplinas;

public class Disciplina {
	private long id;
	private String descricao;
	private int semestre;
	private boolean concluida;

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getSemestre() {
		return this.semestre;
	}
	
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	public boolean getConcluida() {
		return this.concluida;
	}
	
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
}
