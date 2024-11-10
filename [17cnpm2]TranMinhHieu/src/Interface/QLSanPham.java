package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Proccess.QLSanPhamController;

public class QLSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTable table;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnThoat;
	private JButton btnKLuu;

	public JTextField getTxtMaLoai() {
		return txtMaLoai;
	}

	public JTextField getTxtTenLoai() {
		return txtTenLoai;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnThem() {
		return btnThem;
	}

	public JButton getBtnXoa() {
		return btnXoa;
	}

	public JButton getBtnSua() {
		return btnSua;
	}

	public JButton getBtnLuu() {
		return btnLuu;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public JButton getBtnKluu() {
		return btnKLuu;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				QLSanPham frame = new QLSanPham();
				frame.setVisible(true);
				new QLSanPhamController(frame);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public QLSanPham() {
		setTitle("Danh Mục Loại Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 618, 394);
		contentPane.add(tabbedPane);

		// Tab 1: Quản lý Loại Sản Phẩm
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		tabbedPane.addTab("Quản lý Loại Sản Phẩm", null, panel1, null);
		tabbedPane.setEnabledAt(0, true);

		JLabel lblMaLoai = new JLabel("Mã Loại:");
		lblMaLoai.setBounds(50, 60, 60, 25);
		panel1.add(lblMaLoai);

		txtMaLoai = new JTextField();
		txtMaLoai.setBounds(120, 60, 100, 25);
		panel1.add(txtMaLoai);
		txtMaLoai.setColumns(10);

		JLabel lblTenLoai = new JLabel("Tên Loại:");
		lblTenLoai.setBounds(50, 100, 60, 25);
		panel1.add(lblTenLoai);

		txtTenLoai = new JTextField();
		txtTenLoai.setBounds(120, 100, 200, 25);
		panel1.add(txtTenLoai);
		txtTenLoai.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(50, 150, 80, 25);
		panel1.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(140, 150, 80, 25);
		panel1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(230, 150, 80, 25);
		panel1.add(btnSua);

		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(320, 150, 80, 25);
		panel1.add(btnLuu);

		btnKLuu = new JButton("KLưu");
		btnKLuu.setBounds(410, 150, 80, 25);
		panel1.add(btnKLuu);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setBounds(500, 150, 80, 25);
		panel1.add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 200, 523, 150);
		panel1.add(scrollPane);

		// Tạo bảng (JTable) và mô hình dữ liệu
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã Loại", "Tên Loại" }));
		scrollPane.setViewportView(table);

		JLabel lblTitle = new JLabel("DANH MỤC LOẠI SẢN PHẨM");
		lblTitle.setBounds(120, 19, 300, 30);
		panel1.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		// Tab 2: Quản lý Sản Phẩm (hoặc nội dung khác)
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		tabbedPane.addTab("Quản lý Sản Phẩm", null, panel2, null);

		// Các thành phần giao diện trong Tab 2 có thể được thêm vào panel2.
	}
}
