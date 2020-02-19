package com.magasin.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.magasin.beans.Users;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Users utilisateur;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null);
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
	public Menu(Users utilisateur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Categorie");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produit");
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		String log= "vous devez passer par l authentification";
		
		JMenu mnNewMenu_1 = new JMenu(log);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Authentification();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 218);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Categorie    :");
		lblNewLabel.setBounds(10, 11, 91, 14);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categorie", "Operation"
			}
		));
		table.setBounds(10, 36, 394, 137);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterCategorie ajouterCategorie = new AjouterCategorie();
				ajouterCategorie.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 184, 394, 23);
		panel.add(btnNewButton);
		
		
		
		this.utilisateur=utilisateur;
		
		if(utilisateur.getLogin()!=null) {
			log=utilisateur.getNom_utilisateur()+" "+utilisateur.getPrenom_utilisateur();
			mnNewMenu_1.setText(log);
			mnNewMenu.setVisible(true);
			panel.setVisible(true);
			mntmNewMenuItem_2.setText("LogOut");
			
		}else {
			mnNewMenu.setVisible(false);
			panel.setVisible(false);
			mntmNewMenuItem_2.setText("LogIn");
		}
		//MainControl menu= new MainControl();
		//table.setModel(Db);
	}
}
