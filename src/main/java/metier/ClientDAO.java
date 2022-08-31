package metier;

import java.util.List;

import metier.entities.Client;

public interface ClientDAO {

	public void addClient(metier.entities.Client Client);
	List <metier.entities.Client> getAllClient();
	int getIdClient(String username, String password);
	public String getnomClient(int id);
	public boolean checkUserExist(String username);
	public Client getVlientById(int id);
}
