package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;

import java.awt.event.ActionEvent;

public class frmKiþiEkle extends JFrame {

	private JPanel contentPane;
	private JTextField txtAd;
	private JTextField txtSoyÝsim;
	private JTextField txtSehir;
	private JTextField txtNumara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKiþiEkle frame = new frmKiþiEkle();
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
	public frmKiþiEkle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 196, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAd = new JLabel("\u0130sim :");
		lblAd.setBounds(20, 11, 46, 14);
		contentPane.add(lblAd);
		
		JLabel lblSoyisim = new JLabel("Soyisim :");
		lblSoyisim.setBounds(20, 37, 46, 14);
		contentPane.add(lblSoyisim);
		
		JLabel lblsehir = new JLabel("\u015Eehir :");
		lblsehir.setBounds(20, 62, 46, 14);
		contentPane.add(lblsehir);
		
		JLabel lblNumara = new JLabel("Numara :");
		lblNumara.setBounds(20, 87, 46, 14);
		contentPane.add(lblNumara);
		
		txtAd = new JTextField();
		txtAd.setBounds(76, 8, 86, 20);
		contentPane.add(txtAd);
		txtAd.setColumns(10);
		
		txtSoyÝsim = new JTextField();
		txtSoyÝsim.setColumns(10);
		txtSoyÝsim.setBounds(76, 34, 86, 20);
		contentPane.add(txtSoyÝsim);
		
		txtSehir = new JTextField();
		txtSehir.setColumns(10);
		txtSehir.setBounds(76, 59, 86, 20);
		contentPane.add(txtSehir);
		
		txtNumara = new JTextField();
		txtNumara.setColumns(10);
		txtNumara.setBounds(76, 84, 86, 20);
		contentPane.add(txtNumara);
		
		JButton btnEkle = new JButton("Ki\u015Fiyi Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gelenAd=txtAd.getText();
				String gelenSoyÝsim=txtSoyÝsim.getText();
				String gelenSehir=txtSehir.getText();
				String gelenNumara=txtNumara.getText();
				
				String sorgu="insert into kayýtlar(isim,soyisim,sehir,numara) values('"+gelenAd+"','"+gelenSoyÝsim+"','"+gelenSehir+"','"+gelenNumara+"')";
				
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
		btnEkle.setBounds(49, 136, 89, 23);
		contentPane.add(btnEkle);
	}
}
