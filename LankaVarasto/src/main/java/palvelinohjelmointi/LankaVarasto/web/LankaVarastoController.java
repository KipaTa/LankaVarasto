package palvelinohjelmointi.LankaVarasto.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.LankaVarasto.domain.Lanka;

@Controller
public class LankaVarastoController {

		@RequestMapping(value = "/langat", method = RequestMethod.GET)
		public String getLangat(Model model) {
			List<Lanka> langat = new ArrayList<Lanka>();
			langat.add(new Lanka ("Nalle", "Novita", 200, "musta", 1.0));
			langat.add(new Lanka ("Seitsemän veljestä", "Novita", 500, "punainen", 2.0));
			model.addAttribute("langat", langat);
			return "lankalista";
		}
		
		@RequestMapping(value = "/lisaalanka", method = RequestMethod.GET)
		public String getNewLanka(Model model) {
			model.addAttribute("lanka", new Lanka());
			return "lankalomake";
		}
		
		@RequestMapping(value = "/tallennalanka", method = RequestMethod.POST)
		public String saveLanka(@ModelAttribute Lanka lanka, Model model) {
			model.addAttribute("lanka", lanka);
			return "lankalisays";
		}
		
}
