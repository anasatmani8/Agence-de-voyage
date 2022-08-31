package metier;

import java.util.List;

public interface Hotel {

	List <metier.entities.Hotel> getAllHotel();
	void addHotel(metier.entities.Hotel TV);
	void updateHotel(metier.entities.Hotel TV);
	void deleteHotel(metier.entities.Hotel TV);
	metier.entities.Hotel getHotelById(int id);
	List <metier.entities.Hotel> getHotelParville(int mc);
	int getIdByNomVille(String nom_ville);
	
}
