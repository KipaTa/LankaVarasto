package palvelinohjelmointi.LankaVarasto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Lanka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String nimi;
	private String valmistaja;
	private int paino;
	private String vari;
	private double maara;
	
	@ManyToOne
	@JsonIgnoreProperties ("langat")
	@JoinColumn(name = "mId")
	private Materiaali materiaali;
	
	public Lanka() {
	
	}

	public Lanka(String nimi, String valmistaja, int paino, String vari, double maara, Materiaali materiaali) {
		super();
		this.nimi = nimi;
		this.valmistaja = valmistaja;
		this.paino = paino;
		this.vari = vari;
		this.maara = maara;
		this.materiaali = materiaali;
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

	public double getMaara() {
		return maara;
	}

	public void setMaara(double maara) {
		this.maara = maara;
	}
	
	

	public Materiaali getMateriaali() {
		return materiaali;
	}

	public void setMateriaali(Materiaali materiaali) {
		this.materiaali = materiaali;
	}

	@Override
	public String toString() {
		if(this.materiaali != null)
			return "Lanka [id=" + id + ", nimi=" + nimi + ", valmistaja=" + valmistaja + ", paino=" + paino + ", vari=" + vari + ", maara="
			+ maara +", materiaali=" + this.getMateriaali() + "]";
		else
			return "Lanka [id=" + id + ", nimi=" + nimi + ", valmistaja=" + valmistaja + ", paino=" + paino + ", vari=" + vari + ", maara="
				+ maara + "]";
	}
	
	
}
