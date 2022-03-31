package palvelinohjelmointi.LankaVarasto.domain;

public class Lanka {
	private String nimi;
	private String valmistaja;
	private int paino;
	private String vari;
	private Double maara;
	
	public Lanka() {
		super();
	}

	public Lanka(String nimi, String valmistaja, int paino, String vari, Double maara) {
		super();
		this.nimi = nimi;
		this.valmistaja = valmistaja;
		this.paino = paino;
		this.vari = vari;
		this.maara = maara;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getValmistaja() {
		return valmistaja;
	}

	public void setValmistaja(String valmistaja) {
		this.valmistaja = valmistaja;
	}

	public int getPaino() {
		return paino;
	}

	public void setPaino(int paino) {
		this.paino = paino;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public Double getMaara() {
		return maara;
	}

	public void setMaara(Double maara) {
		this.maara = maara;
	}

	@Override
	public String toString() {
		return "Lanka [nimi=" + nimi + ", valmistaja=" + valmistaja + ", paino=" + paino + ", vari=" + vari + ", maara="
				+ maara + "]";
	}
	
	
}
