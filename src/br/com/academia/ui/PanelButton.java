package br.com.academia.ui;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public abstract class PanelButton extends JPanel {
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private final Font font = new Font(Font.DIALOG, Font.PLAIN, 12);
	public PanelButton() {
		setLayout(new GridLayout(1, 4));
		add(getBtnIncluir());
		add(getBtnAlterar());
		add(getBtnExcluir());
		add(getBtnLimpar());
	}

	private JButton getBtnIncluir() {
		if (btnIncluir == null) {
			btnIncluir = new JButton("Incluir");
			btnIncluir.setFont(font);
			btnIncluir.setMnemonic('I');
			btnIncluir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					incluir();
				}
			});
		}
		return btnIncluir;
	}
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setFont(font);
			btnAlterar.setMnemonic(KeyEvent.VK_A);
			btnAlterar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					alterar();
					
				}
			});
		}
		return btnAlterar;
	}
	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setFont(font);
			btnExcluir.setMnemonic(KeyEvent.VK_E);
			btnExcluir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					excluir();
				}
			});
		}
		return btnExcluir;
	}
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton("Limpar");
			btnLimpar.setFont(font);
			btnLimpar.setMnemonic(KeyEvent.VK_L);
			btnLimpar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					limpar();
				}
			});
		}
		return btnLimpar;
	}
	
	protected abstract void incluir();
	
	protected abstract void alterar();
	
	protected abstract void excluir();
	
	protected abstract void limpar();
}
