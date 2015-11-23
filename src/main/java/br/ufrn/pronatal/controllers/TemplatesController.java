package br.ufrn.pronatal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplatesController { 
	@RequestMapping("/")
    public String greeting(Model model) {
		model.addAttribute("app", "ProNatal API");
        return "teste";
    }
}
