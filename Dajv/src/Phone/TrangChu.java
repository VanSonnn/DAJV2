package Phone;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	
	
	private ServerSocket serversocket;
	private BufferedReader bf;
	private Thread t;
	private JTextField txtTmKim;
	private JTable table_1;
	private JTable table_2;
	private JTable table;
	private JTextField tftendienthoai;
	private JTextField tfgia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1432, 876);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1418, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbTNV = new JLabel("Manage");
		lbTNV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbTNV.setBounds(10, 11, 241, 24);
		panel.add(lbTNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setForeground(SystemColor.window);
		panel_1.setBounds(0, 46, 115, 791);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_tv = new JPanel();
		panel_tv.setBounds(113, 46, 1301, 791);
		contentPane.add(panel_tv);
		panel_tv.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(266, 95, 1035, 651);
		panel_tv.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(10, 0, 1291, 39);
		panel_tv.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chat");
		lblNewLabel_2.setForeground(new Color(255, 102, 102));
		lblNewLabel_2.setBounds(10, 0, 111, 42);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 41, 255, 705);
		panel_tv.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nhân viên A");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(52, 75, 106, 20);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nhân viên B");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(52, 122, 106, 20);
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nhân viên C");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(52, 172, 106, 20);
		panel_3.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Nhân viên D");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_2.setBounds(52, 223, 112, 20);
		panel_3.add(lblNewLabel_4_1_2);
		
		txtTmKim = new JTextField();
		txtTmKim.setText("Tìm kiếm");
		txtTmKim.setBounds(10, 11, 148, 20);
		panel_3.add(txtTmKim);
		txtTmKim.setColumns(10);
	
		JPanel panel_kho = 	new JPanel();
		panel_kho.setBounds(117, 46, 1301, 784);
		contentPane.add(panel_kho);
		panel_kho.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaptionBorder);
		panel_6.setBounds(10, 505, 1281, 268);
		panel_kho.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Tên điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(65, 60, 123, 19);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_11 = new JLabel("Quản lý kho");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_11.setBounds(555, 11, 209, 19);
		panel_6.add(lblNewLabel_11);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tình trạng:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(758, 60, 100, 19);
		panel_6.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Số lượng: ");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(995, 60, 123, 19);
		panel_6.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Giá:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_3.setBounds(456, 60, 77, 19);
		panel_6.add(lblNewLabel_5_3);
		
		tftendienthoai = new JTextField();
		tftendienthoai.setBounds(198, 59, 160, 20);
		panel_6.add(tftendienthoai);
		tftendienthoai.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(1096, 61, 41, 20);
		panel_6.add(spinner);
		
		tfgia = new JTextField();
		tfgia.setBounds(525, 58, 132, 20);
		panel_6.add(tfgia);
		tfgia.setColumns(10);
		
		JButton btadd = new JButton("Add");
		btadd.setBackground(new Color(64, 224, 208));
		btadd.setBounds(362, 169, 100, 35);
		panel_6.add(btadd);
		
		JButton btdelete = new JButton("Delete");
		btdelete.setBackground(new Color(64, 224, 208));
		btdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btdelete.setBounds(710, 169, 100, 35);
		panel_6.add(btdelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mới", "Cũ", ""}));
		comboBox.setBounds(868, 57, 28, 22);
		panel_6.add(comboBox);
		
		JButton btsubtract = new JButton("Subtract");
		btsubtract.setBackground(new Color(64, 224, 208));
		btsubtract.setBounds(539, 169, 89, 35);
		panel_6.add(btsubtract);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaptionBorder);
		panel_7.setBounds(10, 11, 1281, 444);
		panel_kho.add(panel_7);
		panel_7.setLayout(null);
		
		table = new JTable();
		table.setBounds(31, 22, 1225, 400);
		panel_7.add(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 479, 1281, 2);
		panel_kho.add(separator);
		
		JPanel panel_tc = new JPanel();
		panel_tc.setBounds(118, 46, 1300, 791);
		contentPane.add(panel_tc);
		panel_tc.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(10, 60, 1111, 484);
		panel_tc.add(table_2);
		
		JLabel lblNewLabel_7 = new JLabel("Danh sách Nhân viên");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 16, 231, 33);
		panel_tc.add(lblNewLabel_7);
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/Tích2.png")); // Tải biểu tượng
		Image scaledIcon = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // Thay đổi kích thước của biểu tượng
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 153, 51));
		panel_4.setBounds(854, 13, 112, 38);
		panel_tc.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Cập nhật");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(10, 0, 91, 36);
		panel_4.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setIcon(new ImageIcon(scaledIcon));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 0, 51));
		panel_5.setBounds(1002, 13, 119, 38);
		panel_tc.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Xóa ");
		lblNewLabel_10.setBounds(10, 0, 129, 38);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));

		ImageIcon icon1 = new ImageIcon(getClass().getResource("/img/thungrac.png")); // Tải biểu tượng mới
		Image scaledIcon1 = icon1.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // Thay đổi kích thước của biểu tượng
		lblNewLabel_10.setIcon(new ImageIcon(scaledIcon1)); // Đặt biểu tượng vào JLabel

		panel_5.add(lblNewLabel_10);




		
		JPanel panel_nv = new JPanel();
		panel_nv.setBounds(118, 46, 1300, 791);
		contentPane.add(panel_nv);
		panel_nv.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(10, 62, 684, 341);
		panel_nv.add(table_1);
		
		JLabel lblNewLabel_8 = new JLabel("Thông tin nhân viên:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8.setBounds(10, 11, 211, 28);
		panel_nv.add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("Nhân viên");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_nv.setVisible(true);
				panel_tv.setVisible(false);
				panel_kho.setVisible(false);
				panel_tc.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 239, 125, 42);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kho hàng");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_kho.setVisible(true);
				panel_tv.setVisible(false);
				panel_tc.setVisible(false);
				panel_nv.setVisible(false);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 88, 125, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblTVn = new JLabel("Tư vấn");
		lblTVn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 panel_tv.setVisible(true);
				 panel_kho.setVisible(false);
				 panel_tc.setVisible(false);
					panel_nv.setVisible(false);

				}
		});
		
		lblTVn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTVn.setBounds(10, 164, 125, 42);
		panel_1.add(lblTVn);
		
		JLabel lblNewLabel_3 = new JLabel("....");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 318, 125, 42);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Trang chủ");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tc.setVisible(true);
				panel_tv.setVisible(false);
				panel_kho.setVisible(false);
				panel_nv.setVisible(false);

			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 23, 125, 42);
		panel_1.add(lblNewLabel_6);
		
		
		
		Person p = new Person();
		p.informationNVXML();
		p.setNameToTextAreaTNV(lbTNV);

		this.setSize(1432,876);
		try {
			serversocket = new ServerSocket(12344);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t= new Thread(this);
		t.start();
		setLocationRelativeTo(null);
	}
	
	public void run() {
		while (true) {
			try {
				Socket socket = serversocket.accept();
			if(socket != null) {
				bf= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String S = bf.readLine();
				int pos = S.indexOf(":");
				String staffName = S.substring(pos+1);
				ChatPanel p = new ChatPanel(socket, "Manager", staffName);
				tabbedPane.add(staffName, p);
				p.updateUI();
			}
			Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


