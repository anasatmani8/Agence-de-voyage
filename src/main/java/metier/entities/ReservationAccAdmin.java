package metier.entities;

import java.io.InputStream;

public class ReservationAccAdmin {
	private String date_depart;
	private String date_fin;
	private InputStream image;
	private String baseImage;
	private int Prix;
	private String destination;
	private String nomC;
	
	
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
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
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getBaseImage() {
		return baseImage;
	}
	public void setBaseImage(String baseImage) {
		this.baseImage = baseImage;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public ReservationAccAdmin(String date_depart, String date_fin, InputStream image, String baseImage, int prix,
			String destination, String nomC) {
		super();
		this.date_depart = date_depart;
		this.date_fin = date_fin;
		this.image = image;
		this.baseImage = baseImage;
		Prix = prix;
		this.destination = destination;
		this.nomC = nomC;
	}
	public ReservationAccAdmin() {
		super();
	}
	
	
	
	

}
