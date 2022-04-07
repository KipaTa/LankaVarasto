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

@SpringBootApplication
public class LankaVarastoApplication {
	private static final Logger log = LoggerFactory.getLogger(LankaVarastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LankaVarastoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner lankaDemo(LankaRepository lrepository, MateriaaliRepository mrepository) {
		return (args) -> {
				
			log.info("lisää pari lankaa");
			
			Materiaali materiaali1 = new Materiaali("100% Villa");
			mrepository.save(materiaali1);
			Materiaali materiaali2 = new Materiaali("75 % villa, 25 % polyamidi");
			mrepository.save(materiaali2);
			
			
			lrepository.save(new Lanka("Nalle", "Novita", 200, "musta", 1.0, materiaali2));
			lrepository.save(new Lanka("Seitsemän veljestä", "Novita", 500, "punainen", 2.0, materiaali2));
			
			log.info("hae kaikki langat");
			for (Lanka lanka : lrepository.findAll()) {
				log.info(lanka.toString());
			}
		};
	}

}
