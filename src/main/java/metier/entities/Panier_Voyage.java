package metier.entities;

import java.io.InputStream;

public class Panier_Voyage {
	private int prix;
	private String date_depart;
	private String date_fin;
	private String destination;
	private InputStream image;
	private String baseImage;
	
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

	public Panier_Voyage() {
		
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	

	public Panier_Voyage(String date_depart, String date_fin, String destination,int prix,InputStream image) {
		super();
		this.date_depart = date_depart;
		this.date_fin = date_fin;
		this.destination = destination;
		this.prix=prix;
		this.image=image;
	}

	@Override
	public String toString() {
		return "Panier_Voyage [prix=" + prix + ", date_depart=" + date_depart + ", date_fin=" + date_fin
				+ ", destination=" + destination + "]";
	}

	
	

}
