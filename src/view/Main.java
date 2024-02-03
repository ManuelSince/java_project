package view;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dao.ChambreDAO;
import dao.ClientDAO;
import dao.HotelDAO;
import dao.PaiementDAO;
import dao.ReservationDAO;
import dao.SocieteDAO;
import entities.Chambre;
import entities.Client;
import entities.Database;
import entities.Hotel;
import entities.Paiement;
import entities.Reservation;
import entities.Societe;
import tableModels.ReservationCustom;
import tableModels.SocieteCustom;
import tableModels.ChambreCustom;
import tableModels.ClientCustom;
import tableModels.HotelCustom;
import tableModels.PaiementCustom;
import tools.Display;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		Database.Connect();
		int menuUserChoice = -1;
		while(menuUserChoice != 0) {
			menuUserChoice = displayMenu();
			switch(menuUserChoice) {
			  case 0:
			    break;
			  case 1:
				 menuHotels();
			    isMenu();
			    break;
			  case 2:
				menuChambres();
				isMenu();
				break;
			  case 3:
				menuReservations();
				isMenu();
				break;
			  case 4:
				  menuPaiements();
				  isMenu();
				break;
			  case 5:
				  menuSocietes();
				  isMenu();
				break;
			  case 6:
				  menuClients();
				  isMenu();
				break;
			  default:
				  	break;
			}	
		}
	}
	public static int displayMenu() {
		Display.printHeader("Menu de Gestion");
		Display.printWS(
						  "1- Les Hotels \r\n"
						+ "2- Les Chambres \r\n"
						+ "3- Les Reservations \r\n"
						+ "4- Les Paiements \r\n"
						+ "5- Les Societes \r\n"
						+ "6- Les Clients \r\n"
						+ "0- Quitter"
						
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menu", "menu");
	}
	public static void menuHotels() {
		int menuHotelChoice = -1;
		while(menuHotelChoice != 0) {
			menuHotelChoice = displayMenuHotels();
			switch(menuHotelChoice) {
			  case 0:
			    break;
			  case 1:
				listHotels();
			    isMenu();
			    break;
			  case 2:
				listeHotelsWithRooms();
				isMenu();
				break;
			  case 3:
				listHotelsWhithStats();
				isMenu();
				break;
			  case 4:
				modifierHotel();
				isMenu();
				break;
			  case 5:
				ajouterHotel();
				isMenu();
				break;
			  case 6: 
				supprimerHotel();
				isMenu();
				break;
			  case 7:
				rechercherHotel();
				isMenu();
				break;
			  default:
				  	break;
			}	
		}
	}
	public static void menuChambres() {
		int menuChambreChoice = -1;
		while(menuChambreChoice != 0) {
			menuChambreChoice = displayMenuChambres();
			switch(menuChambreChoice) {
			  case 0:
			    break;
			  case 1:
				listChambres();
			    isMenu();
			    break;
			  case 2:
				listChambreWhithStats();
				isMenu();
				break;
			  case 3:
				modifierChambre();
				isMenu();
				break;
			  case 4:
				ajouterChambre();
				isMenu();
				break;
			  case 5: 
				supprimerChambre();
				isMenu();
				break;
			  case 6:
				rechercherChambre();
				isMenu();
				break;
			  default:
				break;
			}	
		}
	}
	public static void menuReservations() {
		int menuReservationChoice = -1;
		while(menuReservationChoice != 0) {
			menuReservationChoice = displayMenuReservations();
			switch(menuReservationChoice) {
			  case 0:
			    break;
			  case 1:
				listReservations();
			    isMenu();
			    break;
			  case 2:
				listReservationsWhithStats();
				isMenu();
				break;
			  case 3:
				modifierReservation();
				isMenu();
				break;
			  case 4:
				ajouterReservation();
				isMenu();
				break;
			  case 5: 
				supprimerReservation();
				isMenu();
				break;
			  default:
				break;
			}	
		}
	}
	public static void menuPaiements() {
		int menuPaiementChoice = -1;
		while(menuPaiementChoice != 0) {
			menuPaiementChoice = displayMenuPaiements();
			switch(menuPaiementChoice) {
			  case 0:
			    break;
			  case 1:
				listPaiements();
			    isMenu();
			    break;
			  case 2:
				modifierPaiement();
				isMenu();
				break;
			  case 3:
				ajouterPaiement();
				isMenu();
				break;
			  case 4: 
				supprimerPaiement();
				isMenu();
				break;
			  default:
				break;
			}	
		}
	}
	public static void menuSocietes() {
		int menuSocieteChoice = -1;
		while(menuSocieteChoice != 0) {
			menuSocieteChoice = displayMenuSocietes();
			switch(menuSocieteChoice) {
			  case 0:
			    break;
			  case 1:
				listSocietes();
			    isMenu();
			    break;
			  case 2:
				modifierSociete();
				isMenu();
				break;
			  case 3:
				ajouterSociete();
				isMenu();
				break;
			  case 4: 
				supprimerSociete();
				isMenu();
				break;
			  case 5: 
				rechercherSociete();
				isMenu();
				break;
			  default:
				break;
			}	
		}
	}
	public static void menuClients() {
		int menuClientChoice = -1;
		while(menuClientChoice != 0) {
			menuClientChoice = displayMenuClients();
			switch(menuClientChoice) {
			  case 0:
			    break;
			  case 1:
				listClients();
			    isMenu();
			    break;
			  case 2:
				modifierClient();
				isMenu();
				break;
			  case 3:
				ajouterClient();
				isMenu();
				break;
			  case 4: 
				supprimerClient();
				isMenu();
				break;
			  case 5: 
				rechercherClient();
				isMenu();
				break;
			  default:
				break;
			}	
		}
	}
	public static int displayMenuHotels() {
		Display.printHeader("Menu des Hotels");
		Display.printWS(
						  "1- Liste des Hotels \r\n"
						+ "2- Liste des hotels avec details des chambres \r\n"
						+ "3- Hotels : données statistiques \r\n"
						+ "4- Modifier un hotel \r\n"
						+ "5- Ajouter un hotel \r\n"
						+ "6- Supprimer un hotel \r\n"
						+ "7- Rechercher un hotel \r\n"
						+ "0- Quitter"
						
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menuSeven", "hotel");
	}
	public static int displayMenuChambres() {
		Display.printHeader("Menu des Chambres");
		Display.printWS(
						  "1- Liste des Chambres \r\n"
						+ "2- Chambres : données statistiques \r\n"
						+ "3- Modifier une chambre \r\n"
						+ "4- Ajouter une chambre \r\n"
						+ "5- Supprimer une chambre \r\n"
						+ "6- Rechercher une chambre \r\n"
						+ "0- Quitter"					
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menu", "chambre");
	}
	public static int displayMenuReservations() {
		Display.printHeader("Menu des Reservations");
		Display.printWS(
						  "1- Liste des Reservations \r\n"
						+ "2- Reservations : données statistiques \r\n"
						+ "3- Modifier une reservation \r\n"
						+ "4- Ajouter une reservation \r\n"
						+ "5- Supprimer une reservation \r\n"
						+ "0- Quitter"			
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menuFive", "reservation");
	}
	public static int displayMenuPaiements() {
		Display.printHeader("Menu des Paiements");
		Display.printWS(
						  "1- Liste des Paiements \r\n"
						+ "2- Modifier un Paiement \r\n"
						+ "3- Ajouter un Paiement \r\n"
						+ "4- Supprimer un Paiement \r\n"
						+ "0- Quitter"			
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menuFour", "paiement");
	}
	public static int displayMenuSocietes() {
		Display.printHeader("Menu des Societes");
		Display.printWS(
						  "1- Liste des Societes \r\n"
						+ "2- Modifier une Societe \r\n"
						+ "3- Ajouter une Societe \r\n"
						+ "4- Supprimer une Societe \r\n"
						+ "4- Rechercher une Societe \r\n"
						+ "0- Quitter"			
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menuFive", "societe");
	}
	public static int displayMenuClients() {
		Display.printHeader("Menu des Clients");
		Display.printWS(
						  "1- Liste des Clients \r\n"
						+ "2- Modifier un Client \r\n"
						+ "3- Ajouter un Client \r\n"
						+ "4- Supprimer un Client \r\n"
						+ "5- Rechercher un Client \r\n"
						+ "0- Quitter"			
			);
			return intInput("Entrez le chiffre de l'action du menu correspondant", "menuFive", "societe");
	}
	public static void listHotels() {
		ArrayList<Hotel> hotels = new HotelDAO().getAll();
		int res = intInput("Voulez-vous un affichage des hotels en :\nversion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "hotel");
		if(res == 1) {
			Display.printTable(new HotelDAO().getAll(), 15, "les hotels");
		}else if(res == 2){
			Display.printTable(new HotelDAO().getAll(), 25, "les hotels", "horizontal");
		} else if(res == 3) {
			int colWidth = 30;
			for(Hotel hotel : hotels) {
				Display.print("");
				Display.print(Display.centerStringContent(colWidth*2,"----- "+  hotel.getNom()+" -----"));
				Display.printSimpleTable("Id", hotel.getId()+"" , colWidth);
				Display.printSimpleTable("Nom", hotel.getNom()  , colWidth);
				Display.printSimpleTable("Adresse", hotel.getAdresse()  , colWidth);
				Display.printSimpleTable("Ville", hotel.getVille()  , colWidth);
				Display.printSimpleTable("Description", hotel.getDescription() , colWidth);
				Display.printSimpleTable("Heure d'arrivé", hotel.getArrivedAt()+"" , colWidth);
				Display.printSimpleTable("Heure de départ", hotel.getLeavingAt()+"" , colWidth);
				Display.printSimpleTable("Parking", Display.parseBooleanProperty(hotel.getParking()  +"", "parking"), colWidth);
				Display.printSimpleTable("Wifi", Display.parseBooleanProperty(hotel.getWifi() +"", "wifi") , colWidth);
				Display.printSimpleTable("Piscine", Display.parseBooleanProperty( hotel.getPiscine() +"", "piscine") , colWidth);
				Display.printSimpleTable("Navette", Display.parseBooleanProperty(hotel.getNavette() +"", "navette") , colWidth);
				Display.printSimpleTable("Animaux", Display.parseBooleanProperty(hotel.getAnimaux() +"", "animaux") , colWidth);
				Display.printSimpleTable("Categorie", Display.parseBooleanProperty(hotel.getCategorie() +"", "categorie") , colWidth);
				Display.printSimpleTable("Siret societe", new SocieteDAO().getById(hotel.getIdSociete()).getSiret() , colWidth);
				Display.printSimpleTable("Nom societe", new SocieteDAO().getById(hotel.getIdSociete()).getNom() , colWidth);
				Display.printSimpleTable("Adresse societe", new SocieteDAO().getById(hotel.getIdSociete()).getAdresse() , colWidth);	
			}	
		}	
	}
	public static void listChambres() {
		ChambreDAO chambreDAO = new ChambreDAO();
		ArrayList<Chambre> chambres = chambreDAO.getAll();
		ArrayList<Hotel> hotels = new HotelDAO().getAll();
		int res = intInput("Voulez-vous un affichage des chambres en :\nversion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "reservation");
		if(res == 1) {
			Display.printTable(chambres, 15, "les chambres");
		} else if(res == 2) {
			Display.printTable(chambres, 25, "les chambres", "horizontal");
		}else if(res == 3) {
			int colWidth = 30;
			ArrayList<ChambreCustom> chambresCustom = new ArrayList<ChambreCustom>();
			for (Hotel hotel : hotels) {
				for(Chambre chambre : chambreDAO.getByHotelId(hotel.getId())) {
					int todayYear = new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate().getYear();
					int nbrReservationsPreviousYear = new ReservationDAO().getReservationsCountByChambre(chambre.getId(), todayYear -1);
					int nbrReservationsCurrentYear = new ReservationDAO().getReservationsCountByChambre(chambre.getId(), todayYear);
					chambresCustom.add(
							new ChambreCustom(
									chambre.getId()+"",
									chambre.getNumero()+"",
									chambre.getSimpleBed()+"",
									chambre.getDoubleBed()+"",
									chambre.getSuperficie()+"",			
									Display.parseBooleanProperty(chambre.getSdbP()  +"", "sdbP"),
									Display.parseBooleanProperty(chambre.getTv()+"", "tv"),
									Display.parseBooleanProperty(chambre.getBalcon()  +"", "balcon"),
									Display.parseBooleanProperty(chambre.getFridge() +"", "fridge") ,
									Display.parseBooleanProperty( chambre.getBaignoire() +"", "baignoire"),
									Display.parseBooleanProperty(chambre.getInsonorisation() +"", "insonorisation"),
									chambre.getPrix() +"",
									nbrReservationsCurrentYear + "",
									nbrReservationsPreviousYear + "",
									hotel.getNom(),
									hotel.getAdresse(),
									Display.parseBooleanProperty(hotel.getCategorie()+"", "categorie")
									)
							);
				}
			}
			Display.printTable(chambresCustom, 25, "Les Chambres");
		}
	}
	public static void listReservations() {
		ClientDAO clientDAO = new ClientDAO();
		ChambreDAO chambreDAO = new ChambreDAO();
		HotelDAO hotelDAO = new HotelDAO();
		PaiementDAO paiementDAO = new PaiementDAO();
		ArrayList<Reservation> reservations = new ReservationDAO().getAll();
		int res = intInput("Voulez-vous un affichage des reservations en :\nversion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "reservation");
		if(res == 1) {
			Display.printTable(reservations, 15, "les reservations");
		} else if(res == 2) {
			Display.printTable(reservations, 25, "les reservations", "horizontal");
		}else if(res == 3) {
			int colWidth = 30;
			ArrayList<ReservationCustom> reservationCustoms = new ArrayList<ReservationCustom>();
			for(Reservation reservation : reservations) {
				Client client = clientDAO.getById(reservation.getIdClient());
				Chambre chambre = chambreDAO.getById(reservation.getIdChambre());
				Hotel hotel = hotelDAO.getById(chambre.getIdHotel());
				ArrayList<Paiement> paiements = paiementDAO.getAllByReservationId(reservation.getId());
				reservationCustoms.add(new ReservationCustom(
						reservation.getId(),
						client.getNom(),
						client.getPrenom(),
						client.getVille(),
						client.getPays(),
						client.getEmail(),
						hotel.getNom(),
						hotel.getAdresse(),
						hotel.getVille(),
						chambre.getNumero(),
						Display.parseBooleanProperty(chambre.getSdbP()+"", "sdbP"), 
						Display.parseBooleanProperty(chambre.getTv()+"", "tv"),
						Display.parseBooleanProperty(chambre.getBalcon()+"", "balcon"),
						Display.parseBooleanProperty(chambre.getFridge()+"", "fridge"),
						Display.parseBooleanProperty(chambre.getBaignoire()+"", "baignoire"),
						Display.parseBooleanProperty(chambre.getInsonorisation()+"", "insonorisation"),
						chambre.getPrix(),
						new PaiementDAO().getSumPaidByReservationId(reservation.getId())+ " / " + chambre.getPrix(),
						new PaiementDAO().getCountPaiementsByReservationId(reservation.getId())
						));
			}
			Display.printTable(reservationCustoms, 30, "Les reservations", "horizontal");
		}
	}
	public static void listPaiements() {
		ClientDAO clientDAO = new ClientDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		PaiementDAO paiementDAO = new PaiementDAO();
		ChambreDAO chambreDAO = new ChambreDAO();
		HotelDAO hotelDAO = new HotelDAO();
		
		int colWidth = 25;
		int res = intInput("Voulez-vous un affichage des paiements en :\nVersion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "reservation");
		if(res == 1) {
			Display.printTable(paiementDAO.getAll(), colWidth, "les paiements");
		} else if(res == 2) {
			Display.printTable(paiementDAO.getAll(), colWidth, "les paiements", "horizontal");
		} else if(res == 3) {
			ArrayList<PaiementCustom> customPaiements = new ArrayList<PaiementCustom>();
			for(Paiement paiement: paiementDAO.getAll()) {	
				Reservation reservation = reservationDAO.getById(paiement.getIdReservation());
				Client client = clientDAO.getById(reservation.getIdClient());
				Chambre chambre = chambreDAO.getById(reservation.getIdChambre());
				Hotel hotel = hotelDAO.getById(chambre.getIdHotel());
				customPaiements.add(
						new PaiementCustom(
								paiement.getId(),
								paiement.getDateP()+"",
								paiement.getMontant()+"",
								chambre.getPrix()+"",
								(chambre.getPrix() - paiement.getMontant()) +"",
								paiement.getMethodeP(),	
								chambre.getNumero(),
								hotel.getNom(),
								hotel.getVille(),
								Display.parseBooleanProperty(hotel.getCategorie()+"", "categorie"),
								client.getPrenom()+" " + client.getNom(),
								client.getTelephone(),
								client.getEmail()
								)
						);
			}
			Display.printTable(customPaiements, colWidth+5, "Les Paiements", "horizontal");
		}
	}
	public static void listSocietes() {
		SocieteDAO societeDAO = new SocieteDAO();
		HotelDAO hotelDAO = new HotelDAO();
		ChambreDAO chambreDAO = new ChambreDAO();
		int colWidth = 25;

		int res = intInput("Voulez-vous un affichage des societes en :\nVersion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "reservation");
		if(res == 1) {
			Display.printTable(societeDAO.getAll(), colWidth, "les societés");
		} else if(res == 2) {
			Display.printTable(societeDAO.getAll(), colWidth, "les societes", "horizontal");
		} else if(res == 3) {
			ArrayList<SocieteCustom> societesCustom = new ArrayList<SocieteCustom>();
			for(Societe societe: societeDAO.getAll()) {
				for(Hotel hotel:hotelDAO.getAllBySocieteId(societe.getId())) {
					societesCustom.add(
							new SocieteCustom(
									societe.getId()+"",
									societe.getSiret()+"",
									societe.getNom()+"",
									societe.getAdresse()+"",
									hotel.getNom()+"",
									hotel.getAdresse()+"",
									hotel.getVille()+"",
									Display.parseBooleanProperty(hotel.getCategorie()+"", "categorie"),
									chambreDAO.getRoomCountByHotelId(hotel.getId())+""
									)
							);
				}
			}
			Display.printTable(societesCustom, colWidth, "les societés");
		}
	}
	public static void listClients() {
		ClientDAO clientDAO = new ClientDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		HotelDAO hotelDAO = new HotelDAO();
		int colWidth= 30;
		ArrayList<ClientCustom> clientsCustom = new ArrayList<ClientCustom>();
		for(Client client:clientDAO.getAll()) {
			int nbrReservations = reservationDAO.getCountByIdClient(client.getId());
			double sumPrice = reservationDAO.getSumPricesByClientId(client.getId());
			double sumPaid = reservationDAO.getSumPaidByIdClient(client.getId());
			double nbrNights = reservationDAO.getSumDaysSpentByIdClient(client.getId());
			int preferredHotel = reservationDAO.getPreferedHotelByIdClient(client.getId());
			Display.print("");	
				clientsCustom.add(new ClientCustom(
						client.getId()+"",
						client.getNom(),
						client.getPrenom(),
						client.getTelephone(),
						client.getSexe(),
						client.getVille(),
						client.getPays(),
						client.getEmail(),
						nbrReservations+"",
						sumPrice+"",
						sumPaid+"",
						nbrNights+"",
						hotelDAO.getById(preferredHotel).getNom(),
						Display.parseBooleanProperty(hotelDAO.getById(preferredHotel).getCategorie()+"", "categorie")
						
						));
		}
		int res = intInput("Voulez-vous un affichage des clients en :\nVersion horizontal (1), vertical (2) ou custom (3) ?", "ternary", "reservation");
		if(res == 1) {
			Display.printTable(clientsCustom, colWidth, "Les clients", "");
		} else if(res == 2) {
			Display.printTable(clientsCustom, colWidth +5, "Les clients", "horizontal");
		}else if(res == 3) {
			Display.printTable(clientsCustom, colWidth +5, "Les clients", "horizontal");	
		}
	}
	public static void listeHotelsWithRooms() {
	
		for(Hotel hotel :new HotelDAO().getAll()) {
			Display.printTable(hotel, 15, hotel.getNom());
			Display.printTable(new ChambreDAO().getByHotelId(hotel.getId()), 15, "chambres du " + hotel.getNom());
		}
	}
	public static void listHotelsWhithStats(){
		HotelDAO hotelDAO = new HotelDAO();
		ChambreDAO chambreDAO = new ChambreDAO();
		SocieteDAO socDAO = new SocieteDAO();
		ArrayList<HotelCustom> hotelsCustom = new ArrayList<HotelCustom>();
		for(Hotel hotel :hotelDAO.getAll()) {
			int roomNumber = chambreDAO.getRoomCountByHotelId(hotel.getId());
			double minPrice = chambreDAO.getMinPriceByHotelId(hotel.getId());
			double maxPrice = chambreDAO.getMaxPriceByHotelId(hotel.getId());
			int countSimpleBed = chambreDAO.getSimpleBedCountByHotelId(hotel.getId());
			int countDoubleBed = chambreDAO.getDoubleBedCountByHotelId(hotel.getId());
			double surfaceAvg = chambreDAO.getAverageRoomSurfaceByHotelId(hotel.getId());
			int todayYear = new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate().getYear();
			int nbrReservationsPreviousYear = new ReservationDAO().getReservationsCountByHotel(hotel.getId(), todayYear -1);
			int nbrReservationsCurrentYear = new ReservationDAO().getReservationsCountByHotel(hotel.getId(), todayYear);
			if(roomNumber != 0) {
				double totalPaid = new ReservationDAO().getSumReservationsPaidByIdHotel(hotel.getId());
				double totalPrice = new ReservationDAO().getSumReservationsTotalPriceByIdHotel(hotel.getId());
				hotelsCustom.add(new HotelCustom(
						hotel.getId(),
						hotel.getNom(),
						hotel.getAdresse(),
						hotel.getVille(),
						hotel.getDescription(),
						roomNumber,
						Display.parseBooleanProperty(hotel.getCategorie()+"", "categorie"),
						surfaceAvg,
						 countSimpleBed,
						 countDoubleBed,
						 minPrice,
						 maxPrice,
						 socDAO.getById(hotel.getIdSociete()).getNom(),
						 socDAO.getById(hotel.getIdSociete()).getAdresse(),
						 socDAO.getById(hotel.getIdSociete()).getSiret(),
						 totalPaid +" / " + totalPrice,
						 nbrReservationsPreviousYear + "",
						 nbrReservationsCurrentYear+ ""
						 
						));
			}
		}
		Display.printTable(hotelsCustom, 30, "Les hotels", "horizontal");
		Display.printHeader("Statistiques géographiques ");
		ArrayList<String> cities = hotelDAO.getCities();
		Display.printSimpleTable("Nombre de villes ", cities.size() + "", 30);
		for(String city: cities) {
			Display.printSimpleTable(city, hotelDAO.getCountByCity(city) + "", 30);
		}
	}
	public static void listChambreWhithStats() {
		ChambreDAO chambreDAO = new ChambreDAO();
		
		int roomNumber = chambreDAO.getRoomCount();
		double minPrice = chambreDAO.getMinPrice();
		double maxPrice = chambreDAO.getMaxPrice();
		int countSimpleBed = chambreDAO.getSimpleBedCount();
		int countDoubleBed = chambreDAO.getDoubleBedCount();
		double surfaceAvg = chambreDAO.getAverageRoomSurface();
		int countSdbP = chambreDAO.getCountSdbP();
		int countTv = chambreDAO.getCountTv();
		int countBalcon = chambreDAO.getCountBalcon();
		int countFridge = chambreDAO.getCountFridge();
		int countBaignoire = chambreDAO.getCountBaignoire();
		int countInsonorise = chambreDAO.getCountInsonorise();
		
		ArrayList<ChambreCustom> chambresCustom = new ArrayList<ChambreCustom>();
		for (Hotel hotel : new HotelDAO().getAll()) {
			for(Chambre chambre : chambreDAO.getByHotelId(hotel.getId())) {
				int todayYear = new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate().getYear();
				int nbrReservationsPreviousYear = new ReservationDAO().getReservationsCountByChambre(chambre.getId(), todayYear -1);
				int nbrReservationsCurrentYear = new ReservationDAO().getReservationsCountByChambre(chambre.getId(), todayYear);
				chambresCustom.add(
						new ChambreCustom(
								chambre.getId()+"",
								chambre.getNumero()+"",
								chambre.getSimpleBed()+"",
								chambre.getDoubleBed()+"",
								chambre.getSuperficie()+"",			
								Display.parseBooleanProperty(chambre.getSdbP()  +"", "sdbP"),
								Display.parseBooleanProperty(chambre.getTv()+"", "tv"),
								Display.parseBooleanProperty(chambre.getBalcon()  +"", "balcon"),
								Display.parseBooleanProperty(chambre.getFridge() +"", "fridge") ,
								Display.parseBooleanProperty( chambre.getBaignoire() +"", "baignoire"),
								Display.parseBooleanProperty(chambre.getInsonorisation() +"", "insonorisation"),
								chambre.getPrix() +"",
								nbrReservationsCurrentYear + "",
								nbrReservationsPreviousYear + "",
								hotel.getNom(),
								hotel.getAdresse(),
								Display.parseBooleanProperty(hotel.getCategorie()+"", "categorie")
								)
						);
			}
		}
		Display.printTable(chambresCustom, 25, "Les Chambres");
		Display.print("");
		Display.print(Display.centerStringContent(30*2, "Statistiques globales sur les chambres du reseau"));
		Display.printSimpleTable("Nombre de chambres", roomNumber + "", 30);
		Display.printSimpleTable("Superficie moyenne", surfaceAvg + "", 30);
		Display.printSimpleTable("Nombre de lits simple", countSimpleBed + "", 30);
		Display.printSimpleTable("Nombre de lits double", countDoubleBed + "", 30);
		Display.printSimpleTable("Prix minimum", minPrice + "", 30);
		Display.printSimpleTable("Prix max", maxPrice + "", 30);
		Display.printSimpleTable("Chambres avec salle de bain", countSdbP + "", 30);
		Display.printSimpleTable("Chambres avec TV plate", countTv + "", 30);
		Display.printSimpleTable("Chambres avec balcon", countBalcon + "", 30);
		Display.printSimpleTable("Chambres avec refrigerateur", countFridge + "", 30);
		Display.printSimpleTable("Chambres avec baignoire", countBaignoire + "", 30);
		Display.printSimpleTable("Chambres insonorise", countInsonorise + "", 30);

	}
	public static void listReservationsWhithStats() {
		ClientDAO clientDAO = new ClientDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		HotelDAO hotelDAO = new HotelDAO();
		ChambreDAO chambreDAO = new ChambreDAO();
		PaiementDAO paiementDAO = new PaiementDAO();
		int colWidth = 30;
		for(Client client : clientDAO.getAll()) {
			if(reservationDAO.getAllByClientId(client.getId()).size() > 0) {
				for(Reservation reservation : reservationDAO.getAllByClientId(client.getId())) {
					Chambre chambre = chambreDAO.getById(reservation.getIdChambre());
					Hotel hotel = hotelDAO.getById(chambre.getIdHotel());
					ArrayList<Paiement> paiements = paiementDAO.getAllByReservationId(reservation.getId());
					Display.print("");
					Display.printSimpleTable("Id reservation", reservation.getId()+"" , colWidth);
					Display.printSimpleTable("Nom Client", client.getNom()+"" , colWidth);
					Display.printSimpleTable("Prenom Client", client.getPrenom()+"" , colWidth);
					Display.printSimpleTable("Ville Client", client.getVille()+"" , colWidth);
					Display.printSimpleTable("Pays Client", client.getPays()+"" , colWidth);
					Display.printSimpleTable("Email Client", client.getEmail()+"" , colWidth);
					Display.printSimpleTable("Nom hotel", hotel.getNom()+"" , colWidth);
					Display.printSimpleTable("Adresse hotel", hotel.getAdresse()+""  , colWidth);
					Display.printSimpleTable("Ville hotel", hotel.getVille()+""  , colWidth);
					Display.printSimpleTable("Chambre reservée", chambre.getNumero()+"" , colWidth);
					Display.printSimpleTable("Salle de bain privée", Display.parseBooleanProperty(chambre.getSdbP()  +"", "sdbP") , colWidth);
					Display.printSimpleTable("Tv", Display.parseBooleanProperty(chambre.getTv()+"", "tv") , colWidth);
					Display.printSimpleTable("Balcon", Display.parseBooleanProperty(chambre.getBalcon()  +"", "balcon"), colWidth);
					Display.printSimpleTable("refrigerateur", Display.parseBooleanProperty(chambre.getFridge() +"", "fridge") , colWidth);
					Display.printSimpleTable("Baignoire", Display.parseBooleanProperty( chambre.getBaignoire() +"", "baignoire") , colWidth);
					Display.printSimpleTable("Insonorisation", Display.parseBooleanProperty(chambre.getInsonorisation() +"", "insonorisation") , colWidth);
					Display.printSimpleTable("Prix de chambre", chambre.getPrix() +"" , colWidth);	
					if(paiements.size() >0)
						Display.printTable(paiements, 20, "Paiement", "horizontal");
					else
						Display.printSimpleTable("Paiements effectués par"+ client.getPrenom() +" " +client.getNom(), paiements.size() +"" , colWidth);
				}
				Display.printSimpleTable("total resa pour " +client.getPrenom() +" " +client.getNom(), reservationDAO.getSumPricesByClientId(client.getId())+"" , colWidth);
				Display.printSimpleTable("montant reglé par "+client.getPrenom() +" " +client.getNom(), paiementDAO.getSumPaidByIdClient(client.getId())+"" , colWidth);
			}		
		}
	}
	public static void ajouterHotel() {
		Display.printHeader("Ajouter un hotel");
		Hotel hotel = new Hotel();
		hotel.setNom(
				stringInput("Veuillez entrer le nom", 1, 100, "nom", "hotel")
				);
		hotel.setAdresse(
				stringInput("Veuillez entrer l'adresse", 5, 100, "adresse", "hotel")
				);
		hotel.setVille(
				stringInput("Veuillez entrer la ville", 5, 100, "ville", "hotel")
				);
		hotel.setDescription(
				stringInput("Veuillez entrer la description", 5, 250, "description", "hotel")
				);
		hotel.setArrivedAt(
				timeInput("heure d'arrivée", "hotel")
				);
		hotel.setLeavingAt(
				timeInput("heure de départ", "hotel")
				);
		hotel.setParking(
				intInput("Veuillez entrer 1 si un parking est à disposition, 0 sinon", "boolean", "hotel")
				);
		hotel.setWifi(
				intInput("Veuillez entrer 1 si le wifi est à disposition, 0 sinon", "boolean", "hotel")
				);
		hotel.setPiscine(
				intInput("Veuillez entrer 1 si une piscine est à disposition, 0 sinon", "boolean", "hotel")
				);
		hotel.setNavette(
				intInput("Veuillez entrer 1 si une navette pour l'aéroport est à disposition, 0 sinon", "boolean", "hotel")
				);
		hotel.setAnimaux(
				intInput("Veuillez entrer 1 si les animaux sont autorisés dans l'hotel, 0 sinon", "boolean", "hotel")
				);
		hotel.setCategorie(
				intInput("Veuillez entrer la catégorie de l'hotel (entre 0 et 5 étoiles) ", "categorie", "hotel")
				);
		listSocietes();
		hotel.setIdSociete(
				intInput("Veuillez entrer l'id de la societe proprietaire ", "id", "societe")
				);
	new HotelDAO().save(hotel);
	}
	public static void ajouterChambre() {
		Display.printHeader("Ajouter une chambre");
		Chambre chambre = new Chambre();
		chambre.setNumero(
				stringInput("Veuillez entrer le numero de chambre", 1, 100, "numero", "chambre")
				);
		chambre.setSimpleBed(
				intInput("Veuillez entrer le nombre de lit simple", "quantite", "chambre")
				);
		chambre.setDoubleBed(
				intInput("Veuillez entrer le nombre de lit simple", "quantite", "chambre")
				);
		chambre.setSuperficie(
				intInput("Veuillez entrer la superficie", "quantite", "chambre")
				);
		chambre.setSdbP(
				intInput("Veuillez entrer 1 si la chambre dispose d'une salle de bain privative, 0 sinon", "boolean", "chambre")
				);
		chambre.setTv(
				intInput("Veuillez entrer 1 si la chambre dispose d'une TV à écran plat, 0 sinon", "boolean", "chambre")
				);
		chambre.setBalcon(
				intInput("Veuillez entrer 1 si la chambre dispose d'un balcon, 0 sinon", "boolean", "chambre")
				);
		chambre.setFridge(
				intInput("Veuillez entrer 1 si la chambre dispose d'un refrigerateur, 0 sinon", "boolean", "chambre")
				);
		chambre.setBaignoire(
				intInput("Veuillez entrer 1 si la chambre dispose d'une baignoire, 0 sinon", "boolean", "chambre")
				);
		chambre.setInsonorisation(
				intInput("Veuillez entrer 1 si la chambre dispose d'une insonorisation, 0 sinon", "boolean", "chambre")
				);
		chambre.setPrix(
				doubleInput("Veuillez entrer le prix de la chambre, 0 sinon", "montant", "chambre")
				);
		listHotelsWhithStats();
		chambre.setIdHotel(
				intInput("Veuillez entrer l'id de l'hotel de la chambre ", "id", "hotel")
				);
		new ChambreDAO().save(chambre);
	}
	public static void ajouterReservation() {
		Display.printHeader("Ajouter une reservation");
		Reservation reservation = new Reservation();
		// choix de la ville
		ArrayList<String> cities = new HotelDAO().getCities();
		for(int i = 1; i <= cities.size(); i++) {
			Display.printSimpleTable(i +"", (cities.get(i-1)), 30);
		}
		int index = 0;
		do {
			index = intInput("Veuillez selectionner la ville par son identifiant", "city", "reservation") - 1;
		}while(!checkArrayIndex(index, cities));
		// choix de l'hotel
		Display.printTable(new HotelDAO().getAllByCity(cities.get(index)), 30, "les hotels de la ville " + cities.get(index));
		int idHotel = intInput("Veuillez choisir un des hotel via son identifiant", "id", "hotel");
		// A partir d'un hotel, proposer via le nombre d'adultes seules et en couple les chambres adéquates 
		int simpleBedNeeds =  intInput("Veuillez entrer le nombre de personnes seules dormant seul", "quantite", "reservation");
		int doubleBedNeeds =  intInput("Veuillez entrer le nombre de couples", "quantite", "reservation");
		int bedNeeds = simpleBedNeeds + (doubleBedNeeds * 2);
		Display.printTable(new ChambreDAO().getByHotelId(idHotel), 30, "les chambres de l'hotel " + new HotelDAO().getById(idHotel).getNom());
		ArrayList<Chambre> selectedRooms = new ArrayList<Chambre>();
		int bedPlaces = 0;
		while(bedPlaces < bedNeeds) {
			int idChambre = intInput("Veuillez choisir une chambre via son identifiant tant que le nbr d'adultes " + bedNeeds + " est superieur aux capacités " + bedPlaces, "id", "chambre");
			selectedRooms.add(new ChambreDAO().getById(idChambre));
			bedPlaces = countBeds(selectedRooms);
		};
		listClients();
		reservation.setIdClient(
				intInput("Veuillez entrer l'id du client","id", "client")
				);
		reservation.setDateA(
				dateInput("Veuillez entrer la date d'arrivee prevue")
				);
		reservation.setDateD(
				dateInput("Veuillez entrer la date de depart prevue")
				);
		
		Display.printHeader("Recapitulatif des reservations ");
		Display.printTable(selectedRooms, 30, "Liste des chambres a reserver");
		if(intInput("Voulez vous réserver ces chambres ? 0 pour Non, 1 pour Oui ", "boolean", "reservation") == 1)
		
		
		for(Chambre chambre : selectedRooms) {
			reservation.setIdChambre(
					chambre.getId()
					);
			reservation.setQte(
					countBeds(chambre)
					);
			new ReservationDAO().save(reservation);
		}
		double total = new ReservationDAO().getSumPricesByClientId(reservation.getIdClient());
		
		Display.printSimpleTable("Nom client", new ClientDAO().getById(reservation.getIdClient()).getNom(), 30);
		Display.printSimpleTable("Prenom client", new ClientDAO().getById(reservation.getIdClient()).getPrenom(), 30);
		Display.printSimpleTable("Montant des reservations", total+"", 30);
	}
	public static void ajouterPaiement() {
		Display.printHeader("Ajouter un paiement");
		PaiementDAO paiementDAO = new PaiementDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		Paiement paiement = new Paiement();
		ChambreDAO chambreDAO = new ChambreDAO();
		listReservations();
		paiement.setIdReservation(
				intInput("Veuillez choisir l'id de la réservation a regler", "id", "reservation")
				);
		Reservation reservation = reservationDAO.getById(paiement.getIdReservation());
		double sumPaid = paiementDAO.getSumPaidByReservationId(paiement.getIdReservation());
		double resaPrice = chambreDAO.getById(reservation.getIdChambre()).getPrix();
		double amount = 0;

		do {
			amount = doubleInput("Veuillez choisir le montant a regler : " + sumPaid + " / " + resaPrice , "montant", "paiement");
			if(amount > (resaPrice - sumPaid)) {
				Display.print("le montant : " + amount + " est superieur au prix de la reservation " + resaPrice +"");
			}
		} while(amount > (resaPrice - sumPaid));
		paiement.setMontant(
				amount
				);
		
		int paiementMethod = intInput("Veuillez preciser la methode de paiement :\n  1- Carte bleue \n  2- Cheque \n  3- Especes", "ternary", "paiement");
		String abreviateMethod = "";
		if(paiementMethod == 1) {
			abreviateMethod = "CB";
		} else if(paiementMethod == 2) {
			abreviateMethod = "CHQ";
		} else if(paiementMethod == 3) {
			abreviateMethod = "ESP";
		}
		paiement.setMethodeP(abreviateMethod);
		paiement.setDateP(
				dateInput("Date du paiement")
				);
		paiementDAO.save(paiement);

	}
	public static void ajouterSociete() {
		Display.printHeader("Ajouter une societe");

		Societe societe = new Societe();
		societe.setSiret(
				stringInput("Veuillez entrez le numero de Siret de la societe", 14, 14, "Siret", "societe")
				);
		societe.setNom(
				stringInput("Veuillez entrez le nom de la societe", 3, 50, "Nom", "societe")
				);
		societe.setAdresse(
				stringInput("Veuillez entrez l'adresse de la societe", 10, 200, "Adresse", "societe")
				);
		new SocieteDAO().save(societe);
		
	}
	public static void ajouterClient() {
		Display.printHeader("Ajouter un client");

		Client client = new Client();
		client.setNom(
				stringInput("Veuillez entrer le nom du client", 3, 50, "Nom", "Client")
				);
		client.setPrenom(
				stringInput("Veuillez entrer le prenom du client", 3, 50, "Prenom", "Client")
				);
		client.setVille(
				stringInput("Veuillez entrer la ville du client", 3, 50, "Ville", "Client")
				);
		client.setAge(
				intInput("Veuillez entrer l'âge du client", "age", "client")
				);
		client.setEmail(
				stringInput("Veuillez entrer l'Email du client", 5, 150, "Email", "Client")
				);
		int sexeChoice = intInput("Veuillez preciser le sexe du client :\n  1- Homme \n  2- Femme \n  3- Autre", "ternary", "client");
		String sexe = "";
		if(sexeChoice == 1) {
			sexe = "Homme";
		} else if(sexeChoice == 2) {
			sexe = "Femme";
		} else if(sexeChoice == 3) {
			sexe = "Autre";
		}
		client.setSexe(
				sexe
				);
		client.setTelephone(
				stringInput("Veuillez entrer le telephone du client", 8, 20, "Telephone", "Client")
				);
		client.setPays(
				stringInput("Veuillez entrer le pays du client", 3, 50, "Pays", "Client")
				);
		new ClientDAO().save(client);
	}
	public static void modifierHotel() {
		Display.printHeader("Modifier un hotel");
		listHotelsWhithStats();
		int hotelId = intInput("Veuillez entrer l'id de l'hotel à modifier ", "id", "hotel");
		//Hotel hotel = new Hotel();
		Hotel hotel = new HotelDAO().getById(hotelId);
		Display.printTable(hotel, 20, "Hotel à modifier");
		hotel.setNom(
				intInput("voulez vous modifier le nom ?\n'" + hotel.getNom() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					stringInput("Veuillez entrer le nom", 1, 100, "nom", "hotel"):
					hotel.getNom()
				);
		hotel.setAdresse(
				intInput("voulez vous modifier l'adresse ?\n'"+ hotel.getAdresse() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					stringInput("Veuillez entrer l'adresse", 5, 100, "adresse", "hotel") :
					hotel.getAdresse()
				);
		hotel.setVille(
				intInput("voulez vous modifier la ville ?\n'"+ hotel.getVille() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
						stringInput("Veuillez entrer la ville", 5, 100, "ville", "hotel") :
						hotel.getVille()
				);
		hotel.setDescription(
				intInput("voulez vous modifier la description ?\n'"+ hotel.getDescription() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					stringInput("Veuillez entrer la description", 5, 250, "description", "hotel") :
					hotel.getDescription()
				);
		hotel.setArrivedAt(
				intInput("voulez vous modifier l'heure d'arrivée ?\n'"+ hotel.getArrivedAt() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					timeInput("heure d'arrivée", "hotel"):
					hotel.getArrivedAt()
				);
		hotel.setLeavingAt(
				intInput("voulez vous modifier l'heure de départ ?\n'"+ hotel.getLeavingAt() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					timeInput("heure de départ", "hotel"):
					hotel.getLeavingAt()	
				);
		hotel.setParking(
				intInput("voulez vous modifier la présence d'un parking ?\n'"+ Display.parseBooleanProperty(hotel.getParking() +"","parking")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer 1 si un parking est à disposition, 0 sinon", "boolean", "hotel"):
					hotel.getParking()
				);
		hotel.setWifi(
				intInput("voulez vous modifier la présence du wifi ?\n'"+ Display.parseBooleanProperty(hotel.getWifi() +"","wifi")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer 1 si le wifi est à disposition, 0 sinon", "boolean", "hotel"):
					hotel.getWifi()
				);
		hotel.setPiscine(
				intInput("voulez vous modifier la présence d'une piscine ?\n'"+ Display.parseBooleanProperty(hotel.getPiscine() +"","piscine")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer 1 si une piscine est à disposition, 0 sinon", "boolean", "hotel"):
					hotel.getPiscine()
				);
		hotel.setNavette(
				intInput("voulez vous modifier la présence d'une navette aéroport ?\n'"+ Display.parseBooleanProperty(hotel.getNavette() +"","navette")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer 1 si une navette pour l'aéroport est à disposition, 0 sinon", "boolean", "hotel"):
					hotel.getNavette()
				);
		hotel.setAnimaux(
				intInput("voulez vous modifier la présence des animaux dans l'hotel ?\n'"+ Display.parseBooleanProperty(hotel.getAnimaux() +"","animaux")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer 1 si les animaux sont autorisés dans l'hotel, 0 sinon", "boolean", "hotel"):
					hotel.getAnimaux()
				);
		hotel.setCategorie(
				intInput("voulez vous modifier la catégorie de l'hotel ?\n'"+ Display.parseBooleanProperty(hotel.getCategorie() +"","categorie")+ "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer la catégorie de l'hotel (entre 0 et 5 étoiles) ", "categorie", "hotel"):
					hotel.getCategorie()
				);
		listSocietes();
		hotel.setIdSociete(
				intInput("voulez vous modifier la societé propriétaire ?\n'"+ hotel.getIdSociete() + "'\nNon (0) Oui (1)", "boolean", "hotel") == 1 ?
					intInput("Veuillez entrer l'id de la societe proprietaire ", "id", "societe"):
					hotel.getIdSociete()
				);
	new HotelDAO().save(hotel);
	}
	public static void modifierChambre() {
		Display.printHeader("Modifier une chambre");
		listChambres();
		int chambreId = intInput("Veuillez entrer l'id de la chambre à modifier ", "id", "chambre");
		Chambre chambre = new ChambreDAO().getById(chambreId);
		Display.printTable(chambre, 20, "Chambre à modifier");	
		chambre.setNumero(
				intInput("voulez vous modifier le numero de la chambre ?\n'"+ chambre.getNumero() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					stringInput("Veuillez entrer le numero de chambre", 1, 100, "numero", "chambre"):
					chambre.getNumero()
				);
		chambre.setSimpleBed(
				intInput("voulez vous modifier le nombre de lit simple ?\n'"+ chambre.getSimpleBed() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer le nombre de lit simple", "quantite", "chambre"):
					chambre.getSimpleBed()
				);
		chambre.setDoubleBed(
				intInput("voulez vous modifier le nombre de lit double ?\n'"+ chambre.getSimpleBed() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer le nombre de lit simple", "quantite", "chambre"):
					chambre.getDoubleBed()
				);
		chambre.setSuperficie(
				intInput("voulez vous modifier la superficie de la chambre ?\n'"+ chambre.getSuperficie() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer la superficie", "quantite", "chambre"):
					chambre.getSuperficie()
				);
		chambre.setSdbP(
				intInput("voulez vous modifier la présence d'une salle de bain privative ?\n'"+ Display.parseBooleanProperty(chambre.getSdbP() +"","sdbP")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'une salle de bain privative, 0 sinon", "boolean", "chambre"):
					chambre.getSdbP()
				);
		chambre.setTv(
				intInput("voulez vous modifier la présence d'une TV à écran plat ?\n'"+ Display.parseBooleanProperty(chambre.getTv() +"","tv")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'une TV à écran plat, 0 sinon", "boolean", "chambre"):
					chambre.getTv()
				);
		chambre.setBalcon(
				intInput("voulez vous modifier la présence d'un balcon ?\n'"+ Display.parseBooleanProperty(chambre.getBalcon() +"","balcon")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'un balcon, 0 sinon", "boolean", "chambre"):
					chambre.getBalcon()
				);
		chambre.setFridge(
				intInput("voulez vous modifier la présence d'un refrigerateur ?\n'"+ Display.parseBooleanProperty(chambre.getFridge() +"","fridge")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'un refrigerateur, 0 sinon", "boolean", "chambre"):
					chambre.getFridge()
				);
		chambre.setBaignoire(
				intInput("voulez vous modifier la présence d'une baignoire ?\n'"+ Display.parseBooleanProperty(chambre.getBaignoire() +"","baignoire")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'une baignoire, 0 sinon", "boolean", "chambre"):
					chambre.getBaignoire()
				);
		chambre.setInsonorisation(
				intInput("voulez vous modifier la présence d'une insonorisation ?\n'"+ Display.parseBooleanProperty(chambre.getInsonorisation() +"","insonorisation")+ "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer 1 si la chambre dispose d'une insonorisation, 0 sinon", "boolean", "chambre"):
					chambre.getInsonorisation()
				);
		chambre.setPrix(
				intInput("voulez vous modifier le prix de la chambre ?\n'"+ chambre.getPrix() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					doubleInput("Veuillez entrer le prix de la chambre, 0 sinon", "montant", "chambre"):
					chambre.getPrix()
				);
		listHotelsWhithStats();
		chambre.setIdHotel(
				intInput("voulez vous modifier l'id de l'hotel ?\n'"+ chambre.getIdHotel() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					intInput("Veuillez entrer l'id de l'hotel de la chambre ", "id", "hotel"):
					chambre.getIdHotel()
				);
		new ChambreDAO().save(chambre);
	}
	public static void modifierReservation(){
		Display.printHeader("Modifier une reservation");
		listReservations();
		Reservation reservation = new ReservationDAO().getById(intInput("Veuillez entrer l'id de la reservation à modifier", "id", "reservation"));
		Chambre chambre = new ChambreDAO().getById(reservation.getIdChambre());
		Client client = new ClientDAO().getById(reservation.getIdClient());
		
		Display.printTable(reservation, 25, "Reservation à modifier");
		Display.printTable(chambre , 25, "Chambre de la reservation id =" + reservation.getId());
		if(intInput("voulez vous modifier l'id de la chambre ?\n'"+ chambre.getId() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1) {
			listChambres();
			reservation.setIdChambre(intInput("Veuillez entre l'id de la chambre", "id", "chambre"));
		}
		if(intInput("voulez vous modifier le client ?\n'"+ client.getPrenom() + " " + client.getNom() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1) {
			listClients();
			reservation.setIdClient(intInput("Veuillez entre l'id du client", "id", "client"));
		}

		reservation.setDateA(
				intInput("voulez vous modifier la date d'arrivee prevue ?\n'"+ reservation.getDateA() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
					dateInput("Veuillez entrer la date d'arrivee prevue"):
					reservation.getDateA()
				);
		reservation.setDateD(
				intInput("voulez vous modifier la date de depart prevue ?\n'"+ reservation.getDateD() + "'\nNon (0) Oui (1)", "boolean", "chambre") == 1 ?
						dateInput("Veuillez entrer la date de depart prevue"):
						reservation.getDateD()
				);
		
		Display.printTable(reservation, 25, "Recapitulatif de la reservation modifiee");
		new ReservationDAO().save(reservation);
	}
	public static void modifierPaiement() {
		Display.printHeader("Modifier un paiement");
		PaiementDAO paiementDAO = new PaiementDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		
		ChambreDAO chambreDAO = new ChambreDAO();
		listPaiements();
		Paiement paiement = paiementDAO.getById(intInput("Veuillez choisir un paiement à modifier", "id", "paiement")) ;
		Display.printTable(paiement, 25, "Paiement à modifier");
		if(intInput("voulez vous modifier l'id de la reservation ?\n'"+ paiement.getIdReservation() + "'\nNon (0) Oui (1)", "boolean", "paiement") == 1) {
			listReservations();
			paiement.setIdReservation(intInput("Veuillez entre l'id de la reservation", "id", "reservation"));
		}
		Reservation reservation = reservationDAO.getById(paiement.getIdReservation());
		
		if(intInput("voulez vous modifier le montant du paiement ?\n'"+ paiement.getIdReservation() + "'\nNon (0) Oui (1)", "boolean", "paiement") == 1) {
			double sumPaid = paiementDAO.getSumPaidByReservationId(paiement.getIdReservation());
			double resaPrice = chambreDAO.getById(reservation.getIdChambre()).getPrix();
			double amount = 0;
			do {
				amount = doubleInput("Veuillez choisir le montant a regler : " + sumPaid + " / " + resaPrice , "montant", "paiement");
				if(amount > (resaPrice - sumPaid)) {
					Display.print("le montant : " + amount + " est superieur au prix de la reservation " + resaPrice +"");
				}
			} while(amount > (resaPrice - sumPaid));
			paiement.setMontant(
					amount
					);
		}
		if(intInput("voulez vous modifier la methode de paiement ?\n'"+ paiement.getIdReservation() + "'\nNon (0) Oui (1)", "boolean", "paiement") == 1) {
			int paiementMethod = intInput("Veuillez preciser la methode de paiement :\n  1- Carte bleue \n  2- Cheque \n  3- Especes", "ternary", "paiement");
			String abreviateMethod = "";
			if(paiementMethod == 1) {
				abreviateMethod = "CB";
			} else if(paiementMethod == 2) {
				abreviateMethod = "CHQ";
			} else if(paiementMethod == 3) {
				abreviateMethod = "ESP";
			}
			paiement.setMethodeP(abreviateMethod);
		}
		if(intInput("voulez vous modifier la date du paiement ?\n'"+ paiement.getIdReservation() + "'\nNon (0) Oui (1)", "boolean", "paiement") == 1) {
			paiement.setDateP(
					dateInput("Date du paiement")
					);
		}
		paiementDAO.save(paiement);
	}
	public static void modifierSociete() {
		Display.printHeader("Modifier un societe");
		listSocietes();
		Societe societe = new SocieteDAO().getById(intInput("Veuillez entrer l'id de la societe à modifier", "id", "societe"));

		societe.setSiret(
				intInput("voulez vous modifier le numero de siret de la societe ?\n'"+ societe.getSiret() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrez le numero de Siret de la societe", 14, 14, "Siret", "societe"):
					societe.getSiret()
				);
		societe.setNom(
				intInput("voulez vous modifier le nom de la societe ?\n'"+ societe.getNom() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrez le nom de la societe", 3, 50, "Nom", "societe"):
					societe.getNom()
				);
		societe.setAdresse(
				intInput("voulez vous modifier l'adresse de la societe ?\n'"+ societe.getAdresse() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrez l'adresse de la societe", 10, 200, "Adresse", "societe"):
					societe.getAdresse()
				);
		new SocieteDAO().save(societe);
	}
	public static void modifierClient() {
		ClientDAO clientDAO = new ClientDAO();
		listClients();
		Client client = clientDAO.getById(intInput("Veuillez entrer l'id du client à modifier", "id", "client"));
		client.setNom(
				intInput("voulez vous modifier le nom du client ?\n'"+ client.getNom() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer le nom du client", 3, 50, "Nom", "Client"):
					client.getNom()
				);
		client.setPrenom(
				intInput("voulez vous modifier le prenom du client ?\n'"+ client.getPrenom() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer le prenom du client", 3, 50, "Prenom", "Client"):
					client.getPrenom()
				);
		client.setVille(
				intInput("voulez vous modifier la ville du client ?\n'"+ client.getVille() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer la ville du client", 3, 50, "Ville", "Client"):
					client.getVille()
				);
		client.setAge(
				intInput("voulez vous modifier l'age du client ?\n'"+ client.getAge() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					intInput("Veuillez entrer l'âge du client", "age", "client"):
					client.getAge()
				);
		client.setEmail(
				intInput("voulez vous modifier l'email du client ?\n'"+ client.getEmail() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer l'Email du client", 5, 150, "Email", "Client"):
					client.getEmail()
				);
		if(intInput("voulez vous modifier le sexe du client ?\n'"+ client.getSexe() + "'\nNon (0) Oui (1)", "boolean", "client") == 1) {
			int sexeChoice = intInput("Veuillez preciser le sexe du client :\n  1- Homme \n  2- Femme \n  3- Autre", "ternary", "client");
			String sexe = "";
			if(sexeChoice == 1) {
				sexe = "Homme";
			} else if(sexeChoice == 2) {
				sexe = "Femme";
			} else if(sexeChoice == 3) {
				sexe = "Autre";
			}
			client.setSexe(
					sexe
					);
		}
		client.setTelephone(
				intInput("voulez vous modifier le telephone du client ?\n'"+ client.getTelephone() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer le telephone du client", 8, 20, "Telephone", "Client"):
					client.getTelephone()
				);
		client.setPays(
				intInput("voulez vous modifier le pays du client ?\n'"+ client.getPays() + "'\nNon (0) Oui (1)", "boolean", "client") == 1 ?
					stringInput("Veuillez entrer le pays du client", 3, 50, "Pays", "Client"):
					client.getPays()
				);
		new ClientDAO().save(client);
	}
	public static void supprimerHotel() {
		Display.printHeader("Supprimer un hotel");
		listHotelsWhithStats();
		int hotelId = intInput("Veuillez entrer l'id de l'hotel à supprimer", "id", "hotel");
		Hotel hotel = new HotelDAO().getById(hotelId);
		Display.printTable(hotel, 15, "Hotel qui sera supprimer");
		for(Chambre chambre :new ChambreDAO().getByHotelId(hotelId)) {
			Display.printTable(chambre, 15, "Chambre de l'hotel "+ hotel.getNom()+ " qui sera supprimer");
			for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
				Display.printTable(reservation, 15, "Reservation qui sera supprimer");
				Display.printTable(new PaiementDAO().getAllByReservationId(reservation.getId()), 15, "Paiement qui sera supprimer");
			}
		}
		int res = intInput("Etes-vous sûr de vouloir effacer cet hotel ? 0 pour Non, 1 pour OUI", "boolean", "hotel");
		if(res == 1) {
			for(Chambre chambre :new ChambreDAO().getByHotelId(hotelId)) {
				for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
					new PaiementDAO().deleteAllByReservationId(reservation.getId());
					new ReservationDAO().deleteById(reservation.getId());
				}
				new ChambreDAO().deleteById(chambre.getId());
			}
			new HotelDAO().deleteById(hotelId);
		}
	}
	public static void supprimerChambre() {
		Display.printHeader("Supprimer une chambre");
		listChambres();
		int chambreId = intInput("Veuillez entrer l'id de la chambre à supprimer", "id", "chambre");
		Chambre chambre = new ChambreDAO().getById(chambreId);
		// affichage des données qui seront supprimées
		Display.printTable(chambre, 15, "Chambre qui sera supprimer");
		int rooms = new ChambreDAO().getRoomCountByHotelId(chambre.getIdHotel());
		if(rooms == 1) {
			Display.printTable(new HotelDAO().getById(chambre.getIdHotel()), 15, "Cet hotel sera supprimer");
		}
		for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
			Display.printTable(reservation, 15, "Reservation qui sera supprimer");
			Display.printTable(new PaiementDAO().getAllByReservationId(reservation.getId()), 15, "Paiement qui sera supprimer");
		}
		
		int res = intInput("Etes-vous sûr de vouloir effacer cette chambre ? 0 pour Non, 1 pour OUI", "boolean", "chambre");
		if(res == 1) {
			// actions de suppression
				for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
					new PaiementDAO().deleteAllByReservationId(reservation.getId());
					new ReservationDAO().deleteById(reservation.getId());
				}
				new ChambreDAO().deleteById(chambre.getId());
				if(rooms == 1) {
					new HotelDAO().deleteById(chambre.getIdHotel());
				}
		}
	}
	public static void supprimerReservation() {
		Display.printHeader("Supprimer une reservation");
		ReservationDAO reservationDAO = new ReservationDAO();
		PaiementDAO paiementDAO = new PaiementDAO();
		listReservations();
		int idReservation = intInput("Veuillez entrer l'id de la reservation a supprimer ", "id", "reservation");
		Reservation reservation = reservationDAO.getById(idReservation);
		Display.printTable(reservation, 25, "Reservation a supprimer");
		ArrayList<Paiement> paiements = paiementDAO.getAllByReservationId(idReservation);
		if(paiements.size()>0) {
			Display.printTable(paiements, 20, "Liste des paiements qui seront supprimés avec la reservation !");
		}

		int res = intInput("Etes-vous sûr de vouloir effacer cette reservation ? 0 pour Non, 1 pour OUI", "boolean", "reservation");
		if(res == 1) {
			paiementDAO.deleteAllByReservationId(idReservation);
			reservationDAO.deleteById(idReservation);
		}
	}
	public static void supprimerPaiement() {
		Display.printHeader("Supprimer un paiement");
		listPaiements();
		int idPaiement = intInput("Veuillez entrer l'id du Paiement à supprimer", "id", "paiement");
		Paiement paiement = new PaiementDAO().getById(idPaiement);
		Display.printTable(paiement, 25, "le paiement a supprimé");
		int res = intInput("Etes-vous sûr de vouloir effacer ce Paiement ? 0 pour Non, 1 pour OUI", "boolean", "paiement");
		if(res == 1) {
			new PaiementDAO().deleteById(idPaiement);
		}
	}
	public static void supprimerSociete() {
		Display.printHeader("Supprimer une societe");
		listSocietes();
		int idSociete = intInput("Veuillez entrer l'id du client à supprimer", "id", "societe");
		Societe societe = new SocieteDAO().getById(idSociete);
		Display.printTable(societe, 25, "la societe a supprimée");
		ArrayList<Hotel> hotels = new HotelDAO().getAllBySocieteId(idSociete);
		Display.printTable(hotels, 25, "Hotels qui seront supprimes", "horizontal");
		for(Hotel hotel:hotels) {
			for(Chambre chambre :new ChambreDAO().getByHotelId(hotel.getId())) {
				Display.printTable(chambre, 15, "Chambre de l'hotel "+ hotel.getNom()+ " qui sera supprimer");
				for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
					Display.printTable(reservation, 15, "Reservation qui sera supprimer");
					Display.printTable(new PaiementDAO().getAllByReservationId(reservation.getId()), 15, "Paiement qui sera supprimer");
				
				}
			}
		}
		int res = intInput("Etes-vous sûr de vouloir effacer cet societe ? 0 pour Non, 1 pour OUI", "boolean", "societe");
		if(res == 1) {
			for(Hotel hotel:hotels) {
				for(Chambre chambre :new ChambreDAO().getByHotelId(hotel.getId())) {
					for(Reservation reservation : new ReservationDAO().getAllByChambreId(chambre.getId())) {
						new PaiementDAO().deleteAllByReservationId(reservation.getId());
						new ReservationDAO().deleteById(reservation.getId());
					}
					new ChambreDAO().deleteById(chambre.getId());
				}
				new HotelDAO().deleteById(hotel.getId());
			}
			new SocieteDAO().deleteById(idSociete);
		}
		
	}
	public static void supprimerClient() {
		Display.printHeader("Supprimer un client");
		listClients();
		int idClient = intInput("Veuillez entrer l'id du client à supprimer", "id", "client");
		Display.printTable(new ClientDAO().getById(idClient), 25, "Client qui sera supprimé");
		Display.printTable(new ReservationDAO().getAllByClientId(idClient), 25, "reservation qui seront supprimés", "horizontal");
		Display.printTable(new PaiementDAO().getAllByClientId(idClient), 25, "Paiements qui seront supprimées");
		int res = intInput("Etes-vous sûr de vouloir effacer ce client ? 0 pour Non, 1 pour OUI", "boolean", "client");
		if(res == 1) {
			new PaiementDAO().deleteAllByClientId(idClient);
			new ReservationDAO().deleteAllByClientId(idClient);
			new ClientDAO().deleteById(idClient);
		}		
	}
	public static void rechercherHotel() {
		Display.printHeader("Rechercher un hotel");
		String search = stringInput("Veuillez entrer votre recherche", 1, 50, "rechercher hotel", "hotel");
		Display.printTable(new HotelDAO().rechercherHotel(search), 25, "resultat de recherche :", "horizontal");

	}
	public static void rechercherChambre() {
		Display.printHeader("Rechercher une chambre");
		String search = stringInput("Veuillez entrer votre recherche (recherche basé sur les champs suivants :Numero de chambre, prix de la chambre, nom de l'hotel, ville de l'hotel)", 1, 50, "rechercher chambre", "chambre");
		Display.printTable(new ChambreDAO().rechercherChambre(search), 25, "resultat de recherche :", "horizontal");
	}
	public static void rechercherSociete() {
		Display.printHeader("Rechercher une societe");
		String search = stringInput("Veuillez entrer votre recherche ", 1, 50, "rechercher societe", "societe");
		Display.printTable(new SocieteDAO().rechercherSociete(search), 25, "resultat de recherche :", "horizontal");
	}
	public static void rechercherClient() {
		Display.printHeader("Rechercher un client");
		String search = stringInput("Veuillez entrer votre recherche :", 1, 50, "rechercher client", "client");
		Display.printTable(new ClientDAO().rechercherClient(search), 25, "resultat de recherche :", "horizontal");
	}
	public static int intInput(String display, String type, String table) {
		String input = "";
		do {
			Display.print(display);
			input = in.nextLine();
		} while(!checkInt(input, type, table));
		return Integer.parseInt(input);
	}
	public static double doubleInput(String display, String type, String table) {
		String input = "";
		do {
			Display.print(display);
			input = in.nextLine();
		} while(!checkDouble(input, type, table));
		return Double.parseDouble(input);
	}
	public static String stringInput(String display, int minLength, int maxLength, String fieldName, String table) {
		String input = "";
		do {
			Display.print(display);
			input = in.nextLine();
			if(input.length() > maxLength) {
				Display.print("Ce champs ["+ fieldName + "] dans [ " + table + " ] n'accepte pas plus de " + maxLength + " charactere(s)");
			} else {
				if(input.length() < minLength) {
					Display.print("Ce champs [ " + fieldName + " ] dans [ " + table +" ] doit avoir au moins "+ minLength+ " charactere(s)");
				}
			}
		} while(input.length() > maxLength || input.length() < minLength);
		return input;
	}
	public static boolean checkInt(String input, String condition, String table) {
		int num;
		try {
			num = Integer.parseInt(input);
			switch(condition) {
			case "id":
				if(num > 0) {
					return isIdExist(num, table)? true: false;
				} else {
					Display.print("l'id de "+ table +" doit être supérieur à zéro");
					return false;
				}
			case "city":
				if(num > 0) {
					return true;
				} else {
					Display.print("l'id de la ville doit être supérieur à zéro");
					return false;
				}
			case "menu":
				if(num < 0 || num > 6) {
					Display.print("les choix du menu sont compris entre 0 et 6");
					return false;
				}
				return true;
			case "menuFour":
				if(num < 0 || num > 4) {
					Display.print("les choix du menu sont compris entre 0 et 4");
					return false;
				}
				return true;
			case "menuFive":
				if(num < 0 || num > 5) {
					Display.print("les choix du menu sont compris entre 0 et 5");
					return false;
				}
				return true;
			case "menuSeven":
				if(num < 0 || num > 7) {
					Display.print("les choix du menu sont compris entre 0 et 7");
					return false;
				}
				return true;
			case "binary":
				if(num == 1 || num == 2) {
					return true;
				} else {
					Display.print("la réponse doit être 1 ou 2");
					return false;
				}
			case "ternary":
				if(num == 1 || num == 2 || num == 3) {
					return true;
				} else {
					Display.print("la réponse doit être 1, 2 ou 3");
					return false;
				}
			case "boolean":
				if(num == 0 || num == 1) {
					return true;
				} else {
					Display.print("la réponse doit être 0 ou 1");
					return false;
				}
			case "age":
				if(num >= 18 && num <= 125) {
					return true;
				} else {
					Display.print("l'age pour " + table + " doit être entre 18 et 125", 0);
					return false;
				}
			case "quantite":
				if(num >= 0) {
					return true;
				} else {
					Display.print("la quantite pour [ " + table + " ] doit être supérieur ou égale à zéro", 0);
					return false;
				}
			case "annee":
				if(num >= 1900 && num <= LocalDate.now().getYear()) {
					return true;
				} else {
					Display.print("l'année pour [ "+ table+ " ] doit etre comprise entre 1900 et " + LocalDate.now().getYear(), 0);
					return false;
				}
			case "mois":
				if(num > 0 && num <= 12) {
					return true;
				} else {
					Display.print("le mois doit etre une valeur entre 1 et 12");
					return false;
				}
			case "jour":
				if(num > 0 && num <= 31) {
					return true;
				} else {
					Display.print("le jour doit etre une valeur entre 1 et 31");
					return false;
				}
			case "heure":
				if(num >= 0 && num <= 23) {
					return true;
				} else {
					Display.print("l'heure doit être comprise entre 0 et 23");
					return false;
				}
			case "minute":
				if(num >= 0 && num <= 59) {
					return true;
				} else {
					Display.print("les minutes doivent etre comprises entre 0 et 59");
					return false;
				}
			case "categorie":
				if(num >= 0 && num <= 5) {
					return true;
				} else {
					Display.print("le nombre d'étoiles d'un hotel soit être compris entre 0 et 5");
					return false;
				}
			default:
				return false;
			}
		}catch(NumberFormatException e) {
			Display.print("Veuillez entrer un nombre");
			return false;
		}
	}	
	public static boolean checkDouble(String input, String condition, String table) {
		double num;
		try {
			num = Double.parseDouble(input);
			switch(condition) {
			case "montant":
				if(num >= 0) {
					return true;
				} else {
					Display.print(condition + " doit être au moins égale à zéro");
					return false;
				}
			default:
				if(num >= 0) {
					return true;
				} else {
					Display.print("le montant pour " + table + " doit être au moins égale à zéro");
					return false;
				}
			}
		}catch(NumberFormatException e) {
			Display.print("Veuillez entrer un nombre");
			return false;
		}
	}
	public static boolean isIdExist(int id, String table) {
		// instanciation de TOUS les dao ici pour vérifier la présence de l'enregistrement via son id
		// return true si l'enregistrement existe
		switch(table) {
			case "hotel":
				if(new HotelDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table );
					return false;
				}
			case "chambre":
				if(new ChambreDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table );
					return false;
				}
			case "client":
				if(new ClientDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table + "s" );
					return false;
				}
			case "societe":
				if(new ClientDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table + "s" );
					return false;
				}
			case "paiement":
				if(new PaiementDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table + "s" );
					return false;
				}
			case "reservation":
				if(new ReservationDAO().getById(id) != null) {
					return true;
				} else {
					Display.print("l'id ne correspond à aucuns " + table + "s" );
					return false;
				}
			default:
				return false;
		}
	}
	public static Date dateInput(String table) {
		Display.print("== Date pour " + table + " : ==");
		String input = "";
		do {
			Display.print("Voulez la date du jour [entrez 1] ou une date antérieur ? [entrez 2] pour " + table);
			input = in.nextLine();
		} while(!checkInt(input, "binary", table));
		if(Integer.parseInt(input) == 1) {
			return new java.sql.Date(Calendar.getInstance().getTime().getTime());
		} else {
			String annee = "", mois = "", jour = "", dateStr = "";
			do {
				do {
					Display.print("Entrez le jour (de 1 à 31) ");
					jour = in.nextLine();
				}while(!checkInt(jour, "jour", table));
				
				do {
					Display.print("Entrez le mois (1 et 12) ");
					mois = in.nextLine();
				}while(!checkInt(mois, "mois", table));
				
				do {
					Display.print("Entrez l'année ( entre 1900 et aujourd'hui ) ");
					annee = in.nextLine();
				}while(!checkInt(annee, "annee", table));
				
				dateStr = annee+ "-" + mois + "-" + jour;
			} while(!checkDateString(dateStr, table));
			return Date.valueOf(annee + "-" + mois + "-" + jour);
		}
	}
	public static Time timeInput(String fieldName, String table) {
		String heures = "", minutes = "", timeStr = "";
		do {
			do {
				Display.print("Entrez l'heure pour " + fieldName + " (de 0 à 23) ");
				heures = in.nextLine();
			}while(!checkInt(heures, "heure", table));
			
			do {
				Display.print("Entrez les minutes pour " + fieldName + " (de 0 et 59) ");
				minutes = in.nextLine();
			}while(!checkInt(minutes, "minute", table));
			
			timeStr = heures+ ":" + minutes + ":00" ;
		} while(!checkTimeString(timeStr, table));
		return  Time.valueOf(heures+ ":" + minutes + ":00");

	}
	public static boolean checkDateString(String input, String table) {
		// @params String input : l'input du scanner nextLine
		// @params String table : La table sur laquelle l'input est demandée
		// return a boolean that try to parse a Date Object, true if it parsed the shit, false otherwise
		try{
			Date.valueOf(input);
			return true;
		}catch(IllegalArgumentException e) {
			Display.print(e.toString());
			Display.print("la date n'est pas correct pour " + table);
			return false;
		}
	}
	public static boolean checkTimeString(String input, String table) {
		// @params String input : l'input du scanner nextLine
		// @params String table : La table sur laquelle l'input est demandée
		// return a boolean that try to parse a Time Object, true if it parsed the shit, false otherwise
		try{
			Time.valueOf(input);
			return true;
		}catch(IllegalArgumentException e) {
			Display.print(e.toString());
			Display.print("l'heure n'est pas correct pour " + table);
			return false;
		}
	}
	public static boolean isBinaryRes(String input) {
		boolean isBinaryRes = false;
		if(checkInt(input, "binary", "")) {
			isBinaryRes = true;
		}
		return isBinaryRes;
	}
	public static boolean isEmpty(int input) {
		return input == 0 ? true: false;
	}
	
	public static boolean isEmpty(double input) {
		return input == 0 ? true: false;
	}
	
	public static boolean isEmpty(String input) {
		return input.length() == 0 ? true: false;
	}
	public static boolean isMenu() {
		if(stringInput("touche entrée pour continuer", 0, 1, "menu", "menu").length() == 0) {
			return true;
		};
		return false;
	}
	// vérifie si une saisie utilisateur est supérieur à un double passé en paramètre
	public static boolean isGreaterThanAmount(String input, double amount) {
		boolean isGreater = true;
		if(checkDouble(input, "montant", "")) {
			if(amount - Double.parseDouble(input) < 0) {
				isGreater = true;
				Display.print("le montant [ "+ input + " ] est superieur au total de la facture :" + amount );
			}else {
				isGreater = false;
			}
			
		}
		return isGreater;
	}
	public static <T> boolean checkArrayIndex(int index, List<T> list) {
		//@params int index : index
		//@parmas list a generic list of Object T
		// check if an index is valid by testing it
		try {
			list.get(index);
			return true;
		}catch(Error e) {
			return false;
		}
	}
	public static int countBeds(List<Chambre> chambres) {
		int count = 0;
		for(Chambre chambre: chambres) {
			count+= chambre.getSimpleBed();
			count+= (chambre.getDoubleBed()*2);
		}
		return count;
	}
	public static int countBeds(Chambre chambre) {
		int count = 0;
		count+= chambre.getSimpleBed();
		count+= chambre.getDoubleBed() * 2;
		return count;
	}
}
