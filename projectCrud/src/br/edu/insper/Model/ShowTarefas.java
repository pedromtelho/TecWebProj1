package br.edu.insper.Model;

public class ShowTarefas {
	private Integer id;
	private String nome;
	private String tarefa;
	private String data;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getTarefa() {
		return this.tarefa;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return this.data;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
