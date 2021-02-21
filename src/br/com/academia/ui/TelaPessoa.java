package br.com.academia.ui;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.text.MaskFormatter;

import br.com.academia.controller.DAO;
import br.com.academia.controller.PessoaDAO;
import br.com.academia.model.Pessoa;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPessoa extends JFrame {
	private static final int MASCULINO = 0;
	private static final int FEMININO = 1;
	private static final int OUTRO = 2;
	private static final String[] SEXO = {"Masculino", "Feminino", "Outro"};
	
	private static final int CLIENTE = 0;
	private static final int INSTRUTOR = 1;
	private static final int ATENDENTE = 2;
	private static final int SERVICO_GERAL = 3;
	private static final String[] TIPO = {"Cliente", "Instrutor", "Atendente", "Serviços Gerais"};
	
	private JScrollPane scpPessoa;
	private JLabel lblId;
	private JTextField txtId;
	private JPanel pnlMain;
	private JLabel lblNome;
	private JTextField txtNome;
	private final Font fonte = new Font(Font.DIALOG, Font.PLAIN, 12);
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblDataNasc;
	private JFormattedTextField txtDataNasc;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSexo;
	private JComboBox cmbSexo;
	private JLabel lblTipo;
	private JComboBox cmbTipo;
	private PanelButton pnlButton;
	private PanelCliente pnlCliente;
	private PanelAtendente pnlAtendente;
	private JTable tblPessoa;
	private ModeloTabelaPessoa mtblPessoa;
	
	
	public TelaPessoa() {
		super();
	
		initialize();
	}
	
	private void initialize() {
		setTitle("Cadastro de Pessoa");
		setContentPane(getPnlMain());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(497, 547);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private JPanel getPnlMain() {
		if(pnlMain == null) {
			pnlMain = new JPanel();
			pnlMain.setLayout(null);
			pnlMain.add(getPnlCliente());
			pnlMain.add(getLblId());
			pnlMain.add(getTxtId());
			pnlMain.add(getLblNome());
			pnlMain.add(getTxtNome());
			pnlMain.add(getLblCpf());
			pnlMain.add(getTxtCpf());
			pnlMain.add(getLblDataNasc());
			pnlMain.add(getTxtDataNasc());
			pnlMain.add(getLblCelular());
			pnlMain.add(getTxtCelular());
			pnlMain.add(getLblEmail());
			pnlMain.add(getTxtEmail());
			pnlMain.add(getLblSexo());
			pnlMain.add(getCmbSexo());
			pnlMain.add(getLblTipo());
			pnlMain.add(getCmbTipo());
			pnlMain.add(getPnlAtendente());
			pnlMain.add(getPnlButton());
			pnlMain.add(getScpPessoa());
			
		}
		return pnlMain;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel();
			lblId.setText("Identificador");
			lblId.setBounds(10, 11, 74, 14);
			lblId.setFont(fonte);
		}
		return lblId;
	}
	private JTextField getTxtId() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(10, 27, 86, 20);
			txtId.setFont(fonte);
			txtId.setEnabled(false);
		}
		return txtId;
	}
	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 50, 46, 14);
			lblNome.setFont(fonte);
		}
		return lblNome;
	}
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(10, 71, 464, 20);
		}
		return txtNome;
	}
	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setBounds(10, 102, 46, 14);
			lblCpf.setFont(fonte);
		}
		return lblCpf;
	}
	private JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			try {
				txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			txtCpf.setBounds(10, 118, 98, 20);
		}
		return txtCpf;
	}
	private JLabel getLblDataNasc() {
		if (lblDataNasc == null) {
			lblDataNasc = new JLabel("Data Nascimento");
			lblDataNasc.setBounds(125, 100, 98, 20);
			lblDataNasc.setFont(fonte);
		}
		return lblDataNasc;
	}
	private JFormattedTextField getTxtDataNasc() {
		if (txtDataNasc == null) {
			try {
				txtDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			txtDataNasc.setBounds(125, 118, 109, 20);
		}
		return txtDataNasc;
	}
	private JLabel getLblCelular() {
		if (lblCelular == null) {
			lblCelular = new JLabel("Celular");
			lblCelular.setBounds(10, 147, 46, 14);
			lblCelular.setFont(fonte);
		}
		return lblCelular;
	}
	private JTextField getTxtCelular() {
		if (txtCelular == null) {
			txtCelular = new JTextField();
			txtCelular.setBounds(10, 162, 98, 20);
			txtCelular.setColumns(10);
		}
		return txtCelular;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setBounds(125, 147, 46, 14);
			lblEmail.setFont(fonte);
		}
		return lblEmail;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setBounds(125, 162, 349, 20);
		}
		return txtEmail;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo");
			lblSexo.setBounds(254, 103, 46, 14);
			lblSexo.setFont(fonte);
		}
		return lblSexo;
	}
	private JComboBox getCmbSexo() {
		if (cmbSexo == null) {
			cmbSexo = new JComboBox(SEXO);
			cmbSexo.setBounds(254, 118, 130, 20);
			cmbSexo.setFont(fonte);
		}
		return cmbSexo;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(331, 12, 46, 14);
			lblTipo.setFont(fonte);
		}
		return lblTipo;
	}
	private JComboBox getCmbTipo() {
		if (cmbTipo == null) {
			cmbTipo = new JComboBox(TIPO);
			cmbTipo.setBounds(331, 28, 143, 20);
			cmbTipo.setFont(fonte);
			cmbTipo.setSelectedIndex(CLIENTE);
			getPnlAtendente();
			pnlAtendente.setVisible(false);
			cmbTipo.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if (cmbTipo.getSelectedIndex() == CLIENTE) {
						pnlCliente.setVisible(true);
						pnlAtendente.setVisible(false);
					} else if (cmbTipo.getSelectedIndex() == ATENDENTE) {
						pnlAtendente.setVisible(true);
						pnlCliente.setVisible(false);
					} else {
						pnlAtendente.setVisible(false);
						pnlCliente.setVisible(false);
					}
				}
			});
		}
		return cmbTipo;
	}
	
	private PanelCliente getPnlCliente() {
		if (pnlCliente == null) {
			pnlCliente = new PanelCliente();
			pnlCliente.setBounds(0, 184, 500, 65);
		}
		return pnlCliente;
	}
	
	private PanelAtendente getPnlAtendente() {
		if (pnlAtendente == null) {
			pnlAtendente = new PanelAtendente();
			pnlAtendente.setBounds(0, 184, 500, 65);
		}
		return pnlAtendente;
	}
	
	private PanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new PanelButton() {
				
				@Override
				protected void limpar() {
					limparTela();
				}
				
				@Override
				protected void incluir() {
					Pessoa p = preencher();
					new PessoaDAO().incluir(p);
					mtblPessoa.adicionar(p);
					limparTela();
				}
				
				@Override
				protected void excluir() {
					try {
						int id = Integer.parseInt(txtId.getText());
						new PessoaDAO().excluir(id);
						limparTela();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Informe o código a ser excluído no campo identificador", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				@Override
				protected void alterar() {
					Pessoa p = preencher();
					new PessoaDAO().alterar(p);
					limparTela();
				}
			};
					
			pnlButton.setBounds(10, 259, 464, 30);
		}
		return pnlButton;
	}
	
	private void limparTela() {
		txtId.setText("");
		txtNome.setText("");
		cmbTipo.setSelectedIndex(0);
		txtCpf.setText("");
		txtEmail.setText("");
		txtCelular.setText("");
		txtDataNasc.setText("");
		cmbSexo.setSelectedIndex(0);
		tblPessoa.getSelectionModel().setSelectionInterval(-1, -1);
	}
	
	private Pessoa preencher() {
		Pessoa p = new Pessoa();
		if (!txtId.getText().isEmpty()) {
			p.setId(Integer.parseInt(txtId.getText()));
		}
		p.setNome(txtNome.getText());
		p.setCelular(txtCelular.getText());
		p.setCpf(txtCpf.getText().replaceAll("\\.", "").replaceAll("-", ""));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar gc = new GregorianCalendar();
		try {
			gc.setTime(sdf.parse(txtDataNasc.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setDataNascimento(gc);
		p.setEmail(txtEmail.getText());
		char sexo = ' ';
		if (cmbSexo.getSelectedIndex() == MASCULINO) {
			sexo = 'M';
		} else if (cmbSexo.getSelectedIndex() == FEMININO) {
			sexo = 'F';
		} else if (cmbSexo.getSelectedIndex() == OUTRO) {
			sexo = 'O';
		}
		p.setSexo(sexo);
		return p;
	}
	private JScrollPane getScpPessoa() {
		if (scpPessoa == null) {
			scpPessoa = new JScrollPane();
			scpPessoa.setBounds(10, 295, 464, 202);
			scpPessoa.setViewportView(getTblPessoa());
		}
		return scpPessoa;
	}
	private JTable getTblPessoa() {
		if (tblPessoa == null) {
			mtblPessoa = new ModeloTabelaPessoa(new PessoaDAO().pesquisar());
			tblPessoa = new JTable(mtblPessoa);
			tblPessoa.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblPessoa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) return;
					int row = tblPessoa.getSelectedRow();
					if (row > -1) {
						Pessoa p = mtblPessoa.getLista().get(row);
						mostrarDados(p);
					}
					
				}
			});
		}
		return tblPessoa;
	}
	
	private void mostrarDados(Pessoa p) {
		txtId.setText(String.valueOf(p.getId()));
		txtCelular.setText(p.getCelular());
		txtCpf.setText(p.getCpf());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtDataNasc.setText(sdf.format(p.getDataNascimento().getTime()));
		txtEmail.setText(p.getEmail());
		txtNome.setText(p.getNome());
		if (p.getSexo() == 'M') {
			cmbSexo.setSelectedIndex(MASCULINO);
		} else if (p.getSexo() == 'F') {
			cmbSexo.setSelectedIndex(FEMININO);
		} else {
			cmbSexo.setSelectedIndex(OUTRO);
		}
	}
}
