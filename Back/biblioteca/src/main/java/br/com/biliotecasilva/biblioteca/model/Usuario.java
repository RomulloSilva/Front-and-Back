package br.com.biliotecasilva.biblioteca.model;

public class Usuario {
	
	private int id;
	private String email;
	private String nome;
	private String senha;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String toString() {
		return "{\"id\":"+this.id+", \"nome\":"+this.nome+", \"senha\":"+this.senha+", \"email\":"+this.email+"}";
	}
}
