package br.ufrn.pronatal.controllers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.pronatal.Util.HibernateUtil;
import br.ufrn.pronatal.models.Marker;
import br.ufrn.pronatal.services.MarkerDAO;

@RestController
@Component
@RequestMapping("/marcador")
public class MarkerController {
	
	private MarkerDAO dao = new MarkerDAO();
	
    @RequestMapping("/inserir")
    public String inserir(@RequestParam("titulo") String titulo,
			    		@RequestParam("descricao") String descricao,
			    		@RequestParam("tipo") String tipo,
			    		@RequestParam("data") Date data,
			    		@RequestParam("latitude") double latitude,
			    		@RequestParam("longitude") double longitude) {
    	Marker m = new Marker();
    	m.setTitulo(titulo);
    	m.setDescricao(descricao);
    	m.setTipo(tipo);
    	m.setDate(data);
    	m.setLatitude(latitude);
    	m.setLongitude(longitude);
         
    	if(dao.insertMarker(m)){
    		return ""+m.getId();
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
         Marker m = new Marker();
         m.setId(id);
    	if(dao.deleteMarker(m)){
    		return ""+id;
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/marker/{id}")
    public String ler(@PathVariable int id) {
         Marker m = new Marker();
         m.setId(id);
    	if(dao.readMarker(id)){
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
    	Marker m = new Marker();
    	m.setTitulo(titulo);
    	m.setDescricao(descricao);
    	m.setTipo(tipo);
    	m.setDate(data);
    	m.setLatitude(latitude);
    	m.setLongitude(longitude);
         
    	if(dao.updateMarker(m)){
    		return ""+m.getId();
    	}
        
        return "Erro.";
    }
    
    @RequestMapping("/markers")
    public String lista() {
         List<Marker> l = dao.readAllMarker();
    	if(l != null){
    		String t = "";
    		for(Marker m : l){
    			t += ""+m.getId()+"<br/>";
    		}
    		return t;
    	}
        
        return "Erro.";
    }
}
