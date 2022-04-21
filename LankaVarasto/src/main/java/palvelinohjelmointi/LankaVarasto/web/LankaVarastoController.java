package palvelinohjelmointi.LankaVarasto.web;



import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.LankaVarasto.domain.Lanka;
import palvelinohjelmointi.LankaVarasto.domain.LankaRepository;
import palvelinohjelmointi.LankaVarasto.domain.MateriaaliRepository;


@CrossOrigin
@Controller
public class LankaVarastoController {
	
		@Autowired
		private LankaRepository lrepository;
		@Autowired
		private MateriaaliRepository mrepository;
		
		// Listaa kaikki langat
		@RequestMapping(value = {"/", "/lankalista"}, method = RequestMethod.GET)
		public String getLangat(Model model) {
			model.addAttribute("langat", lrepository.findAll());
			return "lankalista";
		}
		
		//Lisää langan
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String addLanka(@Valid Lanka nimi, BindingResult bindingResult,Model model) {
			model.addAttribute("lanka", new Lanka());
			model.addAttribute("materiaalit", mrepository.findAll());
			return "lankalomake";
		}
	
		//Tallentaa uuden langan tai tallentaa muokkaukset lankaan
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveLanka(@Valid Lanka lanka, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				Long id = lanka.getId();
				if (id == null) {
					return "lankalomake";
				}
				else {
					return "editlanka";
				}
								// if uusi lanka, palataan langan lisäyslomakkeelle (jos id on null)
								//else vanha lanka palataan muokkauslomakkeelle (jos id on olemassa)	
			} else {lrepository.save(lanka);
			return "redirect:/lankalista";
		}
		}
		
		// Poistaa langan id:n perusteella
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		@PreAuthorize("hasAuthority('ADMIN')")
		public String deleteLanka(@PathVariable("id") Long id, Model model) {
			lrepository.deleteById(id);
			return "redirect:../lankalista";
		}
		
		// Muokkaa lankaa id:n perusteella
		@RequestMapping(value = "/edit/{id}")
		@PreAuthorize("hasAuthority('ADMIN')")
			public String editLanka(@PathVariable("id") Long id, Model model) {
			model.addAttribute("lanka", lrepository.findById(id));
			model.addAttribute("materiaalit", mrepository.findAll());
			return "editlanka";
		}
		
		//RESTful service kaikille langoille
		@RequestMapping(value="/langat", method = RequestMethod.GET)
		public @ResponseBody List<Lanka> lankalistaRest() {
			return (List<Lanka>) lrepository.findAll();
		}
		
		//RESTful service langat id:n mukaan
		@RequestMapping(value="/lanka/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Lanka> etsiLankaRest(@PathVariable("id") Long id) {
			return lrepository.findById(id);
		}
}
