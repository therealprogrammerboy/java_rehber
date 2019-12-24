package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class frmKisiGuncelle extends JFrame {

	private JPanel contentPane;
	private JTextField txtEski;
	private JTextField txtYeni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKisiGuncelle frame = new frmKisiGuncelle();
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
	public frmKisiGuncelle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEskiNumara = new JLabel("G\u00FCncellenecek Numaray\u0131 Giriniz :");
		lblEskiNumara.setBounds(10, 11, 163, 14);
		contentPane.add(lblEskiNumara);
		
		txtEski = new JTextField();
		txtEski.setBounds(174, 8, 86, 20);
		contentPane.add(txtEski);
		txtEski.setColumns(10);
		
		JLabel lblYeniNumara = new JLabel("Yeni Numaray\u0131 Giriniz :");
		lblYeniNumara.setBounds(59, 36, 114, 14);
		contentPane.add(lblYeniNumara);
		
		txtYeni = new JTextField();
		txtYeni.setBounds(174, 33, 86, 20);
		contentPane.add(txtYeni);
		txtYeni.setColumns(10);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gelenEski=txtEski.getText();
				String gelenYeni=txtYeni.getText();
				String sorgu="update kayýtlar set numara='"+gelenYeni+"' where numara='"+gelenEski+"'";
				String url="jdbc:sqlserver://localhost:1433;databaseName=rehber;integratedSecurity=true;";
				try (Connection con=DriverManager.getConnection(url)){
					Statement st=(Statement) con.createStatement();
					ResultSet rs=st.executeQuery(sorgu);
					rs.close();
					con.close();
				} catch (Exception e2) {
					//e2.printStackTrace();
				}
				//return rs;
			}
		});
		btnGuncelle.setBounds(300, 27, 89, 23);
		contentPane.add(btnGuncelle);
	}
}
