package model;

import java.util.Date;

public class Gioca {
	private String fkCalciatore;
	private Date dataPartita;
	private String squadra1;
	private String squadra2;
	private Long voto;
		
	public Gioca() {
		super();
	}

	public Gioca(String fkCalciatore, Date dataPartita, String squadra1, String squadra2, Long voto) {
		super();
		this.fkCalciatore = fkCalciatore;
		this.dataPartita = dataPartita;
		this.squadra1 = squadra1;
		this.squadra2 = squadra2;
		this.voto = voto;
	}

	public String getFkCalciatore() {
		return fkCalciatore;
	}

	public void setFkCalciatore(String fkCalciatore) {
		this.fkCalciatore = fkCalciatore;
	}

	public Date getDataPartita() {
		return dataPartita;
	}

	public void setDataPartita(Date dataPartita) {
		this.dataPartita = dataPartita;
	}

	public String getSquadra1() {
		return squadra1;
	}

	public void setSquadra1(String squadra1) {
		this.squadra1 = squadra1;
	}

	public String getSquadra2() {
		return squadra2;
	}

	public void setSquadra2(String squadra2) {
		this.squadra2 = squadra2;
	}

	public Long getVoto() {
		return voto;
	}

	public void setVoto(Long voto) {
		this.voto = voto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPartita == null) ? 0 : dataPartita.hashCode());
		result = prime * result + ((fkCalciatore == null) ? 0 : fkCalciatore.hashCode());
		result = prime * result + ((squadra1 == null) ? 0 : squadra1.hashCode());
		result = prime * result + ((squadra2 == null) ? 0 : squadra2.hashCode());
		result = prime * result + ((voto == null) ? 0 : voto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gioca other = (Gioca) obj;
		if (dataPartita == null) {
			if (other.dataPartita != null)
				return false;
		} else if (!dataPartita.equals(other.dataPartita))
			return false;
		if (fkCalciatore == null) {
			if (other.fkCalciatore != null)
				return false;
		} else if (!fkCalciatore.equals(other.fkCalciatore))
			return false;
		if (squadra1 == null) {
			if (other.squadra1 != null)
				return false;
		} else if (!squadra1.equals(other.squadra1))
			return false;
		if (squadra2 == null) {
			if (other.squadra2 != null)
				return false;
		} else if (!squadra2.equals(other.squadra2))
			return false;
		if (voto == null) {
			if (other.voto != null)
				return false;
		} else if (!voto.equals(other.voto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gioca [fkCalciatore=" + fkCalciatore + ", dataPartita=" + dataPartita + ", squadra1=" + squadra1
				+ ", squadra2=" + squadra2 + ", voto=" + voto + "]";
	}
	
	
}
