package persistence.connect;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Calciatore;
import persistence.dao.CalciatoreDao;

public class CalciatoreDaoJDBC  implements CalciatoreDao{
	private DataSource dataSource;

	public CalciatoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Calciatore calciatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into calciatore(codice, nome,squadra, dataNascita,ruolo,costo ) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, calciatore.getCodice());
			statement.setString(2, calciatore.getNome());
			statement.setString(3, calciatore.getSquadra());
			long secs = calciatore.getDataNascita().getTime();
			statement.setDate(4, new java.sql.Date(secs));
			statement.setString(5, calciatore.getRuolo());
			statement.setDouble(6, calciatore.getCosto());
			
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

	public Calciatore findByPrimaryKey(String codice) {
		Connection connection = this.dataSource.getConnection();
		Calciatore calciatore = null;
		try {
			PreparedStatement statement;
			String query = "select * from calciatore where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1,codice);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				calciatore = new Calciatore();
				calciatore.setCodice(result.getString("codice"));				
				calciatore.setNome(result.getString("nome"));
				calciatore.setSquadra(result.getString("squadra"));
				long secs = result.getDate("dataNascita").getTime();
				calciatore.setDataNascita(new java.util.Date(secs));
				calciatore.setRuolo(result.getString("ruolo"));
				calciatore.setCosto(result.getDouble("costo"));
				
				
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return calciatore;
	}

	public List<Calciatore> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Calciatore> calciatori = new LinkedList<>();
		try {
			Calciatore calciatore;
			PreparedStatement statement;
			String query = "select * from calciatore";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				calciatore = new Calciatore();
				calciatore.setCodice(result.getString("codice"));				
				calciatore.setNome(result.getString("nome"));
				calciatore.setSquadra(result.getString("squadra"));
				long secs = result.getDate("dataNascita").getTime();
				calciatore.setDataNascita(new java.util.Date(secs));
				calciatore.setRuolo(result.getString("ruolo"));
				calciatore.setCosto(result.getDouble("costo"));
				
				calciatori.add(calciatore);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return calciatori;
	}

	public void update(Calciatore calciatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update calciatore SET nome = ?, squadra = ?, dataNascita = ?, ruolo = ? , costo =?  WHERE codice=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, calciatore.getNome());
			statement.setString(2,  calciatore.getSquadra());
			long secs =  calciatore.getDataNascita().getTime();
			statement.setDate(3, new java.sql.Date(secs));
			statement.setString(4, calciatore.getCodice());
			statement.setString(5,  calciatore.getRuolo());
			statement.setDouble(6,  calciatore.getCosto());
			
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

	public void delete(Calciatore calciatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM calciatore WHERE codice = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, calciatore.getCodice());
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
