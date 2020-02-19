package com.magasin.business.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	/*
private Connection connexion;
private PreparedStatement pstatement;
private ResultSet result;
	
	
	public int Database(String login, String password) {
		
		int check = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionmagasin?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
			
			this.pstatement = this.connexion.prepareStatement("select login, password from utilisateur where login=? and password=?");
			this.pstatement.setString(1,login);
			this.pstatement.setString(2,password);
			this.result = this.pstatement.executeQuery();
			while(result.next()) {
				if(result.getString(1).equals(login) && result.getString(2).equals(password))
				{
					check = 1;
				}
			}
			pstatement.close();
			result.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public Connection getConnexion() {
		return connexion;
	}
	*/
	
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
 
	private java.lang.String url = "jdbc:mysql://localhost:3306/gestion_magasin_tahzima?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private java.lang.String user = "root";
	private java.lang.String passwd = "";
	private Connection conexion;
 
	private Database() {
		if (conexion == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(url, user, passwd);
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public Connection getConexion() {
		return conexion;
	}
}