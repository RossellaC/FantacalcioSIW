package model;

public class Utente {
  private String username;
  private String password;
  private static Genere type= Genere.UTENTE; 
  private String nome;
  private String cognome;
  private String  email;
  
  public Utente() {
	  
  }

public Utente(String username, String password, String nome, String cognome, String email) {
	super();
	this.username = username;
	this.password = password;
	this.nome = nome;
	this.cognome = cognome;
	this.email = email;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public static Genere getType() {
	return type;
}

public static void setType(Genere type) {
	Utente.type = type;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
  

}
