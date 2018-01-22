package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Partita {
	private Long fkLega1;
	private String fkUtente1;
	private Long fkLega2;
	private String fkUtente2;
	private Date dataPartita;
	private Long goals1;
	private Long goals2;

	public Partita() {
		super();
	}

	public Partita(Long fkLega1, String fkUtente1, Long fkLega2, String fkUtente2, Date dataPartita, Long goals1,
			Long goals2) {
		super();
		this.fkLega1 = fkLega1;
		this.fkUtente1 = fkUtente1;
		this.fkLega2 = fkLega2;
		this.fkUtente2 = fkUtente2;
		this.dataPartita = dataPartita;
		this.goals1 = goals1;
		this.goals2 = goals2;
	}

	public Long getFkLega1() {
		return fkLega1;
	}

	public void setFkLega1(Long fkLega1) {
		this.fkLega1 = fkLega1;
	}

	public String getFkUtente1() {
		return fkUtente1;
	}

	public void setFkUtente1(String fkUtente1) {
		this.fkUtente1 = fkUtente1;
	}

	public Long getFkLega2() {
		return fkLega2;
	}

	public void setFkLega2(Long fkLega2) {
		this.fkLega2 = fkLega2;
	}

	public String getFkUtente2() {
		return fkUtente2;
	}

	public void setFkUtente2(String fkUtente2) {
		this.fkUtente2 = fkUtente2;
	}

	public Date getDataPartita() {
		return dataPartita;
	}

	public void setDataPartita(Date dataPartita) {
		this.dataPartita = dataPartita;
	}

	public Long getGoals1() {
		return goals1;
	}

	public void setGoals1(Long goals1) {
		this.goals1 = goals1;
	}

	public Long getGoals2() {
		return goals2;
	}

	public void setGoals2(Long goals2) {
		this.goals2 = goals2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPartita == null) ? 0 : dataPartita.hashCode());
		result = prime * result + ((fkLega1 == null) ? 0 : fkLega1.hashCode());
		result = prime * result + ((fkLega2 == null) ? 0 : fkLega2.hashCode());
		result = prime * result + ((fkUtente1 == null) ? 0 : fkUtente1.hashCode());
		result = prime * result + ((fkUtente2 == null) ? 0 : fkUtente2.hashCode());
		result = prime * result + ((goals1 == null) ? 0 : goals1.hashCode());
		result = prime * result + ((goals2 == null) ? 0 : goals2.hashCode());
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
		Partita other = (Partita) obj;
		if (dataPartita == null) {
			if (other.dataPartita != null)
				return false;
		} else if (!dataPartita.equals(other.dataPartita))
			return false;
		if (fkLega1 == null) {
			if (other.fkLega1 != null)
				return false;
		} else if (!fkLega1.equals(other.fkLega1))
			return false;
		if (fkLega2 == null) {
			if (other.fkLega2 != null)
				return false;
		} else if (!fkLega2.equals(other.fkLega2))
			return false;
		if (fkUtente1 == null) {
			if (other.fkUtente1 != null)
				return false;
		} else if (!fkUtente1.equals(other.fkUtente1))
			return false;
		if (fkUtente2 == null) {
			if (other.fkUtente2 != null)
				return false;
		} else if (!fkUtente2.equals(other.fkUtente2))
			return false;
		if (goals1 == null) {
			if (other.goals1 != null)
				return false;
		} else if (!goals1.equals(other.goals1))
			return false;
		if (goals2 == null) {
			if (other.goals2 != null)
				return false;
		} else if (!goals2.equals(other.goals2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		return "Partita [fkLega1=" + fkLega1 + ", fkUtente1=" + fkUtente1 + ", fkLega2=" + fkLega2 + ", fkUtente2="
				+ fkUtente2 + ", dataPartita=" + sdf.format(dataPartita) + ", goals1=" + goals1 + ", goals2=" + goals2 + "]";
	}
}
