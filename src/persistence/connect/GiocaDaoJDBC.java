package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Gioca;
import persistence.dao.GiocaDao;

public class GiocaDaoJDBC implements GiocaDao {

	private DataSource dataSource;
	
	public GiocaDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void save(Gioca l) {
		String query = "INSERT INTO public.gioca(fk_calciatore, data_partita, squadra1, squadra2, voto) VALUES (?, ?, ?, ?, ?);";
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, l.getFkCalciatore());
			long secs = l.getDataPartita().getTime();
			ps.setDate(2, new java.sql.Date(secs));
			ps.setString(3, l.getSquadra1());
			ps.setString(4, l.getSquadra2());
			ps.setLong(5, l.getVoto());
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
	public void deleteGioca(Gioca l) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "DELETE FROM public.gioca WHERE fk_calciatore = ? AND data_partita = ? AND squadra1 = ? AND squadra2 = ?;";
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setString(1, l.getFkCalciatore());
			long secs = l.getDataPartita().getTime();
			ps.setDate(2, new java.sql.Date(secs));
			ps.setString(3, l.getSquadra1());
			ps.setString(4, l.getSquadra2());
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
	public List<Gioca> getAllGioca() {
		Connection connection = this.dataSource.getConnection();
		List<Gioca> inviti = new LinkedList<>();
		try {
			Gioca l = null;
			PreparedStatement statement;
			String query = "SELECT fk_calciatore, data_partita, squadra1, squadra2, voto FROM public.gioca;";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Gioca();
				l.setFkCalciatore(rs.getString("fk_calciatore"));
				long secs = rs.getDate("data_partita").getTime();
				l.setDataPartita(new Date(secs));
				l.setSquadra1(rs.getString("squadra1"));
				l.setSquadra2(rs.getString("squadra2"));
				l.setVoto(rs.getLong("voto"));
				inviti.add(l);
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
		return inviti;
	}

	@Override
	public Gioca findByPrimaryKey(Gioca l) {
		Connection connection = this.dataSource.getConnection();
		Gioca invito = null;
		try {
			PreparedStatement ps;
			String query = "SELECT fk_calciatore, data_partita, squadra1, squadra2, voto "
					+ "FROM public.gioca WHERE fk_calciatore = ? AND data_partita = ? AND squadra1 = ? AND squadra2 = ?;";
			ps = connection.prepareStatement(query);
			ps.setString(1, l.getFkCalciatore());
			long secs = l.getDataPartita().getTime();
			ps.setDate(2, new java.sql.Date(secs));
			ps.setString(3, l.getSquadra1());
			ps.setString(4, l.getSquadra2());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				invito = new Gioca();
				invito.setFkCalciatore(rs.getString("fk_calciatore"));
				invito.setDataPartita(new Date(rs.getDate("data_partita").getTime()));
				invito.setSquadra1(rs.getString("squadra1"));
				invito.setSquadra2(rs.getString("squadra2"));
				invito.setVoto(rs.getLong("voto"));
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

}
