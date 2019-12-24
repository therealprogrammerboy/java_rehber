package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class anaEkran extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anaEkran frame = new anaEkran();
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
	public anaEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u00FCtfen yapmak istedi\u011Finiz i\u015Flemi se\u00E7in :");
		lblNewLabel.setBounds(140, 11, 191, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnKisiEkle = new JButton("Ki\u015Fi Ekle");
		btnKisiEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKiþiEkle yeni=new frmKiþiEkle();
				yeni.setVisible(true);
			}
		});
		btnKisiEkle.setBounds(10, 37, 89, 70);
		contentPane.add(btnKisiEkle);
		
		JButton btnKisiGuncelle = new JButton("Ki\u015Fi G\u00FCncelle");
		btnKisiGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKisiGuncelle yeni=new frmKisiGuncelle();
				yeni.setVisible(true);
			}
		});
		btnKisiGuncelle.setBounds(109, 36, 98, 71);
		contentPane.add(btnKisiGuncelle);
		
		JButton btnKisiSil = new JButton("Ki\u015Fi Sil");
		btnKisiSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKisiSil yeni=new frmKisiSil();
				yeni.setVisible(true);
			}
		});
		btnKisiSil.setBounds(217, 37, 89, 71);
		contentPane.add(btnKisiSil);
		
		JButton btnListele = new JButton("Ki\u015Fileri Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKisiListele yeni = null;
				try {
					yeni = new frmKisiListele();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				yeni.setVisible(true);
			}
		});
		btnListele.setBounds(316, 37, 141, 70);
		contentPane.add(btnListele);
	}

}
