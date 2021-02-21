package br.com.academia.model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Cliente extends Pessoa {

	private BigDecimal peso;
	private BigDecimal altura;
	private int modalidade;
	private GregorianCalendar dataContrato;
	private BigDecimal pesoOsseo;
	private BigDecimal pesoMuscular;
	
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public int getModalidade() {
		return modalidade;
	}
	public void setModalidade(int modalidade) {
		this.modalidade = modalidade;
	}
	public GregorianCalendar getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(GregorianCalendar dataContrato) {
		this.dataContrato = dataContrato;
	}
	public BigDecimal getPesoOsseo() {
		return pesoOsseo;
	}
	public void setPesoOsseo(BigDecimal pesoOsseo) {
		this.pesoOsseo = pesoOsseo;
	}
	public BigDecimal getPesoMuscular() {
		return pesoMuscular;
	}
	public void setPesoMuscular(BigDecimal pesoMuscular) {
		this.pesoMuscular = pesoMuscular;
	}
	
	public BigDecimal getImc() {
		
		return null;
	}
	
	
}
