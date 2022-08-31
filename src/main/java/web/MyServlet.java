package web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.LoginDAO;
import metier.ActiviteImpl;
import metier.ClientIMP;
import metier.DateVoyageAccImp;
import metier.DatesVoyageImp;
import metier.HotelImp;
import metier.HotelParVille;
import metier.Login;
import metier.PanierIMP;
import metier.ReservationVAccoIMP;
import metier.ReservationVoIMP;
import metier.SendEmail;

import metier.VilleImp;
import metier.VoyageImp;

import metier.Voyage_accompagneImp;
import metier.panierImpAc;
import metier.entities.Admin;
import metier.entities.Client;
import metier.entities.Client_pdf;
import metier.entities.DateVoyage;
import metier.entities.Date_voyageAcc;
import metier.entities.Hotel;
import metier.entities.Panier_Voyage;
import metier.entities.ReservationAccAdmin;
import metier.entities.Ville;
import metier.entities.Voyage;
import metier.entities.voyage_accompagne;

/**
 * Servlet sqcxlkyxuctubszp implementation class MyServlet     	
										


											
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet({"/MyServlet","/ajouterVoyage", "/modifierVoyageAcc.do" , "/ListeVoyageAcc"  , "/modifierVoyageAcc" , "/modifierVoyage.do"        , 
	"/modifierVoyage" ,"/chercherParDestination" , "/afficherVoyageAcc","/chercherParPrix" ,"/Authentification", "/chercherhotel"             ,
	"/ListeVoyage" ,"/afficherAllActiviteVoyage", "/ajouterVille" , "/ajouterActivite" ,"/ajouterHotel", "/afficherAllVille"                  ,
	"/afficherAllVilleVoyage" ,"/ajouterVoyageAcc", "/supprimerVoyage", "/supprimerVoyageAcc","/afficherVoyageAccClient","/ListeVoyageClient" ,
	"/decouvrirVoyage", "/loginFirst","/createAccount", "/getInformations", "/ajouterDateVoyage.do", "/ajouterDateVoyage", "/monPanier"       ,
	"/sendEmail","/reserverVoyage", "/checkReservation", "/afficherVoyageAccClient1", "/decouvrirVoyageAcc", "/loginFirstAcc"                 ,
	"/getInformationsAcc", "/ajouterDateVoyageAcc","/reserverVoyageAcc","/checkReservationAcc","/monPanier1", "/libererReservationV"          ,
	"/libererReservation", "/ReservationAccAdmin", "/ajouterDateVoyageAcc.do","/ReservationAdmin","/client_facture","/AllReservationAccClient",
	"/loginFirstAccClient", "/logout"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//////////////////////////////////////////////// Declaration of the global variables /////////////////////////////////////////////////
	
	private metier.Voyage V;
	private metier.DatesVoyageDao DAv;
	private metier.Hotel H;
	private metier.DatesVoyageDao DV;
	private metier.Login LG;
	private metier.ClientDAO CL;
	private metier.IPanier P;
	private metier.panierDAO panier;
	private metier.DateVoyageAccDAO dateAcc;
	private metier.IReservationVoyage RV;
	private metier.IReservationVoyageAcc RVA;
	List<Voyage> listVoyage;
	List<Voyage> listVoyageClient;
	List<Voyage> listVoyagePanier;
	List<Voyage> listVoyageDecouvrir;
	List<DateVoyage> listeDateVoyage; 
	List<Date_voyageAcc>  listeDatevoyagAcc;
	private metier.Ville VL;
	List<metier.entities.Ville> listVille;	
	List <metier.entities.Activite> listActivite;
	private metier.Voyage_accompagneDAO VA;
	InputStream inputStream3 ;
	InputStream inputStream4 ;
	List<voyage_accompagne> listjdida2;
	List<voyage_accompagne> listVoyageAcc;
	List<Date_voyageAcc> listAccjdida;
	List<voyage_accompagne> listVoyageAccClient;
	List<voyage_accompagne> listVoyageAccClient2;
	List<voyage_accompagne> listVoyageAcc2;
	List<voyage_accompagne> listVoyageAccPrix;
	List<voyage_accompagne> listVoyageAccDest;
	List<Panier_Voyage> panierClient;
	List<Panier_Voyage> panierClientAcc;
	List<Panier_Voyage> listeReservationVoyage;
	List<ReservationAccAdmin> listeReservationACCAd;
	List<ReservationAccAdmin> listeReservationACCclient;
	List<ReservationAccAdmin> listeReservationAd;
	
	
	private metier.ActiviteDAO AC;
	static int idClient ;
	static int idVoyage;
	static int idDateVoyage;
	static int idClientt;
	static int id_voyageAcc;
	static int id_date_voyageAcc;
	static int idVoyageAcc;
	
	
	public void init() throws ServletException {
		
	//////////////////////////////////////////////// initialization of the global variables //////////////////////////////////////////////
		V= new VoyageImp();
		H= new HotelImp();
		VL= new VilleImp();
		VA= new Voyage_accompagneImp();
		AC= new ActiviteImpl();
		DV= new DatesVoyageImp();
		LG= new Login();
		CL= new ClientIMP();
		P= new PanierIMP();
		DAv= new DatesVoyageImp();
		RV= new ReservationVoIMP();
		dateAcc= new DateVoyageAccImp();
		panier= new panierImpAc();
		RVA= new ReservationVAccoIMP();
		
	}
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getServletPath();
		System.out.println("path :"+path);
	 if(path.equals("/logout")) {
		HttpSession sess = request.getSession();
		
		//Admin admin = new Admin();
		//sess.setAttribute("clt", admin);
		
		sess.invalidate();
		System.out.println(sess.toString());
		
		request.getRequestDispatcher("kiaalap-master/home_client.jsp").forward(request, response);
		
	 }else {
		doPost(request, response); 
	 }
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
		String path = request.getServletPath();
		System.out.println("path :"+path);
		
/*****************************************************************************************************************************************/
		
		if(path.equals("/ajouterVoyage")) {
			
			String nom_ville = request.getParameter("nom_ville");
			System.out.println("nom vilee : " + nom_ville);
			String nom_hotel = request.getParameter("nom_hotel");
			String date_depart = request.getParameter("date_depart");
			String date_fin = request.getParameter("date_fin");
			System.out.println("nom hotel" + nom_hotel);
			String description_hotel = request.getParameter("description_hotel");
			int prix_hotel = Integer.parseInt(request.getParameter("prix_hotel"));
			System.out.println("prix" + prix_hotel);
			Part image = request.getPart("image_hotel");

			if (image != null) {

				System.out.println(image.getName());
				System.out.println(image.getSize());
				System.out.println(image.getContentType());

				// obtains input stream of the upload file
				inputStream4 = image.getInputStream();
			}

			
			Voyage voyage = new Voyage(nom_ville, nom_hotel, description_hotel, prix_hotel,date_depart,date_fin, inputStream4);
			V.addVoyage(voyage);
			System.out.println("apres l'ajout");
			
			request.getRequestDispatcher("ListeVoyage").forward(request, response);
			
/*****************************************************************************************************************************************/			
		
		}else if(path.equals("/ListeVoyage")){
			
			
			System.out.println("1");
			listVoyage= V.listeVoyage();
			System.out.println("2");
			request.setAttribute("Voyage", listVoyage);
			System.out.println("3");
			request.getRequestDispatcher("ListeVoyage.jsp").forward(request, response);
			System.out.println("4");
			
/*****************************************************************************************************************************************/			
			
		}else if(path.equals("/ListeVoyageClient")){
			System.out.println("1");
			listVoyageClient= V.listeVoyage();
			System.out.println("2");
			request.setAttribute("Voyage", listVoyageClient);
			System.out.println("3");
			request.getRequestDispatcher("kiaalap-master/voyage_details.jsp").forward(request, response);
			System.out.println("4");
			
/*****************************************************************************************************************************************/			
		
		}else if (path.equals("/Authentification")) {
			HttpSession ma_session = request.getSession();

			String name = request.getParameter("Username");
			String password = request.getParameter("Password");
			System.out.println("le mot de passe entre avant hachage est: "+password);
			//////////////////////////////////////////////////
		
			try {
			//md contient la méthode de chiffrement comme 1er argument
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
			}
			
			System.out.println("le mot de passe apres hachage est "+sb.toString());
			
			Admin admin = new Admin(name, password);
			ma_session.setAttribute("clt", admin);
			
			if (LoginDAO.validation(admin,sb.toString())) {
				HttpSession masseion = request.getSession();
				masseion.setAttribute("utilsateur", name);
				this.getServletContext().getRequestDispatcher("/ListeVoyage").forward(request, response);

			} else {
				this.getServletContext().getRequestDispatcher("/loginErr.jsp").forward(request, response);
			}

			}
			catch (NoSuchAlgorithmException e){
			System.err.println("Erreur:"+e.toString());

			}
			
					////////////////////////////////
			
			
