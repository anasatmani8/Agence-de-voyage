package metier.entities;

public class Client {
	private int idclient;
	private String nom_client;
	private String prenom_client;
	private int tel_client;
	private String CNE_client;
	private String carte_bancaire;
	private String adresse_client;
	private String username;
	private String password;
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getPrenom_client() {
		return prenom_client;
	}
	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}
	public int getTel_client() {
		return tel_client;
	}
	public void setTel_client(int tel_client) {
		this.tel_client = tel_client;
	}
	public String getCNE_client() {
		return CNE_client;
	}
	public void setCNE_client(String cNE_client) {
		CNE_client = cNE_client;
	}
	public String getCarte_bancaire() {
		return carte_bancaire;
	}
	public void setCarte_bancaire(String carte_bancaire) {
		this.carte_bancaire = carte_bancaire;
	}
	public String getAdresse_client() {
		return adresse_client;
	}
	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client(String nom_client, String prenom_client, int tel_client, String cNE_client, String carte_bancaire,
			String adresse_client, String username, String password) {
		super();
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.tel_client = tel_client;
		CNE_client = cNE_client;
		this.carte_bancaire = carte_bancaire;
		this.adresse_client = adresse_client;
		this.username = username;
		this.password = password;
	}
	
	
	
	public Client(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Client() {
		super();
	}
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client
				+ ", tel_client=" + tel_client + ", CNE_client=" + CNE_client + ", carte_bancaire=" + carte_bancaire
				+ ", adresse_client=" + adresse_client + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
