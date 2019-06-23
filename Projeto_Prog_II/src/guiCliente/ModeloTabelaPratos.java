package guiCliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocioClassesBasicas.Loja;
import negocioClassesBasicas.Prato;

public class ModeloTabelaPratos extends AbstractTableModel {

	private ArrayList<Prato> dataList = new ArrayList();
	private String[] columns = { "Nome", "Preço", "Stock", "Indice" };
	Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class };
	boolean[] columnEditables = new boolean[] { false, false, false, false };

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public ModeloTabelaPratos() {

	}

	public ModeloTabelaPratos(List l) {
		dataList.addAll(l);
	}

	public void addPrato(Prato p) {
		dataList.add(p);
		fireTableDataChanged();
	}

	public void addPratoList(List p) {
		dataList.addAll(p);
		fireTableDataChanged();
	}

	public Prato getPratoAt(int row) {
		return dataList.get(row);
	}

	public int getPratoAt(Prato prato) {
		return dataList.lastIndexOf(prato);
	}

	public Prato removePratoAt(int row) {
		Prato p;
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
		Prato p = dataList.get(row);
		switch (col) {
		case 0:
			return p.getNome();
		case 1:
			return p.getValorDoPrato();
		case 2:
			return p.getQuantiadeDisponivel();
		case 3:
			return (1 + dataList.indexOf(p));
		default:
			return null;
		}
	}

}
