package metier.entities;

import java.io.InputStream;

public class Voyage {
	
	private int id_voyage;
	private String nom_ville;
	private String nom_hotel;
	private String description_hotel;
	private int prix_hotel;
	private String date_depart;
	private String date_fin;
	private InputStream image;
	private String baseImage;
	
	
	public String getBaseImage() {
		return baseImage;
	}
	public void setBaseImage(String baseImage) {
		this.baseImage = baseImage;
	}
	
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	public String getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public Voyage() {
		// TODO Auto-generated constructor stub
	}

	public Voyage(String nom_ville, String nom_hotel, String description_hotel, int prix_hotel, InputStream image) {
		super();
		this.nom_ville = nom_ville;
		this.nom_hotel = nom_hotel;
		this.description_hotel = description_hotel;
		this.prix_hotel = prix_hotel;
		this.image=image;
	}
	
	

	public Voyage(int id_voyage, String nom_ville, String nom_hotel, String description_hotel, int prix_hotel) {
		super();
		this.id_voyage = id_voyage;
		this.nom_ville = nom_ville;
		this.nom_hotel = nom_hotel;
		this.description_hotel = description_hotel;
		this.prix_hotel = prix_hotel;
	}
	

	public Voyage(int id_voyage, String nom_hotel, String description_hotel, int prix_hotel) {
		super();
		this.id_voyage = id_voyage;
		this.nom_hotel = nom_hotel;
		this.description_hotel = description_hotel;
		this.prix_hotel = prix_hotel;
	}

	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public String getNom_hotel() {
		return nom_hotel;
	}

	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}

	public String getDescription_hotel() {
		return description_hotel;
	}

	public void setDescription_hotel(String description_hotel) {
		this.description_hotel = description_hotel;
	}

	public int getPrix_hotel() {
		return prix_hotel;
	}

	public void setPrix_hotel(int prix_hotel) {
		this.prix_hotel = prix_hotel;
	}
	public Voyage(int id_voyage, String nom_hotel, String description_hotel, int prix_hotel, String date_depart,
			String date_fin) {
		super();
		this.id_voyage = id_voyage;
		this.nom_hotel = nom_hotel;
		this.description_hotel = description_hotel;
		this.prix_hotel = prix_hotel;
		this.date_depart = date_depart;
		this.date_fin = date_fin;
	}
	public Voyage(String nom_ville, String nom_hotel, String description_hotel, int prix_hotel, String date_depart,
			String date_fin, InputStream image) {
		super();
		this.nom_ville = nom_ville;
		this.nom_hotel = nom_hotel;
		this.description_hotel = description_hotel;
		this.prix_hotel = prix_hotel;
		this.date_depart = date_depart;
		this.date_fin = date_fin;
		this.image = image;
	}

	
	
}