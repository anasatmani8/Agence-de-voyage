package metier;

import java.util.ArrayList;
import java.util.List;



import metier.entities.Hotel;

public class HotelParVille {

	private String ville;
	private metier.entities.Hotel hotel = new Hotel();
	private List<metier.entities.Hotel> hotels = new ArrayList<metier.entities.Hotel>();
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public metier.entities.Hotel getHotel() {
		return hotel;
	}
	public void setHotel(metier.entities.Hotel hotel) {
		this.hotel = hotel;
	}
	public List<metier.entities.Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<metier.entities.Hotel> hotels) {
		this.hotels = hotels;
	}
	public HotelParVille(String ville, Hotel hotel, List<Hotel> hotels) {
		super();
		this.ville = ville;
		this.hotel = hotel;
		this.hotels = hotels;
	}
	public HotelParVille() {
		super();
	}
	
	
}
