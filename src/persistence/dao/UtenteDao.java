package persistence.dao;

import model.Utente;

    public interface UtenteDao {
	public void addUtente(Utente utente);  // Create
	public void updateUtente(final String username, final String password); //Update
	public void deleteUtente(String username); //Delete	


	
}