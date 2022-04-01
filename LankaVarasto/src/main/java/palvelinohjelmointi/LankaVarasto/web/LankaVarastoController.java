package palvelinohjelmointi.LankaVarasto.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.LankaVarasto.domain.Lanka;
import palvelinohjelmointi.LankaVarasto.domain.LankaRepository;

@Controller
public class LankaVarastoController {
	
		@Autowired
		private LankaRepository lrepository;

		@RequestMapping(value = "/lankalista", method = RequestMethod.GET)
		public String getLangat(Model model) {
			model.addAttribute("langat", lrepository.findAll());
			return "lankalista";
		}
		
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String addLanka(Model model) {
			model.addAttribute("lanka", new Lanka());
			return "lankalomake";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveLanka(Lanka lanka) {
			lrepository.save(lanka);
			return "redirect:/lankalista";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteLanka(@PathVariable("id") Long id, Model model) {
			lrepository.deleteById(id);
			return "redirect:../lankalista";
		}
		
		@RequestMapping(value = "/edit/{id}")
			public String editLanka(@PathVariable("id") Long id, Model model) {
			model.addAttribute("lanka", lrepository.findById(id));
			return "editlanka";
		}
}
