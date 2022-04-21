package palvelinohjelmointi.LankaVarasto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.LankaVarasto.domain.Materiaali;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;

@CrossOrigin
@Controller
public class MateriaaliController {
	
	@Autowired
	private MateriaaliRepository mRepository;
	
	//Listaa materiaalit	
	@RequestMapping(value = "/materiaalilista", method = RequestMethod.GET)
	public String materiaaliLista(Model model) {
		model.addAttribute("materiaalit", mRepository.findAll());
		return "materiaalilista";
	}
	
	// Lisää materiaalin
	@RequestMapping(value = "/addmateriaali")
	public String addMateriaali(Model model) {
		model.addAttribute("materiaali", new Materiaali());
		return "lisaamateriaali";
	}
	
	//Tallentaa materiaalin 
	@RequestMapping(value = "/savemateriaali", method = RequestMethod.POST)
	public String save(Materiaali materiaali) {
		mRepository.save(materiaali);
		return "redirect:/materiaalilista";
	}
	
	//RESTful Service kaikille materiaaleille
	@RequestMapping(value="/materiaalit", method = RequestMethod.GET)
	public @ResponseBody List<Materiaali> getMateriaaliRest() {
		return (List<Materiaali>) mRepository.findAll();
	}
	
	//RESTful service materiaalit id:n mukaan
	@RequestMapping(value="/materiaali/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Materiaali> etsiMateriaalitRest(@PathVariable("id") Long mId) {
		return mRepository.findById(mId);
	}
	

}
