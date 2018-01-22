create table public.calciatore(
	codice CHARACTER(8) primary key,
	nome VARCHAR(255),
	squadra VARCHAR(255),
	dataNascita DATE, 
	ruolo VARCHAR(255),
	costo real
);
ALTER TABLE public.calciatore OWNER TO postgres;

create table public.utente (
	nome VARCHAR(255),
	cognome VARCHAR(255), 
	username VARCHAR(255),
	email VARCHAR(255) PRIMARY KEY, 
	password VARCHAR(255)
);
ALTER TABLE public.utente OWNER TO postgres;

CREATE TABLE public.lega(
	id bigserial NOT NULL,
	budget_iniziale numeric(10,2),
	nome character varying(200),
	descrizione character varying(2000),
	fk_utente character varying(255),
	CONSTRAINT pk_lega PRIMARY KEY (id),
	CONSTRAINT fk_utente_crea_lega FOREIGN KEY (fk_utente) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH ( OIDS=FALSE );
ALTER TABLE public.lega OWNER TO postgres;

CREATE TABLE public.invito (
	fk_utente_invia character varying(255),
	fk_utente_riceve character varying(255) NOT NULL,
	fk_lega integer NOT NULL,
	accettazione boolean,
	CONSTRAINT pk_invito PRIMARY KEY (fk_lega, fk_utente_riceve),
	CONSTRAINT fk_invito_partecipa_lega FOREIGN KEY (fk_lega) REFERENCES public.lega (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_utente_invia_invito FOREIGN KEY (fk_utente_invia)
	REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_utente_riceve_invito FOREIGN KEY (fk_utente_invia) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION ) WITH ( OIDS=FALSE );
ALTER TABLE public.invito OWNER TO postgres;

CREATE TABLE public.squadra (
	fk_lega bigint NOT NULL,
	fk_utente VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	CONSTRAINT pk_squadra PRIMARY KEY (fk_lega, fk_utente),
	CONSTRAINT fk_squadra_comprende_lega FOREIGN KEY (fk_lega) REFERENCES public.lega (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_squadra_di_utente FOREIGN KEY (fk_utente) REFERENCES public.utente (email) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH ( OIDS=FALSE );
ALTER TABLE public.squadra OWNER TO postgres;

CREATE TABLE public.composta (
	fk_calciatore CHARACTER(8) NOT NULL,
	fk_lega bigint NOT NULL,
	fk_utente VARCHAR(255) NOT NULL,
	CONSTRAINT pk_composta PRIMARY KEY (fk_calciatore, fk_lega, fk_utente),
	CONSTRAINT fk_squadra_composta_calciatore FOREIGN KEY (fk_calciatore) REFERENCES public.calciatore (codice) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_calciatore_composta_squadra FOREIGN KEY (fk_lega, fk_utente) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH ( OIDS=FALSE );
ALTER TABLE public.composta OWNER TO postgres;

CREATE TABLE public.partita (
	fk_lega1 bigint NOT NULL, 
	fk_utente1 VARCHAR(255) NOT NULL,
	fk_lega2 bigint NOT NULL, 
	fk_utente2 VARCHAR(255) NOT NULL,
	data_partita DATE NOT NULL,
	goals1 int DEFAULT 0,
	goals2 int DEFAULT 0,
	CONSTRAINT pk_partita PRIMARY KEY (fk_lega1, fk_utente1, fk_lega2, fk_utente2, data_partita),
	CONSTRAINT fk_partita_squadra1 FOREIGN KEY (fk_lega1, fk_utente1) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_partita_squadra2 FOREIGN KEY (fk_lega2, fk_utente2) REFERENCES public.squadra (fk_lega, fk_utente) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH ( OIDS=FALSE );
ALTER TABLE public.partita OWNER TO postgres;

CREATE TABLE public.partita_reale (
	data_partita DATE NOT NULL,
	squadra1 VARCHAR(255) NOT NULL,
	squadra2 VARCHAR(255) NOT NULL,
	CONSTRAINT pk_partita_reale PRIMARY KEY (data_partita, squadra1, squadra2)
) WITH ( OIDS=FALSE );
ALTER TABLE public.partita_reale OWNER TO postgres;

CREATE TABLE public.gioca (
	fk_calciatore CHARACTER(8) NOT NULL,
	data_partita DATE NOT NULL,
	squadra1 VARCHAR(255) NOT NULL,
	squadra2 VARCHAR(255) NOT NULL,
	voto int,
	CONSTRAINT pk_gioca PRIMARY KEY (fk_calciatore, data_partita, squadra1, squadra2),
	CONSTRAINT fk_gioca_calciatore FOREIGN KEY (fk_calciatore) REFERENCES public.calciatore (codice) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_gioca_partita_reale FOREIGN KEY (data_partita, squadra1, squadra2) REFERENCES public.partita_reale (data_partita, squadra1, squadra2) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH ( OIDS=FALSE );
ALTER TABLE public.gioca OWNER TO postgres;




















