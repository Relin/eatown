package be.relin.eatown.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.relin.eatown.bean.Resto;

@Controller
public class SpringTilesController {

	@RequestMapping(value="index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="viewResto")
	public ModelAndView viewResto(Model model) {
		Map<String, List<Resto>> resto = 
				new HashMap<String, List<Resto>>();
		resto.put("resto", Resto.recuperationResto());
		return new ModelAndView("restoList", resto);
	}
}
