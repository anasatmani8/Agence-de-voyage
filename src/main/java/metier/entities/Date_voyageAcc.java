package metier.entities;

public class Date_voyageAcc {
	private int id_date;
	private int id_voyageAcc;
	private String date_depart;
	private String date_fin;
	private int prix;
	
	
	public Date_voyageAcc() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Date_voyageAcc(int id_voyageAcc, String date_depart, String date_fin,int prix) {
		super();
		this.id_voyageAcc = id_voyageAcc;
		this.date_depart = date_depart;
		this.date_fin = date_fin;
		this.prix=prix;
	}


	public int getId_date() {
		return id_date;
	}


	public void setId_date(int id_date) {
		this.id_date = id_date;
	}


	public int getId_voyageAcc() {
		return id_voyageAcc;
	}


	public void setId_voyageAcc(int id_voyageAcc) {
		this.id_voyageAcc = id_voyageAcc;
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
	
	
	

}
