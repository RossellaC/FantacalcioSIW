package persistence;

import java.util.Calendar;
import java.util.Date;

import model.Calciatore;
import model.Utente;
import persistence.connect.DAOFactory;
import persistence.connect.UtilDao;
import persistence.dao.CalciatoreDao;
import persistence.dao.UtenteDao;

public class MainJDBC {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(1993, Calendar.FEBRUARY, 19); // 19 febbraio 1993
		Date date1 = cal.getTime();

		cal.set(1987, Calendar.DECEMBER, 10); // 10 dicembre 1987
		Date date2 = cal.getTime();

		cal.set(1991, Calendar.JUNE, 4); // 4 giugno 1991
		Date date3 = cal.getTime();

		cal.set(1989, Calendar.FEBRUARY, 2); // 2 febbraio 1989
		Date date4 = cal.getTime();

		cal.set(1983, Calendar.JANUARY, 31); // 31 gennaio 1983
		Date date5 = cal.getTime();

		cal.set(1987, Calendar.FEBRUARY, 11); // 11 febbraio 1987
		Date date6 = cal.getTime();

		cal.set(1988, Calendar.MAY, 4); // 4 maggio 1988
		Date date7 = cal.getTime();

		cal.set(1988, Calendar.FEBRUARY, 15); // 15 fenbbraio 1988
		Date date8 = cal.getTime();

		cal.set(1987, Calendar.JULY, 27); // 27 luglio 1987
		Date date9 = cal.getTime();

		cal.set(1988, Calendar.JANUARY, 5); // 5 gennaio 1988
		Date date10 = cal.getTime();

		cal.set(1992, Calendar.JULY, 12); // 12 luglio 1992
		Date date11 = cal.getTime();

		cal.set(1983, Calendar.APRIL, 24); // 24 aprile 1983
		Date date12 = cal.getTime();

		cal.set(1990, Calendar.JANUARY, 4); // 4 gennaio 1990
		Date date13 = cal.getTime();

		cal.set(1984, Calendar.JULY, 14); // 14 luglio 1984
		Date date14 = cal.getTime();

		cal.set(1992, Calendar.OCTOBER, 2); // 2 ottobre 1992
		Date date15 = cal.getTime();

		cal.set(1985, Calendar.NOVEMBER, 10); // 10 novembre 1985
		Date date16 = cal.getTime();

		cal.set(1992, Calendar.FEBRUARY, 5); // 5 febbraio 1992
		Date date17 = cal.getTime();

		cal.set(1995, Calendar.FEBRUARY, 11); // 11 febbraio 1995
		Date date18 = cal.getTime();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();

		util.createDatabase();

		// FactoryUtenteClient client= new FactoryUtenteClient();
		// AbstractUtenteFactory utenteFactory=
		// client.getFactory(Genere.UTENTE);
		// Utente utente= utenteFactory.getUtente();
		// System.out.println("creato " + utente.getClass());

		CalciatoreDao calciatoreDao = factory.getCalciatoreDAO();

		Calciatore calciatore1 = new Calciatore("0001", "Icardi", "Inter", date1, "Attaccante", 35);
		Calciatore calciatore2 = new Calciatore("0002", "HIGUAIN", "Juventus", date2, "Attaccante", 36);
		Calciatore calciatore3 = new Calciatore("0003", "INSIGNE", "Napoli", date3, "Attaccante", 28);
		Calciatore calciatore4 = new Calciatore("0004", "PERISIC", "Inter", date4, "Centrocampista", 27);
		Calciatore calciatore5 = new Calciatore("0005", "QUAGLIARELLA", "Sampdoria", date5, "Attaccante", 25);
		Calciatore calciatore6 = new Calciatore("0006", "CALLEJON", "Napoli", date6, "Attaccante", 25);
		Calciatore calciatore7 = new Calciatore("0007", "NAINGGOLAN", "Roma", date7, "Centrocampista", 24);
		Calciatore calciatore8 = new Calciatore("0008", "GOMEZ", " Atalanta", date8, "Attaccante", 24);
		Calciatore calciatore9 = new Calciatore("0009", "HAMSIK", "Napoli", date9, "Centrocampista", 23);
		Calciatore calciatore10 = new Calciatore("0010", "KALINIC", "Milan", date10, "Attaccante", 23);
		Calciatore calciatore11 = new Calciatore("0011", " VERDI", " Bologna", date11, "Centrocampista", 22);
		Calciatore calciatore12 = new Calciatore("0012", "THEREAU", " Fiorentina", date12, "Attaccante", 20);
		Calciatore calciatore13 = new Calciatore("0013", "IAGO FALQUE", "Torino", date13, "Attaccante", 20);
		Calciatore calciatore14 = new Calciatore("0014", "HANDANOVIC", "Inter", date14, "Portiere", 16);
		Calciatore calciatore15 = new Calciatore("0015", "ALISSON", "Roma", date15, "Portiere", 16);
		Calciatore calciatore16 = new Calciatore("0016", "KOLAROV", "Roma", date16, "Difensore", 16);
		Calciatore calciatore17 = new Calciatore("0017", "DE VRIJ", "Lazio", date17, "Difensore", 15);
		Calciatore calciatore18 = new Calciatore("0018", "SKRINIAR", "Inter", date18, "Difensore", 15);

		UtenteDao utenteDao = factory.getUtenteDao();

		Utente utente1 = new Utente("giuseppe", "rossi", "dsf", "kdsjfhs", "fksjdh");
		Utente utente2 = new Utente("nik", "1234", "nicola", "bianchi", "g@gmail.com");

		calciatoreDao.save(calciatore1);
		calciatoreDao.save(calciatore2);
		calciatoreDao.save(calciatore3);
		calciatoreDao.save(calciatore4);
		calciatoreDao.save(calciatore5);
		calciatoreDao.save(calciatore6);
		calciatoreDao.save(calciatore7);
		calciatoreDao.save(calciatore8);
		calciatoreDao.save(calciatore9);
		calciatoreDao.save(calciatore10);
		calciatoreDao.save(calciatore11);
		calciatoreDao.save(calciatore12);
		calciatoreDao.save(calciatore13);
		calciatoreDao.save(calciatore14);
		calciatoreDao.save(calciatore15);
		calciatoreDao.save(calciatore16);
		calciatoreDao.save(calciatore17);
		calciatoreDao.save(calciatore18);
		System.out.println("Elenco calciatori");
		for (Calciatore c : calciatoreDao.findAll()) {
			System.out.println(c);
		}

		utenteDao.save(utente1);
		utenteDao.save(utente2);

	}
}
