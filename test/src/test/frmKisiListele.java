package test;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class frmKisiListele extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 DefaultTableModel tm;
	 private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKisiListele frame = new frmKisiListele();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmKisiListele() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u0130sim", "Soyisim", "Numara", "\u015Eehir"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(137);
		scrollPane.setViewportView(table);
		
		tm=(DefaultTableModel) table.getModel();
		
		String url="jdbc:sqlserver://localhost:1433;databaseName=rehber;integratedSecurity=true;";
		String sorgu="select * from kayýtlar";
		Connection con = DriverManager.getConnection(url);

        Statement st = (Statement) con.createStatement();
        ResultSet rs = st.executeQuery(sorgu);
        
        while (rs.next()) {
			String isim=rs.getString(1);
			String soyisim=rs.getString(2);
			String numara=rs.getString(3);
			String sehir=rs.getString(4);
			
			String data[]= {isim,soyisim,numara,sehir};
			tm.addRow(data);
			
		}

        }

     //   con.close();

	}
		
			 
		
		
		
		

