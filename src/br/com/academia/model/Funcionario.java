package br.com.academia.model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private int funcao;
	private int turno;
	private GregorianCalendar dataContratacao;
	
	public Funcionario(String nome) {
		super(nome);
	}
	
	public Funcionario() {}
	
	public Funcionario(int turno) {
		this.turno = turno;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public int getFuncao() {
		return funcao;
	}
	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public GregorianCalendar getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(GregorianCalendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	public BigDecimal bonificacao() {
		return salario.multiply(new BigDecimal(0.07)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
}
