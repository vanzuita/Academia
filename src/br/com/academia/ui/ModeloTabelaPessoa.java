package br.com.academia.ui;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import br.com.academia.model.Pessoa;

public class ModeloTabelaPessoa extends AbstractTableModel {
	
	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int CELULAR = 2;
	private static final int DATA_NASCIMENTO = 3;
	private static final String[] COLUNAS = {"Código", "Nome", "Celular", "Nascimento"};
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<Pessoa> lista;
	
	public ModeloTabelaPessoa(List<Pessoa> lista) {
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		return COLUNAS.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int coluna) {
		if (lista.isEmpty()) return null;
		Pessoa p = lista.get(row);
		switch (coluna) {
		case ID:
			return String.valueOf(p.getId());
		case NOME:
			return p.getNome();
		case CELULAR:
			return p.getCelular();
		case DATA_NASCIMENTO:
			return sdf.format(p.getDataNascimento().getTime());
		default:
			throw new IndexOutOfBoundsException("Coluna inv�lida");
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case ID:
			return String.class;
		case NOME:
			return String.class;
		case CELULAR:
			return String.class;
		case DATA_NASCIMENTO:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("Coluna inv�lida");	
		}
	}
	
	public String getColumnName(int column) {
		return COLUNAS[column];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Pessoa getPessoa(int row) {
		if (row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	
	private int indiceDe(Pessoa p) {
		// return p.getId();
		return lista.indexOf(p);
	}
	
	public void adicionar(Pessoa pes) {
		lista.add(pes);		
		fireTableRowsInserted(indiceDe(pes), indiceDe(pes));
		
	}
	
	public void excluir(Pessoa p) {
		fireTableRowsDeleted(indiceDe(p), indiceDe(p));
		lista.remove(p);
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
}
