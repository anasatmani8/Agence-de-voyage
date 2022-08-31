/**
 * 
 */
package metier.entities;


public class DateVoyage {

	private int iddates_voyage;
	private int id_voyage;
	private String date_depart;
	private String date_fin;
	private int prix;
	public int getIddates_voyage() {
		return iddates_voyage;
	}
	public void setIddates_voyage(int iddates_voyage) {
		this.iddates_voyage = iddates_voyage;
	}
	public int getId_voyage() {
		return id_voyage;
	}
	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
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
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public DateVoyage(int id_voyage, String date_depart, String date_fin, int prix) {
		super();
		this.id_voyage = id_voyage;
		this.date_depart = date_depart;
		this.date_fin = date_fin;
		this.prix = prix;
	}
	
	public DateVoyage() {
		super();
	}
	@Override
	public String toString() {
		return "DateVoyage [iddates_voyage=" + iddates_voyage + ", id_voyage=" + id_voyage + ", date_depart="
				+ date_depart + ", date_fin=" + date_fin + ", prix=" + prix + "]";
	}
	
	
}
