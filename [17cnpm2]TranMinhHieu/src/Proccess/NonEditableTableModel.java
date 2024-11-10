package Proccess;

import javax.swing.table.DefaultTableModel;

public class NonEditableTableModel extends DefaultTableModel {
	public NonEditableTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
