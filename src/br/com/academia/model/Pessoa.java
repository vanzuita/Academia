package br.com.academia.model;

import java.util.GregorianCalendar;

public class Pessoa {

	private int id;
	private String nome;
	private String cpf;
	private GregorianCalendar dataNascimento;
	private String celular;
	private String email;
	private Endereco endereco;
	private char sexo;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public GregorianCalendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	public String getIdade() {
		
		return calculaIdade();
	}
	
	private String calculaIdade() {
		
		return null;
	}
	
}
