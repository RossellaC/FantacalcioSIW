package persistence.dao;

import java.util.Date;
import java.util.List;

import model.PartitaReale;

public interface PartitaRealeDao {
	public void save(PartitaReale pr);
	public void deletePartitaReale(PartitaReale pr);
	public List<PartitaReale> getAllPartiteReali();
	public PartitaReale findByPrimaryKey(Date dataPartita, String squadra1, String squadra2);
}
