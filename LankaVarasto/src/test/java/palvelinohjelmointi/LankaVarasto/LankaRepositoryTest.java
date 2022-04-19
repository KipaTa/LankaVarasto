package palvelinohjelmointi.LankaVarasto;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import palvelinohjelmointi.LankaVarasto.domain.Lanka;
import palvelinohjelmointi.LankaVarasto.domain.LankaRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LankaRepositoryTest {
	
	@Autowired
	private LankaRepository lRepository;
	
	@Test
	public void etsiLankaNimiPitaisiPalauttaaLanka() {
		List<Lanka> langat = lRepository.findByNimi("Nalle");
		
		assertThat(langat).hasSize(1);
		assertThat(langat.get(0).getValmistaja()).isEqualTo("Novita");
	}
	
	@Test
	public void lisaaUusiLankaPitaisiLuodaUusiLanka() {
		Lanka lanka = new Lanka("Venla", "Novita", 100, "lila", 1.0, null);
		lRepository.save(lanka);
		assertThat(lanka.getId()).isNotNull();
	}
	
	@Test
	public void poistaLankaPitaisiPoistaaLanka() {
		lRepository.deleteById((long) 4);
		Optional<Lanka> deleteLanka = lRepository.findById((long) 4);
		assertThat(deleteLanka).isEmpty();
	}

}
