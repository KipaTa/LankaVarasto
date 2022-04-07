package palvelinohjelmointi.LankaVarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import palvelinohjelmointi.LankaVarasto.domain.Materiaali;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;

@CrossOrigin
@Controller
public class MateriaaliController {
	
	@Autowired
	private MateriaaliRepository mRepository;
	
	@RequestMapping(value = "/materiaalilista", method = RequestMethod.GET)
	public String materiaaliLista(Model model) {
		model.addAttribute("materiaalit", mRepository.findAll());
		return "materiaalilista";
	}
	
	@RequestMapping(value = "/addmateriaali")
	public String addMateriaali(Model model) {
		model.addAttribute("materiaali", new Materiaali());
		return "";
	}
	
	@RequestMapping(value = "/savemateriaali", method = RequestMethod.POST)
	public String save(Materiaali materiaali) {
		mRepository.save(materiaali);
		return "redirect:/materiaalilista";
	}
	

}
