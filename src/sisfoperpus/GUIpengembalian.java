/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoperpus;

/**
 *
 * @author Herwin
 */

import javax.activation.DataSource;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIpengembalian extends JFrame implements ActionListener
{
	public String JJ9, JJ10,  id_member, tanggal_pengembalian;
	private static JLabel lblWall;
	private static JPanel contentPane;
	
	private static JTextField tfIDM;
	private static JTextField tfTPeng;
	
	private static JButton btnUpdate;
	
	public static String driver;
	public static Connection con;
	public static Statement st;
	
	public GUIpengembalian()
	{
            setLocationRelativeTo(null);
            setResizable(false);
            contentPane = new JPanel();	
		setContentPane(contentPane);
		contentPane.setLayout(null);               
                lblWall = new JLabel("");
		lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/viewmenupengembaliann.png"))); 
               lblWall.setBounds(0, -120, 700, 420);
		contentPane.add(lblWall);
                
		JLabel lbJJ9       = new JLabel ("Data");
		JLabel lbJJ10      = new JLabel ("Pengembalian Buku Perpustakaan");
		JLabel lbIDM       = new JLabel ("ID Member ");
		JLabel lbTPeng     = new JLabel ("Tanggal Pengembalian");
		
		lbJJ9.setFont(new java.awt.Font("Footlight MT Light",10,25));
		
		tfIDM              = new JTextField (20);
		tfTPeng            = new JTextField (20);
		
		btnUpdate          = new JButton ("Update");
		
		
		setLayout(null);
		
		Dimension sizelbJJ9       = lbJJ9.getPreferredSize();
		Dimension sizelbJJ10      = lbJJ10.getPreferredSize();
		Dimension sizelbIDM       = lbIDM.getPreferredSize();
		Dimension sizelbTPeng     = lbTPeng.getPreferredSize();
		
		Dimension sizetfIDM       = tfIDM.getPreferredSize();
		Dimension sizetfTPeng     = tfTPeng.getPreferredSize();
		
		Dimension sizebtnUpdate   = btnUpdate.getPreferredSize();
		
		lbJJ9.setBounds(245,20, sizelbJJ9.width, sizelbJJ9.height);
		lbJJ10.setBounds(160,50, sizelbJJ10.width, sizelbJJ10.height);
		lbIDM.setBounds(10,110, sizelbIDM.width, sizelbIDM.height);
		lbTPeng.setBounds(10,150, sizelbTPeng.width, sizelbTPeng.height);
		
		
		
		tfIDM.setBounds(150,91, sizetfIDM.width, sizetfIDM.height);
		tfTPeng.setBounds(150,130, sizetfTPeng.width, sizetfTPeng.height);
		
		btnUpdate.setBounds(200,230, sizebtnUpdate.width, sizebtnUpdate.height);
		
		add(lbJJ9);
		add(lbJJ10);
		add(lbIDM);
		add(tfIDM);
		add(lbTPeng);
		add(tfTPeng);
		
		add(btnUpdate);
		
		btnUpdate.addActionListener(this);
                btnUpdate.setBackground(Color.RED);
                btnUpdate.setForeground(Color.white);
                
		setSize(460,300);
		setTitle("Pengembalian");
                setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void update() throws Exception
	{
		id_member                       = tfIDM.getText();
		tanggal_pengembalian            = tfTPeng.getText();
				
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		
		st.executeUpdate("UPDATE tb_peminjaman SET tanggal_pengembalian  = '"+tanggal_pengembalian+"'WHERE id_member = '"+id_member+"'");
		System.out.println("1 row updated");
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== btnUpdate)
		{
			try
			{
				this.update();
			}
				catch (Exception es)
			{
					JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}
	
	}
		
	public static void main(String args []) throws Exception
	{
		GUIpengembalian s = new GUIpengembalian ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
	}
	
}
	
	
	





