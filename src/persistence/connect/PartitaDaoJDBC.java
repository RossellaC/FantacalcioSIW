package persistence.connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Composta;
import model.Partita;
import persistence.dao.PartitaDao;

public class PartitaDaoJDBC implements PartitaDao {

	private DataSource dataSource;
	
	public PartitaDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void save(Partita l) {
		String query = "INSERT INTO public.partita (fk_lega1,fk_utente1,fk_lega2,fk_utente2,data_partita,goals1,goals2) VALUES (?,?,?,?,?,?,?);";
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, l.getFkLega1());
			ps.setString(2, l.getFkUtente1());
			ps.setLong(3, l.getFkLega2());
			ps.setString(4, l.getFkUtente2());
			long secs = l.getDataPartita().getTime();
			ps.setDate(5, new java.sql.Date(secs));
			ps.setLong(6, l.getGoals1());
			ps.setLong(7, l.getGoals2());
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
	public void deletePartita(Partita l) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM public.partita WHERE fk_lega1 = ? AND fk_utente1 = ? AND fk_lega2 = ? AND fk_utente2 = ? AND data_partita = ?;";
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setLong(1, l.getFkLega1());
			ps.setString(2, l.getFkUtente1());
			ps.setLong(3, l.getFkLega2());
			ps.setString(4, l.getFkUtente2());
			ps.setDate(5, new java.sql.Date(l.getDataPartita().getTime()));
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
	public List<Partita> getAllPartita() {
		Connection connection = this.dataSource.getConnection();
		List<Partita> partite = new LinkedList<>();
		try {
			Partita l = null;
			PreparedStatement statement;
			String query = "SELECT fk_lega1, fk_utente1, fk_lega2, fk_utente2, data_partita, goals1, goals2 FROM public.partita;";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Partita();
				l.setFkLega1(rs.getLong("fk_lega1"));
				l.setFkUtente1(rs.getString("fk_utente1"));
				l.setFkLega2(rs.getLong("fk_lega2"));
				l.setFkUtente2(rs.getString("fk_utente2"));
				l.setDataPartita(new java.util.Date(rs.getDate("data_partita").getTime()));
				l.setGoals1(rs.getLong("goals1"));
				l.setGoals2(rs.getLong("goals2"));
				partite.add(l);
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
	public Partita findByPrimaryKey(Partita l) {
		Connection connection = this.dataSource.getConnection();
		Partita partita = null;
		try {
			PreparedStatement ps;
			String query = "SELECT fk_lega1, fk_utente1, fk_lega2, fk_utente2, data_partita, goals1, goals2 FROM public.partita "
					+ "WHERE fk_lega1 = ? AND fk_utente1 = ? AND fk_lega2 = ? AND fk_utente2 = ? AND data_partita = ?;";
			ps = connection.prepareStatement(query);
			ps.setLong(1, l.getFkLega1());
			ps.setString(2, l.getFkUtente1());
			ps.setLong(3, l.getFkLega2());
			ps.setString(4, l.getFkUtente2());
			long secs = l.getDataPartita().getTime();
			ps.setDate(5, new java.sql.Date(secs));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				partita = new Partita();
				partita.setFkLega1(rs.getLong("fk_lega1"));
				partita.setFkUtente1(rs.getString("fk_utente1"));
				partita.setFkLega2(rs.getLong("fk_lega2"));
				partita.setFkUtente2(rs.getString("fk_utente2"));
				partita.setDataPartita(new java.util.Date(rs.getDate("data_partita").getTime()));
				partita.setGoals1(rs.getLong("goals1"));
				partita.setGoals2(rs.getLong("goals2"));
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
		return partita;
	}

}
