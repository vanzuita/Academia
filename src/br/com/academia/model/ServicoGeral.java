package br.com.academia.model;

import java.math.BigDecimal;

public class ServicoGeral extends Funcionario {

	private String setor;
	private boolean periculosidade;
	
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public boolean isPericulosidade() {
		return periculosidade;
	}
	public void setPericulosidade(boolean periculosidade) {
		this.periculosidade = periculosidade;
	}
	
	@Override
	public BigDecimal bonificacao() {
		if (periculosidade) {
			return getSalario().multiply(new BigDecimal(0.11)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return super.bonificacao();
	}
	
}
