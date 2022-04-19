package palvelinohjelmointi.LankaVarasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.LankaVarasto.domain.User;
import palvelinohjelmointi.LankaVarasto.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository uRepository;
	
	@Test
	public void findUserName() {
		User user = uRepository.findByUsername("admin");
		assertThat(user).isNotNull();
	}
}
