package metier.entities;

public class Activite {

	private int idactivite;
	private String nom_activite;
	public int getIdactivite() {
		return idactivite;
	}
	public void setIdactivite(int idactivite) {
		this.idactivite = idactivite;
	}
	public String getNom_activite() {
		return nom_activite;
	}
	public void setNom_activite(String nom_activite) {
		this.nom_activite = nom_activite;
	}
	public Activite(String nom_activite) {
		super();
		this.nom_activite = nom_activite;
	}
	public Activite() {
		super();
	}
	@Override
	public String toString() {
		return "Activite [idactivite=" + idactivite + ", nom_activite=" + nom_activite + "]";
	}
	
	
}
