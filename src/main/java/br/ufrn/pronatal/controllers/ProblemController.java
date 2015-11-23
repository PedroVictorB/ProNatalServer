package br.ufrn.pronatal.controllers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.pronatal.Util.HibernateUtil;
import br.ufrn.pronatal.models.Problem;
import br.ufrn.pronatal.services.ProblemDAO;

@RestController
@RequestMapping("/marcador") 
public class ProblemController {
	
	private ProblemDAO dao = new ProblemDAO();
	
    @RequestMapping("/inserir")
    public String inserir(@RequestParam("titulo") String titulo,
			    		@RequestParam("descricao") String descricao,
			    		@RequestParam("tipo") String tipo,
			    		@RequestParam("data") Date data,
			    		@RequestParam("latitude") double latitude,
			    		@RequestParam("longitude") double longitude) {
    	Problem m = new Problem();
    	m.setTitulo(titulo);
    	m.setDescricao(descricao);
    	m.setTipo(tipo);
    	m.setDate(data);
    	m.setLatitude(latitude);
    	m.setLongitude(longitude);
         
    	if(dao.insertProblem(m)){
    		return ""+m.getId();
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
         Problem m = new Problem();
         m.setId(id);
    	if(dao.deleteProblem(m)){
    		return ""+id;
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/marker/{id}")
    public String ler(@PathVariable int id) {
         Problem m = new Problem();
         m.setId(id);
    	if(dao.readProblem(id)){
    		return ""+id;
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/atualizar")
    public String atualizar(@RequestParam("titulo") String titulo,
			    		@RequestParam("descricao") String descricao,
			    		@RequestParam("tipo") String tipo,
			    		@RequestParam("data") Date data,
			    		@RequestParam("latitude") double latitude,
			    		@RequestParam("longitude") double longitude) {
    	Problem m = new Problem();
    	m.setTitulo(titulo);
    	m.setDescricao(descricao);
    	m.setTipo(tipo);
    	m.setDate(data);
    	m.setLatitude(latitude);
    	m.setLongitude(longitude);
         
    	if(dao.updateProblem(m)){
    		return ""+m.getId();
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/markers")
    public String lista() {
         List<Problem> l = dao.readAllProblem();
    	if(l != null){
    		String t = "";
    		for(Problem m : l){
    			t += ""+m.getId()+"<br/>";
    		}
    		return t;
    	}
        
        return "Erro.";
    }
}
