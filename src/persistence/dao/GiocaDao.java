package persistence.dao;

import java.util.List;

import model.Gioca;

public interface GiocaDao {
	public void save(Gioca l);
	public void deleteGioca(Gioca l);
	public List<Gioca> getAllGioca();
	public Gioca findByPrimaryKey(Gioca l);
}
