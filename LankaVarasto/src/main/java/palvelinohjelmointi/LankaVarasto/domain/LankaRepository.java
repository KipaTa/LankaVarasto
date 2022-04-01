package palvelinohjelmointi.LankaVarasto.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LankaRepository extends CrudRepository<Lanka, Long> {
	List<Lanka> findByNimi(String nimi);
}
