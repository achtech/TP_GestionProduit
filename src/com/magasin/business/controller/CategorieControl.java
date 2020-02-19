package com.magasin.business.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.magasin.beans.Categories;
import com.magasin.business.service.Database;

public class CategorieControl {
	public List<Categories> getAll(){
		Categories categorie = new Categories();
		Connection conexion = Database.getInstance().getConexion();
		ArrayList<Categories> lists = new ArrayList<Categories>();
		try {
			Statement state = conexion != null ? conexion.createStatement() : null ;
			ResultSet resultCategorie = state.executeQuery("SELECT * FROM produits");
			while (resultCategorie.next()) {
				categorie.setId(resultCategorie.getInt("id"));
				categorie.setLibelle(resultCategorie.getString("libelle"));
				lists.add(categorie);
				
			}
			state.close();
			resultCategorie.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lists;
	}
	
	public Categories get(int id){
		Categories categorie = new Categories();
		return categorie;
	}
	
	public boolean ajouterCategorie(String libelle) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean pass = false;
		//sCategories categorie = new Categories();
		try {
			java.sql.Statement state = conexion != null ? conexion.createStatement() : null ;
			int res = state.executeUpdate("insert into categories(libelle) values('"+libelle+"')");
			if(res>0) {
				pass=true;
			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pass;
	}
	public boolean supprimerCategorie(int id) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean pass = false;
		//Categories categorie = new Categories();
		try {
			java.sql.Statement state = conexion != null ? conexion.createStatement() : null ;
			int res = state.executeUpdate("delete * from categorie where id="+id+"");
			if(res>0) {
				pass=true;
			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pass;
	}
	public boolean modifierCategorie(int id,String libelle) {
		
		Connection conexion = Database.getInstance().getConexion();
		boolean pass = false;
		Categories categorie = new Categories();
		try {
			java.sql.Statement state = conexion != null ? conexion.createStatement() : null ;
			int res = state.executeUpdate("UPDATE categories SET libelle='"+libelle+"' WHERE id="+id+"");
			if(res>0) {
				pass=true;
			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pass;
	}
}
