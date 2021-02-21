package br.com.academia;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.academia.controller.ClienteDAO;
import br.com.academia.controller.DAO;
import br.com.academia.controller.PessoaDAO;
import br.com.academia.model.Atendente;
import br.com.academia.model.Cliente;
import br.com.academia.model.Endereco;
import br.com.academia.model.Funcionario;
import br.com.academia.model.Instrutor;
import br.com.academia.model.Pessoa;
import br.com.academia.model.ServicoGeral;
import br.com.academia.ui.TelaPessoa;

public class Principal {

	public static void main(String[] args) {
		new TelaPessoa();
	}
}
