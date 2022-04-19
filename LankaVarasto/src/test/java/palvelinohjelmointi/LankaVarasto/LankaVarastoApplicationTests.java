package palvelinohjelmointi.LankaVarasto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import palvelinohjelmointi.LankaVarasto.web.LankaVarastoController;
import palvelinohjelmointi.LankaVarasto.web.MateriaaliController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LankaVarastoApplicationTests {

	@Autowired
	private LankaVarastoController lController;
	
	@Autowired
	private MateriaaliController mController;
	
	@Test
	void contextLoads() {
		assertThat(lController).isNotNull();
		assertThat(mController).isNotNull();
	}

}
