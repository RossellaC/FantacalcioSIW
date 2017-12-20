package persistence;

import java.util.Calendar;
import java.util.Date;

import model.Calciatore;
import persistence.connect.DAOFactory;
import persistence.connect.UtilDao;
import persistence.dao.CalciatoreDao;

public class MainJDBC {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(1993, Calendar.FEBRUARY, 19); // 19 febbraio 1993
		Date date1 = cal.getTime();
		

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();
		
		util.createDatabase();
		
		CalciatoreDao calciatoreDao = factory.getCalciatoreDAO();

		Calciatore calciatore1 = new Calciatore("0001","Icardi","Inter",date1,"Attaccante",35);
		
		
		
		
		calciatoreDao.save(calciatore1);
		
		

	
		System.out.println("Elenco calciatori");
		for(Calciatore c : calciatoreDao.findAll()) {
			System.out.println(c);
		}	
			
	}
}
