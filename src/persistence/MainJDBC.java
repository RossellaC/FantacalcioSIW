package persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Calciatore;
import model.Composta;
import model.Gioca;
import model.Invito;
import model.Lega;
import model.PartitaReale;
import model.Squadra;
import model.Utente;
import persistence.connect.DAOFactory;
import persistence.connect.UtilDao;
import persistence.dao.CalciatoreDao;
import persistence.dao.CompostaDao;
import persistence.dao.GiocaDao;
import persistence.dao.InvitoDao;
import persistence.dao.LegaDao;
import persistence.dao.PartitaRealeDao;
import persistence.dao.SquadraDao;
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

		Calciatore[] calciatori = { new Calciatore("0001", "Icardi", "Inter", date1, "Attaccante", 35),
				new Calciatore("0002", "HIGUAIN", "Inter", date2, "Attaccante", 36),
				new Calciatore("0003", "INSIGNE", "Inter", date3, "Attaccante", 28),
				new Calciatore("0004", "QUAGLIARELLA", "Inter", date5, "Attaccante", 25),
				new Calciatore("0005", "CALLEJON", "Inter", date6, "Attaccante", 25),
				new Calciatore("0006", "GOMEZ", "Inter", date8, "Attaccante", 24),
				new Calciatore("0007", "KALINIC", "Inter", date10, "Attaccante", 23),
				new Calciatore("0008", "THEREAU", "Napoli", date12, "Attaccante", 20),
				new Calciatore("0009", "Belotti", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0010", "PALACIO", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0011", "DYBALA", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0012", "MANDZUKIC", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0013", "DESTRO", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0014", "IMMOBILE", "Napoli", date13, "Attaccante", 20),
				new Calciatore("0015", "PERICA", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0016", "DEFREL", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0017", "TROTTA", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0018", "MILIK", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0019", "LO FASO", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0020", "SIMEONE", "Bologna", date13, "Attaccante", 20),
				new Calciatore("0021", "ORSOLINI", "Bologna", date13, "Attaccante", 20),

				new Calciatore("0022", "PERISIC", "Lazio", date4, "Centrocampista", 27),
				new Calciatore("0023", "NAINGGOLAN", "Lazio", date7, "Centrocampista", 24),
				new Calciatore("0024", "HAMSIK", "Lazio", date9, "Centrocampista", 23),
				new Calciatore("0025", " VERDI", "Lazio", date11, "Centrocampista", 22),
				new Calciatore("0026", "SAPONARA", "Lazio", date4, "Centrocampista", 27),
				new Calciatore("0027", "PEROTTI", "Lazio", date7, "Centrocampista", 24),
				new Calciatore("0028", "RINCON", "Lazio", date9, "Centrocampista", 23),
				new Calciatore("0029", "BESSA", "Roma", date11, "Centrocampista", 22),
				new Calciatore("0030", "BROZOVIC", "Roma", date4, "Centrocampista", 27),
				new Calciatore("0031", "KHEDIRA", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0032", "STURARO", "Roma", date9, "Centrocampista", 23),
				new Calciatore("0033", "BIGLIA", "Roma", date11, "Centrocampista", 22),
				new Calciatore("0034", "Crecco", "Roma", date4, "Centrocampista", 27),
				new Calciatore("0035", "FELIPE", "Roma", date7, "Centrocampista", 24),
				new Calciatore("0036", "BONAVENTURA", "Crotone", date9, "Centrocampista", 23),
				new Calciatore("0037", "MAURI", "Crotone", date11, "Centrocampista", 22),
				new Calciatore("0038", "ALLAN", "Crotone", date4, "Centrocampista", 27),
				new Calciatore("0039", "DE ROSSI", "Crotone", date7, "Centrocampista", 24),
				new Calciatore("0040", "PJANIC", "Crotone", date9, "Centrocampista", 23),
				new Calciatore("0041", "BASELLI", "Crotone", date11, "Centrocampista", 22),
				new Calciatore("0042", "PELLEGRINI", "Crotone", date4, "Centrocampista", 27),
				new Calciatore("0043", "STROOTMAN", "Udinese", date7, "Centrocampista", 24),
				new Calciatore("0044", "FLORENZI", "Udinese", date9, "Centrocampista", 23),
				new Calciatore("0045", "BIONDINI", "Udinese", date11, "Centrocampista", 22),
				new Calciatore("0046", "GAGLIARDINI", "Udinese", date11, "Centrocampista", 22),

				new Calciatore("0047", "HANDANOVIC", "Udinese", date14, "Portiere", 16),
				new Calciatore("0048", "ALISSON", "Udinese", date15, "Portiere", 16),
				new Calciatore("0049", "Donnarumma", "Udinese", date19, "portiere", 18),
				new Calciatore("0050", "Buffon", "Fiorentina", date19, "portiere", 19),
				new Calciatore("0051", "Sportiello", "Fiorentina", date19, "portiere", 18),
				new Calciatore("0052", "Da Costa", "Fiorentina", date19, "portiere", 16),
				new Calciatore("0053", "Bizzarri", "Fiorentina", date19, "portiere", 17),
				new Calciatore("0054", "Skorupski", "Fiorentina", date19, "portiere", 18),
				new Calciatore("0055", "Sepe", "Fiorentina", date19, "portiere", 20),
				new Calciatore("0056", "Guerrieri", "Fiorentina", date19, "portiere", 22),
				new Calciatore("0057", "Berisha", "Milan", date19, "portiere", 16),
				new Calciatore("0058", "Marchetti", "Milan", date19, "portiere", 20),
				new Calciatore("0059", "Scuffet", "Milan", date19, "portiere", 18),
				new Calciatore("0060", "Coppola", "Milan", date19, "portiere", 19),
				new Calciatore("0061", "Storari", "Milan", date19, "portiere", 23),
				new Calciatore("0062", "Coraz", "Milan", date19, "portiere", 18),
				new Calciatore("0063", "Festa", "Milan", date19, "portiere", 19),

				new Calciatore("0064", "KOLAROV", "Atalanta", date16, "Difensore", 16),
				new Calciatore("0065", "DE VRIJ", "Atalanta", date17, "Difensore", 15),
				new Calciatore("0066", "SKRINIAR", "Atalanta", date18, "Difensore", 15),
				new Calciatore("0067", "Conti", "Atalanta", date16, "Difensore", 16),
				new Calciatore("0068", "Masiello", "Atalanta", date17, "Difensore", 15),
				new Calciatore("0069", "FERRARI", "Atalanta", date18, "Difensore", 15),
				new Calciatore("0070", "Masiello", "Atalanta", date17, "Difensore", 15),
				new Calciatore("0071", "MAIETTA", "Torino", date17, "Difensore", 15),
				new Calciatore("0072", "MASINA", "Torino", date17, "Difensore", 15),
				new Calciatore("0073", "LAURINI", "Torino", date17, "Difensore", 15),
				new Calciatore("0074", "TONELLI", "Torino", date17, "Difensore", 15),
				new Calciatore("0075", "PAVLOVIC", "Torino", date17, "Difensore", 15),
				new Calciatore("0076", "BONUCCI", "Torino", date17, "Difensore", 15),
				new Calciatore("0077", "MIRANDA", "Torino", date17, "Difensore", 15),
				new Calciatore("0078", "BARZAGLI", "Juventus", date17, "Difensore", 15),
				new Calciatore("0079", "RANOCCHIA", "Juventus", date17, "Difensore", 15),
				new Calciatore("0080", "NAGATOMO", "Juventus", date17, "Difensore", 15),
				new Calciatore("0081", "CHIELLINI", "Juventus", date17, "Difensore", 15),
				new Calciatore("0082", "CALABRIA", "Juventus", date17, "Difensore", 15),
				new Calciatore("0083", "DE SCIGLIO", "Juventus", date17, "Difensore", 15),
				new Calciatore("0084", "PALETTA", "Juventus", date17, "Difensore", 15),
				new Calciatore("0085", "ZAPATA", "Milan", date17, "Difensore", 15),
				new Calciatore("0086", "MAGGIO", "Juventus", date17, "Difensore", 15),
				new Calciatore("0087", "ROMAGNOLI", "Torino", date17, "Difensore", 15),
				new Calciatore("0088", "TOROSIDIS", "Fiorentina", date17, "Difensore", 15) };

		for (int i = 0; i < calciatori.length; i++) {
			calciatoreDao.save(calciatori[i]);
		}

		UtenteDao utenteDao = factory.getUtenteDao();

		Utente utente1 = new Utente("giu91", "rossi", "Giuseppe", "Rossi", "rossi@gmail.com");
		Utente utente2 = new Utente("gio87", "bianco", "Giovanni", "Bianco", "g@gmail.com");
		Utente utente3 = new Utente("ciao34", "francy", "Francesco", "Ciao", "ciao@gmail.com");

		utenteDao.save(utente1);
		utenteDao.save(utente2);
		utenteDao.save(utente3);
		
		LegaDao legaDao = factory.getLegaDao();
		Lega[] leghe = { new Lega(0L, 200.0f, "lega1", "descrizione lega1", "rossi@gmail.com") };

		for(Lega l : leghe) {
			legaDao.save(l);
		}
		
		List<Lega> tutteLeghe = legaDao.getAllLega();
		
		Lega legaPresente = tutteLeghe.get(0);
		
		
		Invito[] inviti = { new Invito("rossi@gmail.com", "g@gmail.com", legaPresente.getId(), true),
				new Invito("rossi@gmail.com", "ciao@gmail.com", legaPresente.getId(), true) };
		
		InvitoDao invitoDao = factory.getInvitoDao();
		
		for(Invito i : inviti) {
			invitoDao.save(i);
		}
		
		SquadraDao squadraDao = factory.getSquadraDao();
		Squadra[] squadre = { new Squadra(legaPresente.getId(), "g@gmail.com", "Inter"), new Squadra(legaPresente.getId(), "rossi@gmail.com", "Milan"),
				new Squadra(legaPresente.getId(), "ciao@gmail.com", "Juventus") };

		for(Squadra s : squadre) {
			squadraDao.save(s);
		}
		
		Composta[] composte = { new Composta("0001", legaPresente.getId(), "g@gmail.com"), new Composta("0002", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0003", legaPresente.getId(), "ciao@gmail.com"), new Composta("0004", legaPresente.getId(), "g@gmail.com"),
				new Composta("0005", legaPresente.getId(), "rossi@gmail.com"), new Composta("0006", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0007", legaPresente.getId(), "g@gmail.com"), new Composta("0008", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0009", legaPresente.getId(), "ciao@gmail.com"), new Composta("0010", legaPresente.getId(), "g@gmail.com"),
				new Composta("0011", legaPresente.getId(), "rossi@gmail.com"), new Composta("0012", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0013", legaPresente.getId(), "g@gmail.com"), new Composta("0014", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0015", legaPresente.getId(), "ciao@gmail.com"), new Composta("0016", legaPresente.getId(), "g@gmail.com"),
				new Composta("0017", legaPresente.getId(), "rossi@gmail.com"), new Composta("0018", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0019", legaPresente.getId(), "g@gmail.com"), new Composta("0020", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0021", legaPresente.getId(), "ciao@gmail.com"), new Composta("0022", legaPresente.getId(), "g@gmail.com"),
				new Composta("0023", legaPresente.getId(), "rossi@gmail.com"), new Composta("0024", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0025", legaPresente.getId(), "g@gmail.com"), new Composta("0026", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0027", legaPresente.getId(), "ciao@gmail.com"), new Composta("0028", legaPresente.getId(), "g@gmail.com"),
				new Composta("0029", legaPresente.getId(), "rossi@gmail.com"), new Composta("0030", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0031", legaPresente.getId(), "g@gmail.com"), new Composta("0032", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0033", legaPresente.getId(), "ciao@gmail.com"), new Composta("0034", legaPresente.getId(), "g@gmail.com"),
				new Composta("0035", legaPresente.getId(), "rossi@gmail.com"), new Composta("0036", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0037", legaPresente.getId(), "g@gmail.com"), new Composta("0038", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0039", legaPresente.getId(), "ciao@gmail.com"), new Composta("0040", legaPresente.getId(), "g@gmail.com"),
				new Composta("0041", legaPresente.getId(), "rossi@gmail.com"), new Composta("0042", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0043", legaPresente.getId(), "g@gmail.com"), new Composta("0044", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0045", legaPresente.getId(), "ciao@gmail.com"), new Composta("0046", legaPresente.getId(), "g@gmail.com"),
				new Composta("0047", legaPresente.getId(), "rossi@gmail.com"), new Composta("0048", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0049", legaPresente.getId(), "g@gmail.com"), new Composta("0050", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0051", legaPresente.getId(), "ciao@gmail.com"), new Composta("0052", legaPresente.getId(), "g@gmail.com"),
				new Composta("0053", legaPresente.getId(), "rossi@gmail.com"), new Composta("0054", legaPresente.getId(), "ciao@gmail.com"),
				new Composta("0055", legaPresente.getId(), "g@gmail.com"), new Composta("0056", legaPresente.getId(), "rossi@gmail.com"),
				new Composta("0057", legaPresente.getId(), "ciao@gmail.com"), new Composta("0058", legaPresente.getId(), "g@gmail.com"),
				new Composta("0059", legaPresente.getId(), "rossi@gmail.com"), new Composta("0060", legaPresente.getId(), "ciao@gmail.com") };

		CompostaDao compostaDao = factory.getCompostaDao();
		for(Composta c :composte) {
			compostaDao.save(c);
		}
		
		cal.set(2017, Calendar.OCTOBER, 21);
		Date ddd17 = cal.getTime();

		PartitaReale[] partiteReali = { new PartitaReale(ddd17, "Inter", "Napoli"),
				new PartitaReale(ddd17, "Roma", "Crotone"), new PartitaReale(ddd17, "Bologna", "Lazio"),
				new PartitaReale(ddd17, "Udinese", "Fiorentina"), new PartitaReale(ddd17, "Milan", "Atalanta"),
				new PartitaReale(ddd17, "Torino", "Juventus") };

		PartitaRealeDao partitaRealeDao = factory.getPartitaRealeDAO();

		for (PartitaReale pr : partiteReali) {
			partitaRealeDao.save(pr);
		}

		GiocaDao giocaDao = factory.getGiocaDao();

		Gioca[] gioc = { new Gioca("0001", ddd17, "Inter", "Napoli", 9l),
				new Gioca("0002", ddd17, "Roma", "Crotone", 2l), new Gioca("0003", ddd17, "Bologna", "Lazio", 4l),
				new Gioca("0004", ddd17, "Udinese", "Fiorentina", 6l),
				new Gioca("0005", ddd17, "Milan", "Atalanta", 7l), new Gioca("0006", ddd17, "Torino", "Juventus", 6l),
				new Gioca("0007", ddd17, "Inter", "Napoli", 9l), new Gioca("0008", ddd17, "Roma", "Crotone", 8l),
				new Gioca("0009", ddd17, "Bologna", "Lazio", 10l),
				new Gioca("0010", ddd17, "Udinese", "Fiorentina", 10l),
				new Gioca("0011", ddd17, "Milan", "Atalanta", 10l), new Gioca("0012", ddd17, "Torino", "Juventus", 10l),
				new Gioca("0013", ddd17, "Inter", "Napoli", 10l), new Gioca("0014", ddd17, "Roma", "Crotone", 9l),
				new Gioca("0015", ddd17, "Bologna", "Lazio", 9l), new Gioca("0016", ddd17, "Udinese", "Fiorentina", 9l),
				new Gioca("0017", ddd17, "Milan", "Atalanta", 9l), new Gioca("0018", ddd17, "Torino", "Juventus", 8l),
				new Gioca("0019", ddd17, "Inter", "Napoli", 7l), new Gioca("0020", ddd17, "Roma", "Crotone", 9l),
				new Gioca("0021", ddd17, "Bologna", "Lazio", 9l), new Gioca("0022", ddd17, "Udinese", "Fiorentina", 8l),
				new Gioca("0023", ddd17, "Milan", "Atalanta", 9l), new Gioca("0024", ddd17, "Torino", "Juventus", 8l),
				new Gioca("0025", ddd17, "Inter", "Napoli", 9l), new Gioca("0026", ddd17, "Roma", "Crotone", 6l),
				new Gioca("0027", ddd17, "Bologna", "Lazio", 7l), new Gioca("0028", ddd17, "Udinese", "Fiorentina", 9l),
				new Gioca("0029", ddd17, "Milan", "Atalanta", 8l), new Gioca("0030", ddd17, "Torino", "Juventus", 8l),
				new Gioca("0031", ddd17, "Inter", "Napoli", 10l), new Gioca("0032", ddd17, "Roma", "Crotone", 9l),
				new Gioca("0033", ddd17, "Bologna", "Lazio", 9l), new Gioca("0034", ddd17, "Udinese", "Fiorentina", 9l),
				new Gioca("0035", ddd17, "Milan", "Atalanta", 9l), new Gioca("0036", ddd17, "Torino", "Juventus", 8l),
				new Gioca("0037", ddd17, "Inter", "Napoli", 8l), new Gioca("0038", ddd17, "Roma", "Crotone", 8l),
				new Gioca("0039", ddd17, "Bologna", "Lazio", 8l), new Gioca("0040", ddd17, "Udinese", "Fiorentina", 8l),
				new Gioca("0041", ddd17, "Milan", "Atalanta", 7l), new Gioca("0042", ddd17, "Torino", "Juventus", 7l),
				new Gioca("0043", ddd17, "Inter", "Napoli", 7l), new Gioca("0044", ddd17, "Roma", "Crotone", 7l),
				new Gioca("0045", ddd17, "Bologna", "Lazio", 7l), new Gioca("0046", ddd17, "Udinese", "Fiorentina", 7l),
				new Gioca("0047", ddd17, "Milan", "Atalanta", 6l), new Gioca("0048", ddd17, "Torino", "Juventus", 6l),
				new Gioca("0049", ddd17, "Inter", "Napoli", 6l), new Gioca("0050", ddd17, "Roma", "Crotone", 6l),
				new Gioca("0051", ddd17, "Bologna", "Lazio", 6l), new Gioca("0052", ddd17, "Udinese", "Fiorentina", 8l),
				new Gioca("0053", ddd17, "Milan", "Atalanta", 8l), new Gioca("0054", ddd17, "Torino", "Juventus", 8l),
				new Gioca("0055", ddd17, "Inter", "Napoli", 8l), new Gioca("0056", ddd17, "Roma", "Crotone", 8l),
				new Gioca("0057", ddd17, "Bologna", "Lazio", 8l), new Gioca("0058", ddd17, "Udinese", "Fiorentina", 9l),
				new Gioca("0059", ddd17, "Milan", "Atalanta", 6l), new Gioca("0060", ddd17, "Torino", "Juventus", 5l),
				new Gioca("0061", ddd17, "Inter", "Napoli", 4l), new Gioca("0062", ddd17, "Roma", "Crotone", 5l),
				new Gioca("0063", ddd17, "Bologna", "Lazio", 8l), new Gioca("0064", ddd17, "Udinese", "Fiorentina", 8l),
				new Gioca("0065", ddd17, "Milan", "Atalanta", 7l), new Gioca("0066", ddd17, "Torino", "Juventus", 5l),
				new Gioca("0067", ddd17, "Inter", "Napoli", 9l), new Gioca("0068", ddd17, "Roma", "Crotone", 5l),
				new Gioca("0069", ddd17, "Bologna", "Lazio", 5l), new Gioca("0070", ddd17, "Udinese", "Fiorentina", 8l),
				new Gioca("0071", ddd17, "Milan", "Atalanta", 7l), new Gioca("0072", ddd17, "Torino", "Juventus", 7l),
				new Gioca("0073", ddd17, "Inter", "Napoli", 8l), new Gioca("0074", ddd17, "Roma", "Crotone", 7l),
				new Gioca("0075", ddd17, "Bologna", "Lazio", 7l), new Gioca("0076", ddd17, "Udinese", "Fiorentina", 7l),
				new Gioca("0077", ddd17, "Milan", "Atalanta", 7l), new Gioca("0078", ddd17, "Torino", "Juventus", 7l),
				new Gioca("0079", ddd17, "Inter", "Napoli", 6l), new Gioca("0080", ddd17, "Roma", "Crotone", 6l),
				new Gioca("0081", ddd17, "Bologna", "Lazio", 6l), new Gioca("0082", ddd17, "Udinese", "Fiorentina", 6l),
				new Gioca("0083", ddd17, "Milan", "Atalanta", 6l), new Gioca("0084", ddd17, "Torino", "Juventus", 6l),
				new Gioca("0085", ddd17, "Inter", "Napoli", 6l), new Gioca("0086", ddd17, "Roma", "Crotone", 7l),
				new Gioca("0087", ddd17, "Bologna", "Lazio", 8l),
				new Gioca("0088", ddd17, "Udinese", "Fiorentina", 10l) };

		for (Gioca g : gioc) {
			giocaDao.save(g);
		}
		System.out.println("Elenco calciatori");
		for (Calciatore c : calciatoreDao.findAll()) {
			System.out.println(c);
		}

		

	}
}
