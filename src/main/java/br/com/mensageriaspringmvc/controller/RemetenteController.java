package br.com.mensageriaspringmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mensageriaspringmvc.model.RemetenteEdicaoModel;
import br.com.mensageriaspringmvc.model.RemetenteNovoModel;
import br.com.mensageriaspringmvc.services.RemetenteService;

@Controller
public class RemetenteController {

	@Autowired
	private RemetenteService remetenteService;
	
	@RequestMapping(value="agendamentos/{id}/remetente-novo", method= RequestMethod.GET)
	public String remetenteNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "remetente/remetente-novo";
	}
	
	@RequestMapping(value="agendamentos/{id}/remetente-novo", method= RequestMethod.POST)
	public String remetenteNovoSubmit(RemetenteNovoModel remetenteNovoModel, @PathVariable Integer id) {

		var result= remetenteService.adicionar(remetenteNovoModel, id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/remetente-novo";		
	}
	
	@RequestMapping(value="agendamentos/remetente-edicao/{id}", method= RequestMethod.GET)
	public String remetenteEdicao(Model model, @PathVariable Integer id) {

		var response= remetenteService.obterUm(id);
		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("remetente", response.getBody());      	
		}
		
		return "remetente/remetente-edicao";	
	}
	
	@RequestMapping(value="agendamentos/remetente-edicao/{id}", method= RequestMethod.POST)
	public String remetenteEdicaoSubmit(@PathVariable Integer id, RemetenteEdicaoModel remetenteEdicaoModel) {
		
		var result= remetenteService.editar(id, remetenteEdicaoModel);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/remetente-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/{idAgendamento}/remetente-remocao/{id}", method= RequestMethod.GET)
	public String remetenteDeleteSubmit(@PathVariable Integer idAgendamento, @PathVariable Integer id) {
		
		var result= remetenteService.remover(idAgendamento, id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/remetente-remocao/"+id;		
	}
}
