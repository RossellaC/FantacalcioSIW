package persistence.connect;

import persistence.dao.CalciatoreDao;

class PostgresDAOFactory extends DAOFactory {
private static  DataSource dataSource;
	

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/Fantacalcio","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	@Override
	public CalciatoreDao getCalciatoreDAO() {
		return new CalciatoreDaoJDBC(dataSource);
	}

	
	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}
}
