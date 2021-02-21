package br.com.academia.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class PanelCliente extends JPanel {
	private JLabel lblPeso;
	private JTextField txtPeso;
	private JLabel lblAltura;
	private JTextField txtAltura;
	private JLabel lblDataContrato;
	private JFormattedTextField txtDataContrato;
	private JLabel lblPesoOsseo;
	private JTextField txtPesoOsseo;
	private JLabel lblPesoMuscular;
	private JTextField txtPesoMuscular;
	private JLabel lblModalidade;
	private JComboBox cmbModalidade;
	public PanelCliente() {
		setLayout(null);
		add(getLblPeso());
		add(getTxtPeso());
		add(getLblAltura());
		add(getTxtAltura());
		add(getLblDataContrato());
		add(getTxtDataContrato());
		add(getLblPesoOsseo());
		add(getTxtPesoOsseo());
		add(getLblPesoMuscular());
		add(getTxtPesoMuscular());
		add(getLblModalidade());
		add(getCmbModalidade());
	}
	private JLabel getLblPeso() {
		if (lblPeso == null) {
			lblPeso = new JLabel("Peso");
			lblPeso.setBounds(10, 11, 56, 14);
		}
		return lblPeso;
	}
	private JTextField getTxtPeso() {
		if (txtPeso == null) {
			txtPeso = new JTextField();
			txtPeso.setBounds(10, 36, 56, 20);
			txtPeso.setColumns(10);
		}
		return txtPeso;
	}
	private JLabel getLblAltura() {
		if (lblAltura == null) {
			lblAltura = new JLabel("Altura");
			lblAltura.setBounds(76, 11, 56, 14);
		}
		return lblAltura;
	}
	private JTextField getTxtAltura() {
		if (txtAltura == null) {
			txtAltura = new JTextField();
			txtAltura.setBounds(76, 36, 56, 20);
			txtAltura.setColumns(10);
		}
		return txtAltura;
	}
	private JLabel getLblDataContrato() {
		if (lblDataContrato == null) {
			lblDataContrato = new JLabel("Data Contrato");
			lblDataContrato.setBounds(145, 11, 76, 14);
		}
		return lblDataContrato;
	}
	private JFormattedTextField getTxtDataContrato() {
		if (txtDataContrato == null) {
			try {
				txtDataContrato = new JFormattedTextField(new MaskFormatter("##/##/####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtDataContrato.setBounds(142, 36, 79, 20);
		}
		return txtDataContrato;
	}
	private JLabel getLblPesoOsseo() {
		if (lblPesoOsseo == null) {
			lblPesoOsseo = new JLabel("P. \u00D3sseo");
			lblPesoOsseo.setBounds(227, 11, 56, 14);
		}
		return lblPesoOsseo;
	}
	private JTextField getTxtPesoOsseo() {
		if (txtPesoOsseo == null) {
			txtPesoOsseo = new JTextField();
			txtPesoOsseo.setBounds(231, 36, 46, 20);
			txtPesoOsseo.setColumns(10);
		}
		return txtPesoOsseo;
	}
	private JLabel getLblPesoMuscular() {
		if (lblPesoMuscular == null) {
			lblPesoMuscular = new JLabel("P. Muscular");
			lblPesoMuscular.setBounds(283, 11, 67, 14);
		}
		return lblPesoMuscular;
	}
	private JTextField getTxtPesoMuscular() {
		if (txtPesoMuscular == null) {
			txtPesoMuscular = new JTextField();
			txtPesoMuscular.setBounds(287, 36, 46, 20);
			txtPesoMuscular.setColumns(10);
		}
		return txtPesoMuscular;
	}
	private JLabel getLblModalidade() {
		if (lblModalidade == null) {
			lblModalidade = new JLabel("Modalidade");
			lblModalidade.setBounds(364, 11, 76, 14);
		}
		return lblModalidade;
	}
	private JComboBox getCmbModalidade() {
		if (cmbModalidade == null) {
			cmbModalidade = new JComboBox();
			cmbModalidade.setBounds(364, 36, 108, 20);
		}
		return cmbModalidade;
	}
}
