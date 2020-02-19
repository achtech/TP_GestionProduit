package com.magasin.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.magasin.business.controller.CategorieControl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterCategorie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterCategorie frame = new AjouterCategorie();
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
	public AjouterCategorie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Libelle Categorie");
		lblNewLabel.setBounds(70, 41, 101, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(248, 38, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategorieControl ajouterCategorieControl= new CategorieControl();
				String categorie = textField.getText();
				if(categorie !=null && !categorie.isEmpty()) {
					boolean retour =ajouterCategorieControl.ajouterCategorie(categorie);
					//JOptionPane.showMessageDialog(null, ""+retour);
					if(retour) {
						JOptionPane.showMessageDialog(null, "Categorie Bien Ajouter");
					}else {
						JOptionPane.showMessageDialog(null, "Erreur");
					}					
				}
			}
		});
		btnNewButton.setBounds(10, 88, 190, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu(null);
			}
		});
		btnNewButton_1.setBounds(220, 88, 190, 23);
		contentPane.add(btnNewButton_1);
	}
}
