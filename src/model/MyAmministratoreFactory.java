package model;

public class MyAmministratoreFactory extends AbstractUtenteFactory{

	@Override
	public Utente getUtente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amministratore getAmministratore() {
		// TODO Auto-generated method stub
		return new Amministratore();
	}

}
