package metier.entities;

public class Ville {

	private int id_ville;
	private String nom_ville;
	private int id_typeVoyage;

	public int getId_ville() {
		return id_ville;
	}

	public void setId_ville(int id_ville) {
		this.id_ville = id_ville;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}


	public int getId_typeVoyage() {
		return id_typeVoyage;
	}

	public void setNom_voyage(int nom_voyage) {
		this.id_typeVoyage = nom_voyage;
	}

	public Ville(String nom_ville) {
		super();
		this.nom_ville = nom_ville;
	}

	public Ville(String nom_ville, int id_typeVoyage) {
		super();
		this.nom_ville = nom_ville;

		this.id_typeVoyage = id_typeVoyage;
	}

	public Ville() {
		super();
	}

	@Override
	public String toString() {
		return "Ville [id_ville=" + id_ville + ", nom_ville=" + nom_ville + ", id_typeVoyage=" + id_typeVoyage + "]";
	}

}
