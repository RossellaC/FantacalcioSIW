package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Invito;
import persistence.dao.InvitoDao;

public class InvitoDaoJDBC implements InvitoDao {

	private DataSource dataSource;
	
	public InvitoDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void save(Invito l) {
		String query = "INSERT INTO public.invito (fk_utente_invia, fk_utente_riceve, fk_lega, accettazione) VALUES (?, ?, ?, ?);";
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, l.getFkUtenteInvia());
			ps.setString(2, l.getFkUtenteRiceve());
			ps.setLong(3, l.getFkLega());
			ps.setBoolean(4, l.isAccettazione());
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
	public void deleteInvito(Invito l) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM public.invito WHERE fk_lega = ? AND fk_utente_riceve = ?;";
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setLong(1, l.getFkLega());
			ps.setString(2, l.getFkUtenteRiceve());
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
	public List<Invito> getAllInviti() {
		Connection connection = this.dataSource.getConnection();
		List<Invito> inviti = new LinkedList<>();
		try {
			Invito l = null;
			PreparedStatement statement;
			String query = "SELECT fk_utente_invia, fk_utente_riceve, fk_lega, accettazione FROM public.invito;";
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Invito();
				l.setFkUtenteInvia(rs.getString("fk_utente_invia"));
				l.setFkUtenteRiceve(rs.getString("fk_utente_riceve"));
				l.setFkLega(rs.getLong("fk_lega"));
				l.setAccettazione(rs.getBoolean("accettazione"));
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
	public Invito findByPrimaryKey(Invito l) {
		Connection connection = this.dataSource.getConnection();
		Invito invito = null;
		try {
			PreparedStatement ps;
			String query = "SELECT fk_utente_invia, fk_utente_riceve, fk_lega, accettazione FROM public.invito WHERE fk_utente_riceve = ? AND fk_lega = ?;";
			ps = connection.prepareStatement(query);
			ps.setString(1, l.getFkUtenteRiceve());
			ps.setLong(2, l.getFkLega());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				invito = new Invito();
				invito.setFkUtenteInvia(rs.getString("fk_utente_invia"));
				invito.setFkUtenteRiceve(rs.getString("fk_utente_riceve"));
				invito.setFkLega(rs.getLong("fk_lega"));
				invito.setAccettazione(rs.getBoolean("accettazione"));
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
	public List<Invito> getInvitiPerLega(String inviante, Long id) {
		Connection connection = this.dataSource.getConnection();
		List<Invito> inviti = new LinkedList<>();
		try {
			Invito l = null;
			PreparedStatement statement;
			String query = "SELECT fk_utente_invia, fk_utente_riceve, fk_lega, accettazione "
					+ "FROM public.invito "
					+ "WHERE fk_utente_invia = ? AND fk_lega = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, inviante);
			statement.setLong(2, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				l = new Invito();
				l.setFkUtenteInvia(rs.getString("fk_utente_invia"));
				l.setFkUtenteRiceve(rs.getString("fk_utente_riceve"));
				l.setFkLega(rs.getLong("fk_lega"));
				l.setAccettazione(rs.getBoolean("accettazione"));
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
	
}
