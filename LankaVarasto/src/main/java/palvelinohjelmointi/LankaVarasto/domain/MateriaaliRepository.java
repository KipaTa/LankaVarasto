package palvelinohjelmointi.LankaVarasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MateriaaliRepository extends CrudRepository<Materiaali, Long> {
	
	List<Materiaali> findBymNimi(String mNimi);
}
