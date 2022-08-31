package metier.entities;

public class ReservationAcc {
	private int idReservation;
	private int idVoyageAcc ;
	private int idClient ;
	private int idDate_VoyageAcc ;
	
	
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public int getIdVoyageAcc() {
		return idVoyageAcc;
	}
	public void setIdVoyageAcc(int idVoyageAcc) {
		this.idVoyageAcc = idVoyageAcc;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdDate_VoyageAcc() {
		return idDate_VoyageAcc;
	}
	public void setIdDate_VoyageAcc(int idDate_VoyageAcc) {
		this.idDate_VoyageAcc = idDate_VoyageAcc;
	}
	public ReservationAcc(int idClient, int idDate_VoyageAcc) {
		super();
		this.idClient = idClient;
		this.idDate_VoyageAcc = idDate_VoyageAcc;
	}
	public ReservationAcc() {
		super();
	}
	
	
	
	
}
