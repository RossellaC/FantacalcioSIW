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

		cal.set(1995, Calendar.FEBRUARY, 11); // 11 febbraio 1995
		Date date19 = cal.getTime();

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

		Calciatore[] calciatori = { 
				new Calciatore("0001", "Icardi", "Inter", date1, "Attaccante", 35),
				new Calciatore("0002", "HIGUAIN", "Juventus", date2, "Attaccante", 36),
				new Calciatore("0003", "INSIGNE", "Napoli", date3, "Attaccante", 28),
				new Calciatore("0004", "QUAGLIARELLA", "Sampdoria", date5, "Attaccante", 25),
				new Calciatore("0005", "CALLEJON", "Napoli", date6, "Attaccante", 25),
				new Calciatore("0006", "GOMEZ", " Atalanta", date8, "Attaccante", 24),
				new Calciatore("0007", "KALINIC", "Milan", date10, "Attaccante", 23),
				new Calciatore("0008", "THEREAU", " Fiorentina", date12, "Attaccante", 20),
				new Calciatore("0009", "Belotti", "Torino", date13, "Attaccante", 20),
				new Calciatore("0010", "PALACIO", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0011", "DYBALA", "Juventus", date13, "Attaccante", 20),
				new Calciatore("0012", "MANDZUKIC", "Juventus", date13, "Attaccante", 20),
				new Calciatore("0013", "DESTRO", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0014", "IMMOBILE", "Lazio", date13, "Attaccante", 20),
				new Calciatore("0015", "PERICA", "Udinese", date13, "Attaccante", 20),
				new Calciatore("0016", "DEFREL", "Roma", date13, "Attaccante", 20),
				new Calciatore("0017", "TROTTA", "Crotone", date13, "Attaccante", 20),
				new Calciatore("0018", "MILIK", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0019", "LO FASO", "Fiorentina", date13, "Attaccante", 20),
				new Calciatore("0020", "SIMEONE", "Fiorentina", date13, "Attaccante", 20),
				new Calciatore("0021", "ORSOLINI", "Atalanta", date13, "Attaccante", 20),

				new Calciatore("0022", "PERISIC", "Inter", date4, "Centrocampista", 27),
				new Calciatore("0023", "NAINGGOLAN", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0024", "HAMSIK", "Napoli", date9, "Centrocampista", 23),
				new Calciatore("0025", " VERDI", " Bologna", date11, "Centrocampista", 22),
				new Calciatore("0026", "SAPONARA", "FIORENTINA", date4, "Centrocampista", 27),
				new Calciatore("0027", "PEROTTI", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0028", "RINCON", "Torino", date9, "Centrocampista", 23),
				new Calciatore("0029", "BESSA", "Verona", date11, "Centrocampista", 22),
				new Calciatore("0030", "BROZOVIC", "Inter", date4, "Centrocampista", 27),
				new Calciatore("0031", "KHEDIRA", "Juventus", date7, "Centrocampista", 24),
				new Calciatore("0032", "STURARO", "Juventus", date9, "Centrocampista", 23),
				new Calciatore("0033", "BIGLIA", "Milan", date11, "Centrocampista", 22),
				new Calciatore("0034", "Crecco", "Lazio", date4, "Centrocampista", 27),
				new Calciatore("0035", "FELIPE", "Lazio", date7, "Centrocampista", 24),
				new Calciatore("0036", "BONAVENTURA", "Milan", date9, "Centrocampista", 23),
				new Calciatore("0037", "MAURI", "Milan", date11, "Centrocampista", 22),
				new Calciatore("0038", "ALLAN", "Napoli", date4, "Centrocampista", 27),
				new Calciatore("0039", "DE ROSSI", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0040", "PJANIC", "Napoli", date9, "Centrocampista", 23),
				new Calciatore("0041", "BASELLI", "Torino", date11, "Centrocampista", 22),
				new Calciatore("0042", "PELLEGRINI", "Roma", date4, "Centrocampista", 27),
				new Calciatore("0043", "STROOTMAN", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0044", "FLORENZI", "Roma", date9, "Centrocampista", 23),
				new Calciatore("0045", "BIONDINI", "Sassuolo", date11, "Centrocampista", 22),
				new Calciatore("0046", "GAGLIARDINI", "Inter", date11, "Centrocampista", 22),

				new Calciatore("0047", "HANDANOVIC", "Inter", date14, "Portiere", 16),
				new Calciatore("0048", "ALISSON", "Roma", date15, "Portiere", 16),
				new Calciatore("0049", "Donnarumma", "Milan", date19, "portiere", 18),
				new Calciatore("0050", "Buffon", "Juventus", date19, "portiere", 19),
				new Calciatore("0051", "Sportiello", "Fiorentina", date19, "portiere", 18),
				new Calciatore("0052", "Da Costa", "Bologna", date19, "portiere", 16),
				new Calciatore("0053", "Bizzarri", "Udinese", date19, "portiere", 17),
				new Calciatore("0054", "Skorupski", "Roma", date19, "portiere", 18),
				new Calciatore("0055", "Sepe", "Napoli", date19, "portiere", 20),
				new Calciatore("0056", "Guerrieri", "Lazio", date19, "portiere", 22),
				new Calciatore("0057", "Berisha", "Atalanta", date19, "portiere", 16),
				new Calciatore("0058", "Marchetti", "Lazio", date19, "portiere", 20),
				new Calciatore("0059", "Scuffet", "Udinese", date19, "portiere", 18),
				new Calciatore("0060", "Coppola", "Verona", date19, "portiere", 19),
				new Calciatore("0061", "Storari", "Milan", date19, "portiere", 23),
				new Calciatore("0062", "Coraz", "Crotone", date19, "portiere", 18),
				new Calciatore("0063", "Festa", "Crotone", date19, "portiere", 19),

				new Calciatore("0064", "KOLAROV", "Roma", date16, "Difensore", 16),
				new Calciatore("0065", "DE VRIJ", "Lazio", date17, "Difensore", 15),
				new Calciatore("0066", "SKRINIAR", "Inter", date18, "Difensore", 15),
				new Calciatore("0067", "Conti", "MILAN", date16, "Difensore", 16),
				new Calciatore("0068", "Masiello", "ATALANTA", date17, "Difensore", 15),
				new Calciatore("0069", "FERRARI", "VERONA", date18, "Difensore", 15),
				new Calciatore("0070", "Masiello", "ATALANTA", date17, "Difensore", 15),
				new Calciatore("0071", "MAIETTA", "BOLOGNA", date17, "Difensore", 15),
				new Calciatore("0072", "MASINA", "BOLOGNA", date17, "Difensore", 15),
				new Calciatore("0073", "LAURINI", "FIORENTINA", date17, "Difensore", 15),
				new Calciatore("0074", "TONELLI", "NAPOLI", date17, "Difensore", 15),
				new Calciatore("0075", "PAVLOVIC", "ATALANTA", date17, "Difensore", 15),
				new Calciatore("0076", "BONUCCI", "MILAN", date17, "Difensore", 15),
				new Calciatore("0077", "MIRANDA", "INTER", date17, "Difensore", 15),
				new Calciatore("0078", "BARZAGLI", "JUVENTUS", date17, "Difensore", 15),
				new Calciatore("0079", "RANOCCHIA", "INTER", date17, "Difensore", 15),
				new Calciatore("0080", "NAGATOMO", "INTER", date17, "Difensore", 15),
				new Calciatore("0081", "CHIELLINI", "JUVENTUS", date17, "Difensore", 15),
				new Calciatore("0082", "CALABRIA", "Milan", date17, "Difensore", 15),
				new Calciatore("0083", "DE SCIGLIO", "JUVENTUS", date17, "Difensore", 15),
				new Calciatore("0084", "PALETTA", "Milan", date17, "Difensore", 15),
				new Calciatore("0085", "ZAPATA", "Milan", date17, "Difensore", 15),
				new Calciatore("0086", "MAGGIO", "NAPOLI", date17, "Difensore", 15),
				new Calciatore("0087", "ROMAGNOLI", "MILAN", date17, "Difensore", 15),
				new Calciatore("0088", "TOROSIDIS", "BOLOGNA", date17, "Difensore", 15)};

		UtenteDao utenteDao = factory.getUtenteDao();

		Utente utente1 = new Utente("giuseppe", "rossi", "dsf", "kdsjfhs", "fksjdh");
		Utente utente2 = new Utente("nik", "1234", "nicola", "bianchi", "g@gmail.com");

		for (int i = 0; i < calciatori.length; i++) {
			calciatoreDao.save(calciatori[i]);
		}
		System.out.println("Elenco calciatori");
		for (Calciatore c : calciatoreDao.findAll()) {
			System.out.println(c);
		}

		utenteDao.save(utente1);
		utenteDao.save(utente2);

	}
}
