package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PartitaReale {
	private Date dataPartita;
	private String squadra1;
	private String squadra2;

	public PartitaReale() {
		super();
	}

	public PartitaReale(Date dataPartita, String squadra1, String squadra2) {
		super();
		this.dataPartita = dataPartita;
		this.squadra1 = squadra1;
		this.squadra2 = squadra2;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPartita == null) ? 0 : dataPartita.hashCode());
		result = prime * result + ((squadra1 == null) ? 0 : squadra1.hashCode());
		result = prime * result + ((squadra2 == null) ? 0 : squadra2.hashCode());
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
		PartitaReale other = (PartitaReale) obj;
		if (dataPartita == null) {
			if (other.dataPartita != null)
				return false;
		} else if (!dataPartita.equals(other.dataPartita))
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
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		return "PartitaReale [dataPartita=" + sdf.format(dataPartita) + ", squadra1=" + squadra1 + ", squadra2=" + squadra2 + "]";
	}

	
}
