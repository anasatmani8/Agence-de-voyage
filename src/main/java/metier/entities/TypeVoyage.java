package metier.entities;

public class TypeVoyage {

	private int id_typeVoyage;
	private String nom_voyage;
	public int getId_typeVoyage() {
		return id_typeVoyage;
	}
	public void setId_typeVoyage(int id_typeVoyage) {
		this.id_typeVoyage = id_typeVoyage;
	}
	public String getNom_voyage() {
		return nom_voyage;
	}
	public void setNom_voyage(String nom_voyage) {
		this.nom_voyage = nom_voyage;
	}
	public TypeVoyage(String nom_voyage) {
		super();
		this.nom_voyage = nom_voyage;
	}
	@Override
	public String toString() {
		return "TypeVoyage [id_typeVoyage=" + id_typeVoyage + ", nom_voyage=" + nom_voyage + "]";
	}
	public TypeVoyage() {
		super();
	}
	
	
	
}
