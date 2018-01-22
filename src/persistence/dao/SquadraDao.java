package persistence.dao;

import java.util.List;

import model.Squadra;

public interface SquadraDao {
	public void save(Squadra l);
	public void deleteSquadra(Squadra l);
	public List<Squadra> getAllSquadre();
	public Squadra findByPrimaryKey(Squadra l);
}
