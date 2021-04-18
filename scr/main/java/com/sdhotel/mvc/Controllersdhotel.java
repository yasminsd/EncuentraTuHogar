package com.sdhotel.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Controllersdhotel {
	
	@RequestMapping(method=RequestMethod.GET)
	public String procesarHome(ModelMap model) {
		model.addAttribute("mensaje", "Esto es un mensaje desde Controllersdhotel en vista1");
		return "vista1";
	}
	
	@RequestMapping(value="/spring",method=RequestMethod.GET)
	public String procesarPeticion(Map<String, Object> map) {
		map.put("mensaje", "Esto es un mensaje desde Controllersdhotel en vista2");
		return "vista2";
	}
	
	@RequestMapping(value="/springmvc",method=RequestMethod.GET)
	public ModelAndView procesarPeticion() {
		ModelAndView model = new ModelAndView("vista3");
		model.addObject("mensaje", "Esto es un mensaje desde Controllersdhotel en vista3");
		return model;
	}	
}