/*****************************************************************************************************************************************/			

		}else if (path.equals("/chercherhotel")) {
		System.out.println("en cours ");
		String mc = request.getParameter("nom_ville");
		int id = H.getIdByNomVille(mc);
		HotelParVille mod = new HotelParVille();
		mod.setVille(mc);
		List <metier.entities.Hotel > hotls = H.getHotelParville(id);
		mod.setHotels(hotls);
		request.setAttribute("model", mod);
		
		request.getRequestDispatcher("ajouterVoyage.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/
		
		}else if (path.equals("/ajouterVille")) {
		
		String nom_ville=request.getParameter("nom_ville");
		Ville ville =new Ville(nom_ville);
		VL.addVille(ville);
		System.out.println("apres l'ajout");
		request.getRequestDispatcher("ajouterVille.jsp").forward(request, response); 
		
/*****************************************************************************************************************************************/		
		
		}else if (path.equals("/ajouterActivite")) {
		
		String activite=request.getParameter("nom_activite");
		AC.addActivite(activite);
		System.out.println("apres l'ajout");
		request.getRequestDispatcher("ajouterActivite.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
		}else if (path.equals("/ajouterHotel")) {
			
		String name=request.getParameter("nom_hotel");
		int id_ville=H.getIdByNomVille(request.getParameter("nom_ville"));
		int nbr_etoile=Integer.parseInt(request.getParameter("nbr_etoile"));
		
		Hotel h= new Hotel(name,id_ville,nbr_etoile);
		H.addHotel(h);
		this.getServletContext().getRequestDispatcher("/ajouterHotel.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
		}else if(path.equals("/afficherAllVille")) {
			
		listVille=VL.getAllVille();
		System.out.println(listVille);
		request.setAttribute("model", listVille);  
		request.getRequestDispatcher("ajouterHotel.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
		}else if(path.equals("/afficherAllVilleVoyage")) {
			
		listVille=VL.getAllVille();
		System.out.println(listVille);
		request.setAttribute("model", listVille);
		request.getRequestDispatcher("chercherVille.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
		}else if(path.equals("/afficherAllActiviteVoyage")) {
			
		listActivite=AC.getAllActivite();
		System.out.println(listActivite);
		request.setAttribute("model", listActivite);	
		request.getRequestDispatcher("ajouterVoyageAcc.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
		}else if(path.equals("/ajouterVoyageAcc")) {
		
		String nom_voyage=request.getParameter("nom_voyage");
		System.out.println("nom voyage : "+nom_voyage);
		String nom_guide=request.getParameter("nom_guide");
		String activite=request.getParameter("activite");
		int id_activite = VA.getIdActiviteByNom(activite);
		System.out.println("nom de guide"+nom_guide);
		String description=request.getParameter("description");

		String destination=request.getParameter("destination");
	
		Part image = request.getPart("image");
		
		if (image != null) {

			System.out.println(image.getName());
			System.out.println(image.getSize());
			System.out.println(image.getContentType());

			// obtains input stream of the upload file
			inputStream3 = image.getInputStream();
		}
		voyage_accompagne VV= new voyage_accompagne(nom_voyage, description, nom_guide, id_activite, destination, inputStream3);
		
		VA.addVoyageAcc(VV,id_activite);
		System.out.println("apres l'ajout");
		
		request.getRequestDispatcher("ajouterVoyageAcc.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
			}else if(path.equals("/afficherVoyageAcc")) {

			listVoyageAcc=  VA.get();
			request.setAttribute("book", listVoyageAcc);
			String page = "/testV.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
	
/*****************************************************************************************************************************************/
	
			}else if(path.equals("/chercherParPrix")) {
				
				int prix=Integer.parseInt(request.getParameter("prix_search"));
				System.out.println(prix);
				listVoyageAccPrix=  VA.getVoyageByPrix(prix);
				request.setAttribute("book", listVoyageAccPrix);
				String page = "/affichierVoyageParPrix.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
				requestDispatcher.forward(request, response);
				
/*****************************************************************************************************************************************/				
	
			}else if(path.equals("/chercherParDestination")) {
				
				String destination =request.getParameter("desination_search");
				System.out.println(destination);
				listVoyageAccDest=  VA.getVoyageByDestnation(destination);
				request.setAttribute("book", listVoyageAccDest); 
				String page = "/affichierVoyageParPrix.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
				requestDispatcher.forward(request, response);
				
/*****************************************************************************************************************************************/				
	
			}else if(path.equals("/modifierVoyage.do")) {
		
				System.out.println("en cours ");
				String mc = request.getParameter("nom_ville");
				System.out.println(mc);
				int idd = H.getIdByNomVille(mc);
				HotelParVille mod = new HotelParVille();
				mod.setVille(mc);
				List <metier.entities.Hotel > hotls = H.getHotelParville(idd);
				mod.setHotels(hotls);
				request.setAttribute("model", mod);
		
	
				int id=Integer.parseInt(request.getParameter("idvoyage"));
				Voyage voyage=V.getIdVoyage(id);
				request.setAttribute("e", voyage);
				request.getRequestDispatcher("modifierVoyage.jsp").forward(request, response);
				
/*****************************************************************************************************************************************/				
		
			}else if(path.equals("/modifierVoyage")) {
				
			int id=Integer.parseInt(request.getParameter("id"));
			String hotel=request.getParameter("nom_hotel");
			System.out.println("nouveau hotel :"+hotel);
			int prix=Integer.parseInt(request.getParameter("prix"));
			String description=request.getParameter("description");
			String date_depart = request.getParameter("date_depart");
			String date_fin = request.getParameter("date_fin");
			System.out.println("date depart : "+date_depart+" et date fin : "+date_fin);
			System.out.println(prix);
			Voyage voyage=new Voyage(id,hotel,description,prix,date_depart,date_fin);
			V.updateVoyage(voyage);
			request.getRequestDispatcher("ListeVoyage").forward(request, response);
			
/*****************************************************************************************************************************************/			

			}else if(path.equals("/modifierVoyageAcc.do")) {
		
			listActivite=AC.getAllActivite();
			System.out.println(listActivite);	
			request.setAttribute("model", listActivite);
			int id =Integer.parseInt(request.getParameter("idvoyageAcc"));
			voyage_accompagne v=VA.getIdVoyageAcc(id);
			request.setAttribute("e", v);
			request.getRequestDispatcher("modifierVoyageAcc.jsp").forward(request, response);
			
/*****************************************************************************************************************************************/			
		
			}else if(path.equals("/modifierVoyageAcc")) {
		
			int id=Integer.parseInt(request.getParameter("id"));
			String nom_voyage=request.getParameter("nom_voyage");
			String date_depart=request.getParameter("date_depart");
			String nom_guide=request.getParameter("nom_guide");
			String destination=request.getParameter("destination");
			String description = request.getParameter("description");
	    	String activite=request.getParameter("activite");
	    	int activiteid = VA.getIdActiviteByNom(activite);
			String dure=request.getParameter("dure");
			int prix=Integer.parseInt(request.getParameter("prix"));
			voyage_accompagne v=new voyage_accompagne(id,prix,description,nom_guide,activiteid,destination,dure,nom_voyage,date_depart);
			VA.updateTypeVoyageAcc(v);
			System.out.println("apres modification");
			request.getRequestDispatcher("ListeVoyageAcc").forward(request, response);
			
/*****************************************************************************************************************************************/			
		
			}else if(path.equals("/ListeVoyageAcc")) {
				
			System.out.println("amine1");
			listVoyageAcc2=VA.getAllVoyageAcc();
			System.out.println("2");
			request.setAttribute("hggg", listVoyageAcc2);
			System.out.println("amine");
			request.getRequestDispatcher("listeVoyageAcc.jsp").forward(request, response);		
			
/*****************************************************************************************************************************************/		

			}else if(path.equals("/supprimerVoyage")) {
				
			int id_voyage;
			System.out.println("En cours de suppression");
			id_voyage = Integer.parseInt(request.getParameter("idvoyage"));
			metier.Voyage V = new VoyageImp();
			V.supprimerVoyage(id_voyage);
			System.out.println("voyage supprimer");
			request.getRequestDispatcher("ListeVoyage").forward(request, response);
			
/*****************************************************************************************************************************************/
		
			}else if(path.equals("/supprimerVoyageAcc")) {
				
			int id_voyage;
			System.out.println("En cours de suppression");
			id_voyage = Integer.parseInt(request.getParameter("idvoyage_Accompagne"));
			metier.Voyage_accompagneDAO VA = new Voyage_accompagneImp();
			VA.supprimerVoyageAcc(id_voyage);
			System.out.println("voyage supprimer");
			request.getRequestDispatcher("ListeVoyageAcc").forward(request, response);   
			
/*****************************************************************************************************************************************/			
		
			}else if(path.equals("/afficherVoyageAccClient")) {
 
			listVoyageAccClient=  VA.get();
			System.out.println( listVoyageAccClient.isEmpty());
			request.setAttribute("book", listVoyageAccClient); 
			request.getRequestDispatcher("/kiaalap-master/home_client.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/		
		
			}else if(path.equals("/decouvrirVoyage")) {
	   
			int id =  Integer.parseInt(request.getParameter("idvoyage"));
			System.out.println(id+"id mn decouvrir");
			request.setAttribute("id", id);
			Voyage v = V.decouvrirVoyage(id);
			request.setAttribute("listeDcouvrir", v);
			listeDateVoyage = DV.getDateById(id);
			request.setAttribute("hggg", listeDateVoyage);
			request.getRequestDispatcher("decouvrirVoyage.jsp").forward(request, response);
			
/*****************************************************************************************************************************************/			
	   
			}else if(path.equals("/loginFirst")){ 
				
				 idDateVoyage =  Integer.parseInt(request.getParameter("idDatevoyage"));
				System.out.println(idDateVoyage+" id date voyage mn login first");
				String username = request.getParameter("username");
				String password = request.getParameter("password");	 
				System.out.println(password+" est le mot de passe que vous avez entré");
	
				try {
				//md contient la méthode de chiffrement comme 1er argument
				MessageDigest md = MessageDigest.getInstance("md5");
				byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

				StringBuilder sb = new StringBuilder();
				for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
				}
				
				System.out.println("le mot de passe apres hachage est "+sb.toString());
				Client client = new Client(username, password);	
				 idClient = CL.getIdClient(username, sb.toString()); 
				System.out.println(idClient+" est l id du client");
				 idVoyage = DV.getIdVoyageByIdDateVoyage(idDateVoyage);
				System.out.println(idVoyage+" id voyage");
				
				if(LG.validation(client,sb.toString())) {
					P.addPanier(idDateVoyage,idClient);
					
					/*System.out.println("authentification succes");
					System.out.println("1");
					listVoyagePanier= V.listeVoyage();
					System.out.println("2");
					request.setAttribute("Voyage", listVoyageClient);
					System.out.println("3");*/
					
					request.getRequestDispatcher("monPanier").forward(request, response);
					
				} else {
					this.getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
				}

				}
				catch (NoSuchAlgorithmException e){
				System.err.println("Erreur:"+e.toString());

				}
				
				
/*****************************************************************************************************************************************/			
				   					
			}else if(path.equals("/createAccount")) {
				
				System.out.println("debut de recuperation des donnees");
				String nom=request.getParameter("nomC");
				String prenom=request.getParameter("prenomC");
				int telephone=Integer.parseInt(request.getParameter("telephoneC"));
				String carte_bancaire=request.getParameter("carte_bancaire");
				String CNE=request.getParameter("CNE");
				String adresse= request.getParameter("adresseC");
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				System.out.println("fin de recuperation des donnees");
			
				Client client = new Client(nom, prenom, telephone, CNE, carte_bancaire, adresse, username, password);
				System.out.println("debut dajout");
				if(CL.checkUserExist(username)==true) {
					System.out.println("le client est deja existant");
					request.getRequestDispatcher("registerErreur.jsp").forward(request, response);
					
				}else {
					CL.addClient(client);
					System.out.println("fin dajout");
					response.sendRedirect("http://localhost:8888/agence_voyage_S5/");
				}
				
				
/*****************************************************************************************************************************************/				
				
			}else if(path.equals("/getInformations")) {
				
				int id =  Integer.parseInt(request.getParameter("idDatevoyage"));
				System.out.println(id+"id date voyage mn getInformation");
				request.setAttribute("id", id);
				
				request.getRequestDispatcher("loginC.jsp").forward(request, response);
				
/*****************************************************************************************************************************************/
		
			}else if(path.equals("/ajouterDateVoyage.do")) {
		
				int idV =  Integer.parseInt(request.getParameter("idvoyage"));
				String nomHotel = V.getNomVoyageById(idV);
				request.setAttribute("nomHotel", nomHotel);
				request.setAttribute("idV", idV);
				request.getRequestDispatcher("ajouterDateVoyage.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/
				

		
/*****************************************************************************************************************************************/	
				
			}else if(path.equals("/ajouterDateVoyage")) {
				
				String date_depart = request.getParameter("date_depart");
				int idV = Integer.parseInt(request.getParameter("idV")); 
				String date_fin = request.getParameter("date_fin");
				int prix = Integer.parseInt(request.getParameter("prix"));
				DateVoyage DV = new DateVoyage(idV, date_depart, date_fin, prix);
				DAv.addDateVoyage(DV, idV);
				System.out.println("apres ajout des dates et prix");
				request.getRequestDispatcher("ListeVoyage").forward(request, response);
				
				
		
/*****************************************************************************************************************************************/		
				
			}else if(path.equals("/monPanier")) {
				
				System.out.println(idClient+" id client mn servlet");
				panierClient = P.getAllPanier(idClient);
				request.setAttribute("voyage", panierClient);
				String nom = CL.getnomClient(idClient);
				HttpSession masseion = request.getSession();
				masseion.setAttribute("utilsateur", nom);
				masseion.setAttribute("idClient", idClient);
				masseion.setAttribute("idVoyage", idVoyage);
				masseion.setAttribute("idDateVoyage", idDateVoyage);
				request.getRequestDispatcher("fichePanier.jsp").forward(request, response);
		
/*****************************************************************************************************************************************/
		
			}else if(path.equals("/sendEmail")) {

				String from = request.getParameter("email");
				String passwordE = request.getParameter("password");
				String Subject = request.getParameter("subject");
				String message = request.getParameter("message");
				
				System.out.println(" from : "+from);
				System.out.println(" password : "+passwordE);
				SendEmail Send = new SendEmail();
				Send.SendMail(from, passwordE, Subject, message);
				response.sendRedirect("http://localhost:8083/agence_voyage_S5/");
				
/*****************************************************************************************************************************************/	

			}else if(path.equals("/reserverVoyage")) {
				
				 idClientt =  Integer.parseInt(request.getParameter("idClient"));
				int idVoyage =  Integer.parseInt(request.getParameter("idVoyage"));
				int idDateVoyage =  Integer.parseInt(request.getParameter("idDateVoyage"));
				System.out.println(idClient+" est l id du client");
				System.out.println(idVoyage+" est l id du voyage");
				System.out.println(idDateVoyage+" est l id du date de voyage");
				request.setAttribute("idClient", idClient);
				
				RV.addReservationV(idClient, idVoyage, idDateVoyage);
				System.out.println("apres ajout de reservation");
				request.getRequestDispatcher("checkReservation").forward(request, response);
				
/*****************************************************************************************************************************************/	
			
			}else if(path.equals("/checkReservation")) {
				
						
				String nom = CL.getnomClient(idClient);
				int nbrResV= RV.nbrReservation(idClient);
				HttpSession masseion = request.getSession();
				masseion.setAttribute("utilsateur", nom);
				masseion.setAttribute("idClient", idClient);
				masseion.setAttribute("nbrR", (nbrResV));
				listeReservationVoyage = RV.getAllReservation(idClient);
				listeReservationVoyage.isEmpty();
				request.setAttribute("listeReV", listeReservationVoyage);
				System.out.println("apres avoir envoyer la liste des reservations");
				
				request.getRequestDispatcher("allReservationV.jsp").forward(request, response);
				
/*****************************************************************************************************************************************/
				
			}else if (path.equals("/afficherVoyageAccClient1")) {
				listjdida2 = VA.get();
				System.out.println(listjdida2.isEmpty());
				request.setAttribute("book", listjdida2);
				request.getRequestDispatcher("/kiaalap-master/VoyageAccDetail.jsp").forward(request, response);
				
				
				
				
/*****************************************************************************************************************************************/		
				
			}else if (path.equals("/decouvrirVoyageAcc")) {
				int id=Integer.parseInt(request.getParameter("idVoyageAcc"));
				System.out.println(id+" mn voyage");
				voyage_accompagne v = VA.getIdVoyageAcc(id);
				request.setAttribute("e", v);
				listAccjdida = VA.getDateById(id);
				request.setAttribute("hggg", listAccjdida);
				
				this.getServletContext().getRequestDispatcher("/our-story.jsp").forward(request, response);
				
				
				
				
/*****************************************************************************************************************************************/
				
			}else if(path.equals("/loginFirstAcc")){
				HttpSession ma_session = request.getSession();
				id_date_voyageAcc =  Integer.parseInt(request.getParameter("idDatevoyage"));
				System.out.println(id_date_voyageAcc+" id date voyage mn login first");
				String username = request.getParameter("username");
				String password = request.getParameter("password");	 
				System.out.println(password+" est le mot de passe que vous avez entré");

				try {
				//md contient la méthode de chiffrement comme 1er argument
				MessageDigest md = MessageDigest.getInstance("md5");
				byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

				StringBuilder sb = new StringBuilder();
				for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
				}
				
				System.out.println("le mot de passe apres hachage est "+sb.toString());
				Client client = new Client(username, password);	
				idClient = CL.getIdClient(username, sb.toString()); 
				System.out.println(idClient+" est l id du client");
				//idVoyageAcc = dateVoyageAcc.getIdVoyageByIdDateVoyage(id_date_voyageAcc);
				System.out.println(idVoyageAcc+" id voyage");
				ma_session.setAttribute("clt", client);
				if(LG.validation(client,sb.toString())) {
					panier.ajouterPanier(id_date_voyageAcc,idClient);
					System.out.println("mor lajout f panier acc "+id_date_voyageAcc);
					
					
					request.getRequestDispatcher("monPanier1").forward(request, response);
					
				} else {
					this.getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
				}

				}
				catch (NoSuchAlgorithmException e){
				System.err.println("Erreur:"+e.toString());

				}}else if(path.equals("/getInformationsAcc")) {
					idVoyageAcc = Integer.parseInt(request.getParameter("id_voyageAcc"));
					System.out.println(idVoyageAcc+"id voyageAcc mn getInfoAcc");
					int id =  Integer.parseInt(request.getParameter("idDateVoyageAcc"));
					System.out.println(id+"id date voyage mn getInformation");
					request.setAttribute("id", id);
					
					request.getRequestDispatcher("loginCA.jsp").forward(request, response);
				
		
			
		}else if(path.equals("/ajouterDateVoyageAcc.do")) {

			int idV =  Integer.parseInt(request.getParameter("idvoyageACC"));
			
			String destination = VA.getNomVoyageAccById(idV);
			System.out.println("destination par method : "+destination);
			request.setAttribute("nomV", destination);
			request.setAttribute("idV", idV);
			request.getRequestDispatcher("ajouterDateVoyageAcc.jsp").forward(request, response);
			
			
			
		}else if(path.equals("/ajouterDateVoyageAcc")) {
			
			String date_depart = request.getParameter("date_depart");
			int idV = Integer.parseInt(request.getParameter("idV")); 
			String date_fin = request.getParameter("date_fin");
			int prix = Integer.parseInt(request.getParameter("prix"));
			Date_voyageAcc DV = new Date_voyageAcc (idV, date_depart, date_fin, prix);
			dateAcc.addDateVoyageAcc(DV, idV);
			System.out.println("apres ajout des dates et prix");
			
			request.getRequestDispatcher("ListeVoyageAcc").forward(request, response);
			
		}else if(path.equals("/monPanier1")) {
			
			System.out.println(idClient+" id client mn servlet");
			panierClientAcc = panier.getAllPanier(idClient);
			request.setAttribute("voyage", panierClientAcc);
			String nom = CL.getnomClient(idClient);
			HttpSession masseion = request.getSession();
			masseion.setAttribute("utilsateur", nom);
			masseion.setAttribute("idClient", idClient);
			masseion.setAttribute("idVoyage", idVoyageAcc);
			masseion.setAttribute("idDateVoyage", id_date_voyageAcc);
			request.getRequestDispatcher("fichePanierA.jsp").forward(request, response);
			
			
		}else if(path.equals("/reserverVoyageAcc")) {
			
			idClient =  Integer.parseInt(request.getParameter("idClient"));
			idVoyageAcc =  Integer.parseInt(request.getParameter("idVoyage"));
			id_date_voyageAcc =  Integer.parseInt(request.getParameter("idDateVoyage"));
			System.out.println(idClient+" est l id du client");
			System.out.println(idVoyageAcc+" est l id du voyage");
			System.out.println(id_date_voyageAcc+" est l id du date de voyage");
			request.setAttribute("idClient", idClient);
			
			RVA.addReservationV(idClient, idVoyageAcc, id_date_voyageAcc);
			System.out.println("apres ajout de reservation");
			request.getRequestDispatcher("checkReservationAcc").forward(request, response);
			
			
		}else if(path.equals("/checkReservationAcc")) {
			String nom = CL.getnomClient(idClient);
			int nbrResV= RVA.nbrReservation(idClient);
			HttpSession masseion = request.getSession();
			masseion.setAttribute("utilsateur", nom);
			masseion.setAttribute("idClient", idClient);
			masseion.setAttribute("nbrR", (nbrResV));
			
			listeReservationVoyage = RVA.getAllReservation(idClient);
			listeReservationVoyage.isEmpty();
			request.setAttribute("listeReV", listeReservationVoyage);
			System.out.println("apres avoir envoyer la liste des reservations");
			
			request.getRequestDispatcher("allReservationVA.jsp").forward(request, response);
		
		
		
/*****************************************************************************************************************************************/

			
		}else if(path.equals("/libererReservation")) {
			System.out.println(idVoyageAcc+" est l id de voyage Acc");
			System.out.println(id_date_voyageAcc+" est l id de  date voyage Acc");
			System.out.println(idClient+" est l id du client");
			int idReservation = RVA.idReservation(idVoyageAcc, id_date_voyageAcc, idClient);
			System.out.println(idReservation+" est l id de reservations");
			RVA.annulerReservation(idReservation, id_date_voyageAcc);
			System.out.println("apres liberation de reservation");
			
			response.sendRedirect("http://localhost:8888/agence_voyage_S5/afficherVoyageAccClient1");
			
		
		
		}else if(path.equals("/ReservationAccAdmin")) {
			
			listeReservationACCAd = RVA.getAllReservationAdmin();
			listeReservationACCAd.isEmpty();
			request.setAttribute("listeReVAccAd", listeReservationACCAd);
			System.out.println("apres avoir envoyer la liste des reservations");
			
			request.getRequestDispatcher("reservationAccAdmin.jsp").forward(request, response);
			

			
		}else if(path.equals("/libererReservationV")) {
			System.out.println(idVoyage+" est l id de voyage Acc");
			System.out.println(idDateVoyage+" est l id de  date voyage Acc");
			System.out.println(idClient+" est l id du client");
			int idReservation = RV.idReservation(idVoyage, idDateVoyage, idClient);
			System.out.println(idReservation+" est l id de reservations");
			RV.annulerReservation(idReservation, idDateVoyage);
			System.out.println("apres liberation de reservation");
			
			response.sendRedirect("http://localhost:8083/agence_voyage_S5/ListeVoyageClient");
			

		}else if(path.equals("/ReservationAdmin")) {
			
			listeReservationAd = RV.getAllReservationAdmin();
			listeReservationAd.isEmpty();
			request.setAttribute("listeReVAd", listeReservationAd);
			System.out.println("apres avoir envoyer la liste des reservations");
			
			request.getRequestDispatcher("reservationAdmin.jsp").forward(request, response);
			

			
		}else if(path.equals("/client_facture")) {
			//int dateVoyageAcc=Integer.parseInt(request.getParameter("idDateVoyageAcc"));
			System.out.println(id_date_voyageAcc);
			//int client=Integer.parseInt(request.getParameter("idClient"));
			System.out.println(idClient);
			
			
			Date_voyageAcc date_voyage= dateAcc.getIdDateVoyageAcc(id_date_voyageAcc);
			System.out.println(date_voyage);
			Client c = CL.getVlientById(idClient);
			int nbrPersonne=Integer.parseInt(request.getParameter("nbrPersonne"));
			System.out.println(nbrPersonne);
			//String destination=VA.getNomVoyageAccById(voyageAcc);
			//System.out.println(destination);
			
			
			try {
				response.setContentType("application/pdf");
				DateFormat date = new SimpleDateFormat("yyy-MM-dd_HH:mm:ss");
				String dateCourante = date.format(new java.util.Date());
				String headerkey = "Content-Disposition";
				String headerValue = "attachement;filename=Reçue de paiment :" + dateCourante+ ".pdf";
				 
				response.setHeader(headerkey, headerValue);
				Client_pdf exporter = new Client_pdf();
				exporter.export(response ,date_voyage,c, nbrPersonne);
				
				request.getRequestDispatcher("kiaalap-master/home_client.jsp").forward(request, response);
				
				  
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			
		}else if(path.equals("/loginFirstAccClient")){
			
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");	 
			System.out.println(password+" est le mot de passe que vous avez entré");

			try {
			//md contient la méthode de chiffrement comme 1er argument
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
			}
			
			System.out.println("le mot de passe apres hachage est "+sb.toString());
			Client client = new Client(username, password);	
			idClient = CL.getIdClient(username, sb.toString()); 
			System.out.println(idClient+" est l id du client mn login jdid");
			//idVoyageAcc = dateVoyageAcc.getIdVoyageByIdDateVoyage(id_date_voyageAcc);
			
			if(LG.validation(client,sb.toString())) {
				
				
				
				
				request.getRequestDispatcher("AllReservationAccClient").forward(request, response);
				
			} else {
				this.getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
			}

			}
			catch (NoSuchAlgorithmException e){	
			System.err.println("Erreur:"+e.toString());

			}
			
			
			}else if(path.equals("/AllReservationAccClient")) {
			
			listeReservationACCclient = RVA.getAllReservationAccClient(idClient);
			listeReservationACCclient.isEmpty();
			request.setAttribute("listeReVAccClient", listeReservationACCclient);
			System.out.println("apres avoir envoyer la liste des reservations");	
			
			request.getRequestDispatcher("kiaalap-master/allReservationAccClient.jsp").forward(request, response);
			

}
	}
}