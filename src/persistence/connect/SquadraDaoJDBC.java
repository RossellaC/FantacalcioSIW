package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Invito;
import model.Squadra;
import persistence.dao.SquadraDao;

public class SquadraDaoJDBC implements SquadraDao {

	private DataSource dataSource;
	
	public SquadraDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void save(Squadra l) {
		String query = "INSERT INTO public.squadra (fk_lega,fk_utente,nome) VALUES (?, ?, ?);";
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, l.getFkLega());
			ps.setString(2, l.getFkUtente());
			ps.setString(3, l.getNome());
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
	public void deleteSquadra(Squadra l) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM public.squadra WHERE fk_lega = ? AND fk_utente = ?;";
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setLong(1, l.getFkLega());
			ps.setString(2, l.getFkUtente());
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
	public List<Squadra> getAllSquadre() {
		Connection connection = this.dataSource.getConnection();
		List<Squadra> squadre = new LinkedList<>();
		try {
			Squadra l = null;
			PreparedStatement statement;
			String query = "SELECT fk_lega, fk_utente, nome FROM public.squadra;";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Squadra();
				l.setFkLega(rs.getLong("fk_lega"));
				l.setFkUtente(rs.getString("fk_utente"));
				l.setNome(rs.getString("nome"));
				squadre.add(l);
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
		return squadre;
	}

	@Override
	public Squadra findByPrimaryKey(Squadra l) {
		Connection connection = this.dataSource.getConnection();
		Squadra invito = null;
		try {
			PreparedStatement ps;
			String query = "SELECT fk_lega, fk_utente, nome FROM public.squadra WHERE fk_lega = ? AND fk_utente = ?;";
			ps = connection.prepareStatement(query);
			ps.setLong(1, l.getFkLega());
			ps.setString(2, l.getFkUtente());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				invito = new Squadra();
				invito.setFkUtente(rs.getString("fk_utente"));
				invito.setFkLega(rs.getLong("fk_lega"));
				invito.setNome(rs.getString("nome"));
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
		return invito;
	}

	@Override
	public List<Squadra> getSquadreLega(Long id) {
		Connection connection = this.dataSource.getConnection();
		List<Squadra> squadre = new LinkedList<>();
		try {
			Squadra l = null;
			PreparedStatement statement;
			String query = "SELECT fk_lega, fk_utente, nome "
					+ "FROM public.squadra WHERE fk_lega = ?;";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Squadra();
				l.setFkLega(rs.getLong("fk_lega"));
				l.setFkUtente(rs.getString("fk_utente"));
				l.setNome(rs.getString("nome"));
				squadre.add(l);
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
		return squadre;
	}

}
