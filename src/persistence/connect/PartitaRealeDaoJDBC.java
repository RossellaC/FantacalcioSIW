package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.PartitaReale;
import persistence.dao.PartitaRealeDao;

public class PartitaRealeDaoJDBC implements PartitaRealeDao {

	private DataSource dataSource;
	
	public PartitaRealeDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(PartitaReale pr) {
		Connection connection = this.dataSource.getConnection();
		String insert = "INSERT INTO public.partita_reale (data_partita,squadra1,squadra2) VALUES (?, ?, ?);";
		try {
			PreparedStatement ps = connection.prepareStatement(insert);
			long secs = pr.getDataPartita().getTime();
			ps.setDate(1, new java.sql.Date(secs));
			ps.setString(2, pr.getSquadra1());
			ps.setString(3, pr.getSquadra2());
			ps.executeUpdate();
		} catch(SQLException ex) {
			throw new PersistenceException(ex.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void deletePartitaReale(PartitaReale pr) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM public.partita_reale WHERE data_partita = ? AND squadra1 = ? AND squadra2 = ?;";
			PreparedStatement ps = connection.prepareStatement(delete);
			long secs = pr.getDataPartita().getTime();
			ps.setDate(1, new java.sql.Date(secs));
			ps.setString(2, pr.getSquadra1());
			ps.setString(3, pr.getSquadra2());
			ps.executeUpdate();
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
	public List<PartitaReale> getAllPartiteReali() {
		Connection connection = this.dataSource.getConnection();
		List<PartitaReale> partite = new LinkedList<>();
		try {
			PartitaReale pr;
			PreparedStatement statement;
			String query = "SELECT data_partita, squadra1, squadra2 FROM public.partita_reale;";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				pr = new PartitaReale();
				pr.setDataPartita(new Date(result.getDate("data_partita").getTime()));				
				pr.setSquadra1(result.getString("squadra1"));
				pr.setSquadra2(result.getString("squadra2"));				
				partite.add(pr);
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
		return partite;
	}

	@Override
	public PartitaReale findByPrimaryKey(Date dataPartita, String squadra1, String squadra2) {
		Connection connection = this.dataSource.getConnection();
		PartitaReale pr = null;
		try {
			PreparedStatement ps;
			String query = "SELECT data_partita, squadra1, squadra2 FROM public.partita_reale WHERE data_partita = ? AND squadra1 = ? AND squadra2 = ?;";
			ps = connection.prepareStatement(query);
			long secs = dataPartita.getTime();
			ps.setDate(1, new java.sql.Date(secs));
			ps.setString(2, squadra1);
			ps.setString(3, squadra2);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				pr = new PartitaReale();
				pr.setDataPartita(new Date(result.getDate("data_partita").getTime()));				
				pr.setSquadra1(result.getString("squadra1"));
				pr.setSquadra2(result.getString("squadra2"));				
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
		return pr;
	}
}
