package persistence.connect;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {
private DataSource dataSource;



public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}



public void dropDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		String delete = "drop table if exists calciatore;"
				+ " drop table if exists utente"
				;
		PreparedStatement statement = connection.prepareStatement(delete);
		
		statement.executeUpdate();
		System.out.println("Executed drop database");
		
	} catch (SQLException e) {
		
		throw new PersistenceException(e.getMessage());
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		}
	}
}

public void createDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		
		String delete = 
				 "create table calciatore(codice CHARACTER(8) primary key,"				
				+ "nome VARCHAR(255),squadra VARCHAR(255),"
				+ "dataNascita DATE, ruolo VARCHAR(255),costo real);"
				+ "create table utente (nome VARCHAR(255),cognome VARCHAR(255), username VARCHAR(255),"
				+"email VARCHAR(255), password VARCHAR(255));"
				;
				
		
		PreparedStatement statement = connection.prepareStatement(delete);
		
		statement.executeUpdate();
		System.out.println("Executed create database");
		
	} catch (SQLException e) {
		
		throw new PersistenceException(e.getMessage());
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		}
	}
}


public  void resetDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM calciatore";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			String delete1 = "delete FROM utente";
			statement = connection.prepareStatement(delete1);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new PersistenceException(e.getMessage());
			}
		}
	}
}
