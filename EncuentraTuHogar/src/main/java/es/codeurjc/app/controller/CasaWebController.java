package es.codeurjc.app.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.codeurjc.app.entity.Casa;
import es.codeurjc.app.service.CasaService;

@Controller
public class CasaWebController {

	@Autowired
	private CasaService service;

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();

		if(principal != null) {
		
			model.addAttribute("logged", true);		
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			
		} else {
			model.addAttribute("logged", false);
		}
	}

	@GetMapping("/")
	public String showCasas(Model model) {

		model.addAttribute("casas", service.findAll());

		return "casas";
	}

	@GetMapping("/casas/{id}")
	public String showCasa(Model model, @PathVariable long id) {

		Optional<Casa> casa = service.findById(id);
		if (casa.isPresent()) {
			model.addAttribute("casa", casa.get());
			return "casa";
		} else {
			return "casas";
		}

	}

	@GetMapping("/removecasa/{id}")
	public String removeCasa(Model model, @PathVariable long id) {

		Optional<Casa> casa = service.findById(id);
		if (casa.isPresent()) {
			service.delete(id);
			model.addAttribute("casa", casa.get());
		}
		return "removedcasa";
	}

	@GetMapping("/newcasa")
	public String newCasa(Model model) {

		return "newCasaPage";
	}

	@PostMapping("/newcasa")
	public String newCasaProcess(Model model, Casa casa) {

		service.save(casa);
		
		model.addAttribute("casaId",casa.getId());

		return "casaCreated";
	}

	@GetMapping("/editcasa/{id}")
	public String editCasa(Model model, @PathVariable long id) {

		Optional<Casa> casa = service.findById(id);
		if (casa.isPresent()) {
			model.addAttribute("casa", casa.get());
			return "editcasaPage";
		} else {
			return "casas";
		}
	}

	@PostMapping("/editcasa")
	public String editCasaProcess(Model model, Casa casa) {

		service.save(casa);
		
		model.addAttribute("casaId",casa.getId());

		return "casaEdited";
	}

}
