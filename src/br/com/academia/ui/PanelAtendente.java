package br.com.academia.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelAtendente extends JPanel {
	private JLabel lblRamal;
	private JTextField txtRamal;
	public PanelAtendente() {
		setLayout(null);
		add(getLblRamal());
		add(getTxtRamal());
	}

	private JLabel getLblRamal() {
		if (lblRamal == null) {
			lblRamal = new JLabel("Ramal");
			lblRamal.setBounds(10, 11, 46, 14);
		}
		return lblRamal;
	}
	private JTextField getTxtRamal() {
		if (txtRamal == null) {
			txtRamal = new JTextField();
			txtRamal.setBounds(10, 34, 86, 20);
			txtRamal.setColumns(10);
		}
		return txtRamal;
	}
}
