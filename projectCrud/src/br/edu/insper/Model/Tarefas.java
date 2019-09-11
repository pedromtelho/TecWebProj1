package br.edu.insper.Model;

public class Tarefas {
	private String nomeTarefa;
	private String descTarefa;
	private String date;
	private String user;
	
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public String getDescTarefa() {
		return descTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public void setDescTarefa(String descTarefa) {
		this.descTarefa = descTarefa;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(Object object) {
		this.user = (String) object;
	}
}
