package palvelinohjelmointi.LankaVarasto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import palvelinohjelmointi.LankaVarasto.domain.Lanka;
import palvelinohjelmointi.LankaVarasto.domain.LankaRepository;
import palvelinohjelmointi.LankaVarasto.domain.Materiaali;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;
import palvelinohjelmointi.LankaVarasto.domain.User;
import palvelinohjelmointi.LankaVarasto.domain.UserRepository;

@SpringBootApplication
public class LankaVarastoApplication {
	private static final Logger log = LoggerFactory.getLogger(LankaVarastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LankaVarastoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner lankaDemo(LankaRepository lrepository, MateriaaliRepository mrepository, UserRepository urepository) {
		return (args) -> {
				
			log.info("lisää pari lankaa");
			
			Materiaali materiaali1 = new Materiaali("100% Villa");
			mrepository.save(materiaali1);
			Materiaali materiaali2 = new Materiaali("75% villa, 25% polyamidi");
			mrepository.save(materiaali2);
			Materiaali materiaali3 = new Materiaali("70% alpakka, 30% silkki");
			mrepository.save(materiaali3);
			
			
			lrepository.save(new Lanka("Nalle", "Novita", 100, "musta", 1.0, materiaali2));
			lrepository.save(new Lanka("Seitsemän veljestä", "Novita", 200, "punainen", 2.0, materiaali2));
			lrepository.save(new Lanka("Alpakka Silke", "Sandnes Garn", 50, "keltainen", 1.0, materiaali3));
			
			User userA = new User("visitor", "$2a$10$CNtWfYa4H23FSGxh55eC/exvoJWXvej74l31akkhf6FSOjo9w8W0e", "VISITOR");
			User userB = new User("admin", "$2a$10$YQoLOzyX1auv9/GydM4IA.lJBzn2wK65hrDPq2LLRI9us1GNEHhhC", "ADMIN");
			urepository.save(userA);
			urepository.save(userB);
			
			
			log.info("hae kaikki langat");
			for (Lanka lanka : lrepository.findAll()) {
				log.info(lanka.toString());
			}
		};
	}

}
