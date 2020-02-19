package com.magasin.business.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.magasin.beans.Categories;
import com.magasin.beans.Produits;
import com.magasin.business.service.Database;

public class ProductControl {
	public List<Produits> getAll() {
			Produits produit = new Produits();
			Categories categorie = new Categories();
			Connection conexion = Database.getInstance().getConexion();
			List<Produits> lists = new ArrayList<Produits>();
			try {
				Statement state = conexion != null ? conexion.createStatement() : null ;
				ResultSet resultProduit = state.executeQuery("SELECT * FROM produits");
				ResultSet resultCategorie = state.executeQuery("SELECT * FROM produits");
				while (resultProduit.next()) {
					produit.setId(resultProduit.getInt("id"));
					produit.setLibelle(resultProduit.getString("libelle"));
					produit.setQuantite(resultProduit.getInt("quantite"));
					produit.setId_Categorie(resultProduit.getInt("id_categorie"));
					lists.add(produit);
					
				}
				while (resultCategorie.next()) {
					categorie.setId(resultCategorie.getInt("id"));
					categorie.setLibelle(resultCategorie.getString("libelle"));
					lists.add(produit);
					
				}
				state.close();
				resultProduit.close();
				resultCategorie.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return lists;
	}
}