package guiCliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocioClassesBasicas.Loja;

public class ModeloTabelaLojas extends AbstractTableModel {

	private ArrayList<Loja> dataList = new ArrayList();
	private String[] columns = { "Nome", "Endereco", "Indice" };
	Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class };
	boolean[] columnEditables = new boolean[] { false, false, false };

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public ModeloTabelaLojas() {

	}

	public ModeloTabelaLojas(List l) {
		dataList.addAll(l);
	}

	public void addLoja(Loja p) {
		dataList.add(p);
		fireTableDataChanged();
	}

	public void addLojasList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}

	public Loja getLojasAt(int row) {
		return dataList.get(row);
	}

	public int getLojaAt(Loja loja) {
		return dataList.lastIndexOf(loja);
	}

	public Loja removeLojaAt(int row) {
		Loja p;
		p = dataList.remove(row);
		fireTableDataChanged();
		return p;
	}

	public int getRowCount() {
		return dataList.size();
	}

	public int getColumnCount() {
		return columns.length;
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	public Object getValueAt(int row, int col) {
		Loja p = dataList.get(row);
		switch (col) {
		case 0:
			return p.getNome();
		case 1:
			return p.getEndereco();
		case 2:
			return dataList.indexOf(p)+1;
		default:
			return null;
		}
	}

}
