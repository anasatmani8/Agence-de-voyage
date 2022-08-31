package metier.entities;

public class Hotel {

	private int id_hotel;
	private String nom_hotel;
	private int id_ville;
	private int nbr_etoile;
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public int getId_ville() {
		return id_ville;
	}
	public void setId_ville(int id_ville) {
		this.id_ville = id_ville;
	}
	public int getNbr_etoile() {
		return nbr_etoile;
	}
	public void setNbr_etoile(int nbr_etoile) {
		this.nbr_etoile = nbr_etoile;
	}
	public Hotel(String nom_hotel, int id_ville, int nbr_etoile) {
		super();
		this.nom_hotel = nom_hotel;
		this.id_ville = id_ville;
		this.nbr_etoile = nbr_etoile;
	}
	public Hotel() {
		super();
	}
	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nom_hotel=" + nom_hotel + ", id_ville=" + id_ville + ", nbr_etoile="
				+ nbr_etoile + "]";
	}
	
	
}