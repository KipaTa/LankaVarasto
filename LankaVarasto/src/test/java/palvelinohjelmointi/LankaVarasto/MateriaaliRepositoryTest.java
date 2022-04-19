package palvelinohjelmointi.LankaVarasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.LankaVarasto.domain.Materiaali;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MateriaaliRepositoryTest {
	
	@Autowired
	private MateriaaliRepository mRepository;
	
	@Test
	public void etsiMateriaaliNimi() {
	List<Materiaali> materiaalit = mRepository.findBymNimi("70% alpakka, 30% silkki");
	assertThat(materiaalit).hasSize(1);
	assertThat(materiaalit.get(0).getId()).isEqualTo(3);
	}
	
	@Test
	public void lisaaUusiMateriaali() {
		Materiaali materiaali = new Materiaali ("100% villa");
		mRepository.save(materiaali);
		assertThat(materiaali.getId()).isNotNull();
	}

}
