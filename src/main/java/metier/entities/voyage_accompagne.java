package metier.entities;

import java.io.InputStream;

public class voyage_accompagne {
	private int id_voyageAccompagne;
	private String nom_voyage;
	private int prix;
	private String  description;
	private String nom_guide;
	private int activite;
	private String destination;
	private String date_depart;
	private String duree;
	private InputStream image;
	private String baseImage;
	private String activite2;
	
	
	
	public String getActivite2() {
		return activite2;
	}
	public void setActivite2(String activite2) {
		this.activite2 = activite2;
	}
	public String getBaseImage() {
		return baseImage;
	}
	public void setBaseImage(String baseImage) {
		this.baseImage = baseImage;
	}
	public int getId_voyageAccompagne() {
		return id_voyageAccompagne;
	}
	public void setId_voyageAccompagne(int id_voyageAccompagne) {
		this.id_voyageAccompagne = id_voyageAccompagne;
	}
	
	public voyage_accompagne(int id_voyageAccompagne, int prix, String description, String nom_guide, int activite,
			String destination, String duree ,String nom_voyage,String date_depart) {
		super();
		this.id_voyageAccompagne = id_voyageAccompagne;
		this.prix = prix;
		this.description = description;
		this.nom_guide = nom_guide;
		this.activite = activite;
		this.destination = destination;
		this.duree = duree;
		this.nom_voyage=nom_voyage;
		this.date_depart=date_depart;
	}
	public voyage_accompagne(String nom_voyage, int prix, String description, String nom_guide, int activite,
			String destination, String date_depart, String duree, InputStream image) {
		super();
		this.nom_voyage = nom_voyage;
		this.prix = prix;
		this.description = description;
		this.nom_guide = nom_guide;
		this.activite = activite;
		this.destination = destination;
		this.date_depart = date_depart;
		this.duree = duree;
		this.image = image;
	}
	
	
	public voyage_accompagne(String nom_voyage, String description, String nom_guide, int activite, String destination,
			InputStream baseImage) {
		super();
		this.nom_voyage = nom_voyage;
		this.description = description;
		this.nom_guide = nom_guide;
		this.activite = activite;
		this.destination = destination;
		this.image = baseImage;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getNom_voyage() {
		return nom_voyage;
	}
	public void setNom_voyage(String nom_voyage) {
		this.nom_voyage = nom_voyage;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom_guide() {
		return nom_guide;
	}
	public void setNom_guide(String nom_guide) {
		this.nom_guide = nom_guide;
	}
	public int getActivite() {
		return activite;
	}
	public void setActivite(int activite) {
		this.activite = activite;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public voyage_accompagne(String nom_voyage, int prix, String description, String nom_guide, int activite,
			String destination, String date_depart, String duree) {
		super();
		this.nom_voyage = nom_voyage;
		this.prix = prix;
		this.description = description;
		this.nom_guide = nom_guide;
		this.activite = activite;
		this.destination = destination;
		this.date_depart = date_depart;
		this.duree = duree;
	}
	
	
	public voyage_accompagne() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "voyage_accompagne [id_voyageAccompagne=" + id_voyageAccompagne + ", nom_voyage=" + nom_voyage
				+ ", prix=" + prix + ", description=" + description + ", nom_guide=" + nom_guide + ", activite="
				+ activite + ", destination=" + destination + ", date_depart=" + date_depart + ", duree=" + duree + "]";
	}
	/* public void encodeAll() throws UnsupportedEncodingException {
		if (getPicture() != null) {
			byte[] encodedphotobyte = Base64.encodeBase64(picture);
			String base64Encoded = new String(encodedphotobyte, "UTF-8");
			setEncodedPhoto(base64Encoded);
		}
	}

	private void setEncodedPhoto(String encodedPicture) {
		// TODO Auto-generated method stub
		this.encodedPicture=encodedPicture;
	}
	
	public String getEncodedString() {
		return encodedPicture;
	}
	
	*/
}