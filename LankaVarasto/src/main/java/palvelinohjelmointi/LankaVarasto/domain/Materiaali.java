package palvelinohjelmointi.LankaVarasto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Materiaali {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String mNimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="materiaali")
	@JsonIgnoreProperties("materiaali")
	private List<Lanka> langat;
	
	public Materiaali() {
		
	}

	public Materiaali(String mNimi) {
		super();
		this.mNimi = mNimi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getmNimi() {
		return mNimi;
	}

	public void setmNimi(String mNimi) {
		this.mNimi = mNimi;
	}

	@Override
	public String toString() {
		return "Materiaali [id=" + id + ", mNimi=" + mNimi + "]";
	}
	
	
}
