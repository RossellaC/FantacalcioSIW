package persistence.dao;

import java.util.List;

import model.Invito;

public interface InvitoDao {
	public void save(Invito l);
	public void deleteInvito(Invito l);
	public List<Invito> getAllInviti();
	public Invito findByPrimaryKey(Invito l);
}
