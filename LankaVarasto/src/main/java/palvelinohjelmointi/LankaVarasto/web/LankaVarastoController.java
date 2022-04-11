package palvelinohjelmointi.LankaVarasto.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.LankaVarasto.domain.Lanka;
import palvelinohjelmointi.LankaVarasto.domain.LankaRepository;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;

@Controller
public class LankaVarastoController {
	
		@Autowired
		private LankaRepository lrepository;
		@Autowired
		private MateriaaliRepository mrepository;

		@RequestMapping(value = {"/", "/lankalista"}, method = RequestMethod.GET)
		public String getLangat(Model model) {
			model.addAttribute("langat", lrepository.findAll());
			return "lankalista";
		}
		
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String addLanka(@Valid Lanka nimi, BindingResult bindingResult,Model model) {
			model.addAttribute("lanka", new Lanka());
			model.addAttribute("materiaalit", mrepository.findAll());
			return "lankalomake";
		}
	
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveLanka(@Valid Lanka nimi, BindingResult bindingResult, Lanka lanka) {
			if (bindingResult.hasErrors()) {
				return "lankalomake";
			} else {lrepository.save(lanka);
			return "redirect:/lankalista";
		}
		}
		
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteLanka(@PathVariable("id") Long id, Model model) {
			lrepository.deleteById(id);
			return "redirect:../lankalista";
		}
		
		@RequestMapping(value = "/edit/{id}")
		@PreAuthorize("hasAuthority('ADMIN')")
			public String editLanka(@PathVariable("id") Long id, Model model) {
			model.addAttribute("lanka", lrepository.findById(id));
			model.addAttribute("materiaali", mrepository.findAll());
			return "editlanka";
		}
}
