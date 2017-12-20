package persistence.dao;

import java.util.List;

import model.Calciatore;

public interface CalciatoreDao {
	public void save(Calciatore calciatore);  // Create
	public Calciatore findByPrimaryKey(String codice);     // Retrieve
	public List<Calciatore> findAll();       
	public void update(Calciatore calciatore); //Update
	public void delete(Calciatore calciatore); //Delete	
}
