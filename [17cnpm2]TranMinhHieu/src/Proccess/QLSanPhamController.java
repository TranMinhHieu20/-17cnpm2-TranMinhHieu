package Proccess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DataBase.Connect;
import Interface.QLSanPham;

public class QLSanPhamController {
	private QLSanPham view;

	public QLSanPhamController(QLSanPham view) {
		this.view = view;
		Object[] columnNames = { "Mã loại", "Tên loại" };
		Object[][] data = {};
		DefaultTableModel model = new NonEditableTableModel(data, columnNames);
		view.getTable().setModel(model);
		showDataTable();
		addListener();
	}

	public void addListener() {
		view.getBtnThem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				them();

			}
		});
		view.getBtnKluu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KLuu();
			}
		});
		view.getBtnLuu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				luu();
			}
		});
		view.getBtnXoa().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoa();
			}
		});
		view.getBtnSua().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sua();
			}
		});

		view.getBtnThoat().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thoat();
			}
		});

	}

	// Ham xoa cac TextField
	private void setNull() {
		// Xoa trang cac JtextField
		view.getTxtMaLoai().setText(null);
		view.getTxtTenLoai().setText(null);
		view.getTxtMaLoai().requestFocus();
	}

	// Ham khoa cac TextField
	private void setKhoa(boolean a) {
		// Khoa hoac mo khoa cho Cac JTextField
		view.getTxtMaLoai().setEnabled(!a);
		view.getTxtTenLoai().setEnabled(!a);
	}

	// Ham khoa cac Button
	private void setButton(boolean a) {
		// Vo hieu hoac co hieu luc cho cac JButton
		view.getBtnThem().setEnabled(a);
		view.getBtnXoa().setEnabled(a);
		view.getBtnSua().setEnabled(a);
		view.getBtnLuu().setEnabled(!a);
		view.getBtnKluu().setEnabled(!a);
		view.getBtnThoat().setEnabled(a);
	}

	public void showDataTable() {
		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setRowCount(0);
		String sel = "select maloai, tenloai from LoaiSp";
		try {
			PreparedStatement pt = Connect.getConnection().prepareStatement(sel);
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				Object[] row = { rs.getString("Maloai"), rs.getString("TenLoai") };
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickShow() {
		int selectRow = view.getTable().getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(view, "Chon hang muon sua");
			return;
		} else {
			view.getTxtTenLoai().setText(view.getTable().getValueAt(selectRow, 1).toString());
			view.getTxtMaLoai().setText(view.getTable().getValueAt(selectRow, 2).toString());
		}
	}

	public void them() {
		setNull();
		setKhoa(false);
		setButton(false);

	}

	public void xoa() {
		int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(view, "Vui long chon hang can xoa!");
			return;
		}
//		int customerID = (int) view.getTable().getValueAt(selectedRow, 0);
		String sql = "delete from customer where customerID = ?";
		try {
			PreparedStatement pt = Connect.getConnection().prepareStatement(sql);
			pt.setInt(1, customerID);
			int cnt = pt.executeUpdate();
			if (cnt > 0) {
				JOptionPane.showMessageDialog(view, "Delete thanh cong!");

				return;
			} else {
				JOptionPane.showMessageDialog(view, "Delete that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sua() {
		clickShow();

	}

	public void luu() {
		String maLoai = view.getTxtMaLoai().getText();
		String tenLoai = view.getTxtTenLoai().getText();
		if (maLoai.isEmpty() || tenLoai.isEmpty()) {
			JOptionPane.showMessageDialog(view, "KO đc bo trong");
			return;
		}

		String insert = "insert into LoaiSp values(?, ?)";
		try {
			PreparedStatement pt = Connect.getConnection().prepareStatement(insert);
			pt.setString(1, maLoai);
			pt.setString(2, tenLoai);
			int cnt = pt.executeUpdate();
			if (cnt > 0) {
				JOptionPane.showMessageDialog(view, "insert thanh cong");
				showDataTable();
			} else {
				JOptionPane.showMessageDialog(view, "insert that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void KLuu() {
		setNull();
		setKhoa(true);
		setButton(true);
	}

	public void thoat() {
		view.dispose();
	}
}
