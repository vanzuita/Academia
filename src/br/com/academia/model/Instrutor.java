package br.com.academia.model;

import java.math.BigDecimal;

public class Instrutor extends Funcionario {

	private String especialidade;

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	@Override
	public BigDecimal bonificacao() {
		if (getSalario().compareTo(new BigDecimal(1000)) > 0) {
			return super.bonificacao();
		} else {
			return getSalario().multiply(new BigDecimal(0.09)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}
}
