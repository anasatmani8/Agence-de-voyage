package metier.entities;

public class Panier {

	private int idpanier;
	private int id_date_voyage;
	public int getIdpanier() {
		return idpanier;
	}
	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}
	public int getId_date_voyage() {
		return id_date_voyage;
	}
	public void setId_date_voyage(int id_date_voyage) {
		this.id_date_voyage = id_date_voyage;
	}
	public Panier(int id_date_voyage) {
		super();
		this.id_date_voyage = id_date_voyage;
	}
	public Panier() {
		super();
	}
	@Override
	public String toString() {
		return "Panier [idpanier=" + idpanier + ", id_date_voyage=" + id_date_voyage + "]";
	}
	
	
}
