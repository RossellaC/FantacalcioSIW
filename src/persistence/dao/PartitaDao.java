package persistence.dao;

import java.util.List;

import model.Partita;

public interface PartitaDao {
	public void save(Partita l);
	public void deletePartita(Partita l);
	public List<Partita> getAllPartita();
	public Partita findByPrimaryKey(Partita l);
}
