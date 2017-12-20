package persistence.connect;

import persistence.dao.CalciatoreDao;

public abstract class DAOFactory {

	
	public static final int HSQLDB = 1;
	
	
	public static final int POSTGRESQL = 2;
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case HSQLDB:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	
	public abstract CalciatoreDao getCalciatoreDAO();

	public abstract persistence.connect.UtilDao getUtilDAO();

}
