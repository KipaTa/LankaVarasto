package palvelinohjelmointi.LankaVarasto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lanka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	private String valmistaja;
	private int paino;
	private String vari;
	private Double maara;
	
	public Lanka() {
	
	}

	public Lanka(String nimi, String valmistaja, int paino, String vari, Double maara) {
		super();
		this.nimi = nimi;
		this.valmistaja = valmistaja;
		this.paino = paino;
		this.vari = vari;
		this.maara = maara;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
		return "Lanka [id=" + id + ", nimi=" + nimi + ", valmistaja=" + valmistaja + ", paino=" + paino + ", vari=" + vari + ", maara="
				+ maara + "]";
	}
	
	
}
