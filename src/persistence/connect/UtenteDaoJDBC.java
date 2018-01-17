package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import model.Factories;
import model.Utente;

import persistence.dao.UtenteDao;


public class UtenteDaoJDBC  implements UtenteDao{
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource=dataSource;
		
		//System.out.println(dataSource.getDbURI() +" "+dataSource.getUserName()+" "+dataSource.getPassword());
	}
	
	@Override
	public void save(Utente utente) {
		// TODO Auto-generated method stub
		Connection connection = this.dataSource.getConnection();
		//DatabaseManager.getInstance().getDaoFactory().getUtenteDao();
		
		try {
			String insert = "insert into utente(username,password,nome,cognome,email) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setString(5, utente.getEmail());
			
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

	@Override
	public void updateUtente(String username, String password) {
		// TODO Auto-generated method stub
			Connection connection = this.dataSource.getConnection();
			try {
				String update = "update utente SET username=?,password=? WHERE username=?";
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, username);
			
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
		

	@Override
	public void deleteUtente(String username) {
		// TODO Auto-generated method stub
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, username);
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
	

	@Override
	public Utente getUtente( String username){
		Utente utente = Factories.getInstance().makeUtente();
		Connection connection = this.dataSource.getConnection();
		try {
			 String query = "SELECT * FROM utente WHERE username=?";
			 PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				utente.setUsername(rs.getString(1));
				utente.setPassword(rs.getString(2));
			}
			
			connection.close();
		} catch (Exception e) {
			System.out.println("Utente non presente nel DataBase!!!");
		}
		
		return utente;
	} 
	public boolean validate(String username, String password){
		Utente utente = getUtente(username);
		
		if(utente.getUsername() != null && utente.getPassword().equals(password))
			return true;
		return false;
	}

	
	}
