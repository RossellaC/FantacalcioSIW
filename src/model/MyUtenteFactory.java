package model;

public class MyUtenteFactory  extends AbstractUtenteFactory{

	@Override
	public Utente getUtente() {
		// TODO Auto-generated method stub
		return new Utente();
	}

	@Override
	public Amministratore getAmministratore() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
