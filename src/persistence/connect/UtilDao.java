package persistence.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {
	private DataSource dataSource;

	public UtilDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void dropDatabase() {

		Connection connection = dataSource.getConnection();
		try {
			String delete = 
					""
					+ "drop table if exists public.gioca;" 
					+ "drop table if exists public.partita_reale;" 
					+ "drop table if exists public.partita;"
					+ "drop table if exists public.composta;"
					+ "drop table if exists public.squadra;"
					+ " drop table if exists public.invito;"
					+ " drop table if exists public.lega;" 
					+ " drop table if exists public.utente;"
					+ "drop table if exists public.calciatore;";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();
			System.out.println("Executed drop database");

		} catch (SQLException e) {

			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new PersistenceException(e.getMessage());
			}
		}
	}

	public void createDatabase() {

		Connection connection = dataSource.getConnection();
		try {

			String delete = "create table public.calciatore(\n" + 
					"	codice CHARACTER(8) primary key,\n" + 
					"	nome VARCHAR(255),\n" + 
					"	squadra VARCHAR(255),\n" + 
					"	dataNascita DATE, \n" + 
					"	ruolo VARCHAR(255),\n" + 
					"	costo real\n" + 
					");\n" + 
					"ALTER TABLE public.calciatore OWNER TO postgres;\n" + 
					"\n" + 
					"create table public.utente (\n" + 
					"	nome VARCHAR(255),\n" + 
					"	cognome VARCHAR(255), \n" + 
					"	username VARCHAR(255),\n" + 
					"	email VARCHAR(255) PRIMARY KEY, \n" + 
					"	password VARCHAR(255)\n" + 
					");\n" + 
					"ALTER TABLE public.utente OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.lega(\n" + 
					"	id bigserial NOT NULL,\n" + 
					"	budget_iniziale numeric(10,2),\n" + 
					"	nome character varying(200),\n" + 
					"	descrizione character varying(2000),\n" + 
					"	fk_utente character varying(255),\n" + 
					"	CONSTRAINT pk_lega PRIMARY KEY (id),\n" + 
					"	CONSTRAINT fk_utente_crea_lega FOREIGN KEY (fk_utente) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.lega OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.invito (\n" + 
					"	fk_utente_invia character varying(255),\n" + 
					"	fk_utente_riceve character varying(255) NOT NULL,\n" + 
					"	fk_lega integer NOT NULL,\n" + 
					"	accettazione boolean,\n" + 
					"	CONSTRAINT pk_invito PRIMARY KEY (fk_lega, fk_utente_riceve),\n" + 
					"	CONSTRAINT fk_invito_partecipa_lega FOREIGN KEY (fk_lega) REFERENCES public.lega (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_utente_invia_invito FOREIGN KEY (fk_utente_invia)\n" + 
					"	REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_utente_riceve_invito FOREIGN KEY (fk_utente_invia) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION ) WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.invito OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.squadra (\n" + 
					"	fk_lega bigint NOT NULL,\n" + 
					"	fk_utente VARCHAR(255) NOT NULL,\n" + 
					"	nome VARCHAR(255) NOT NULL,\n" + 
					"	CONSTRAINT pk_squadra PRIMARY KEY (fk_lega, fk_utente),\n" + 
					"	CONSTRAINT fk_squadra_comprende_lega FOREIGN KEY (fk_lega) REFERENCES public.lega (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_squadra_di_utente FOREIGN KEY (fk_utente) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.squadra OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.composta (\n" + 
					"	fk_calciatore CHARACTER(8) NOT NULL,\n" + 
					"	fk_lega bigint NOT NULL,\n" + 
					"	fk_utente VARCHAR(255) NOT NULL,\n" + 
					"	CONSTRAINT pk_composta PRIMARY KEY (fk_calciatore, fk_lega, fk_utente),\n" + 
					"	CONSTRAINT fk_squadra_composta_calciatore FOREIGN KEY (fk_calciatore) REFERENCES public.calciatore (codice) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_calciatore_composta_squadra FOREIGN KEY (fk_lega, fk_utente) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.composta OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.partita (\n" + 
					"	fk_lega1 bigint NOT NULL, \n" + 
					"	fk_utente1 VARCHAR(255) NOT NULL,\n" + 
					"	fk_lega2 bigint NOT NULL, \n" + 
					"	fk_utente2 VARCHAR(255) NOT NULL,\n" + 
					"	data_partita DATE NOT NULL,\n" + 
					"	goals1 int DEFAULT 0,\n" + 
					"	goals2 int DEFAULT 0,\n" + 
					"	CONSTRAINT pk_partita PRIMARY KEY (fk_lega1, fk_utente1, fk_lega2, fk_utente2, data_partita),\n" + 
					"	CONSTRAINT fk_partita_squadra1 FOREIGN KEY (fk_lega1, fk_utente1) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_partita_squadra2 FOREIGN KEY (fk_lega2, fk_utente2) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.partita OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.partita_reale (\n" + 
					"	data_partita DATE NOT NULL,\n" + 
					"	squadra1 VARCHAR(255) NOT NULL,\n" + 
					"	squadra2 VARCHAR(255) NOT NULL,\n" + 
					"	CONSTRAINT pk_partita_reale PRIMARY KEY (data_partita, squadra1, squadra2)\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.partita_reale OWNER TO postgres;\n" + 
					"\n" + 
					"CREATE TABLE public.gioca (\n" + 
					"	fk_calciatore CHARACTER(8) NOT NULL,\n" + 
					"	data_partita DATE NOT NULL,\n" + 
					"	squadra1 VARCHAR(255) NOT NULL,\n" + 
					"	squadra2 VARCHAR(255) NOT NULL,\n" + 
					"	voto int,\n" + 
					"	CONSTRAINT pk_gioca PRIMARY KEY (fk_calciatore, data_partita, squadra1, squadra2),\n" + 
					"	CONSTRAINT fk_gioca_calciatore FOREIGN KEY (fk_calciatore) REFERENCES public.calciatore (codice) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,\n" + 
					"	CONSTRAINT fk_gioca_partita_reale FOREIGN KEY (data_partita, squadra1, squadra2) REFERENCES public.partita_reale (data_partita, squadra1, squadra2) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION\n" + 
					") WITH ( OIDS=FALSE );\n" + 
					"ALTER TABLE public.gioca OWNER TO postgres;\n";

			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();
			System.out.println("Executed create database");

		} catch (SQLException e) {

			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new PersistenceException(e.getMessage());
			}
		}
	}

	public void resetDatabase() {

		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM calciatore";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();

			String delete1 = "delete FROM utente";
			statement = connection.prepareStatement(delete1);
			statement.executeUpdate();

		} catch (SQLException e) {

			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new PersistenceException(e.getMessage());
			}
		}
	}
}
