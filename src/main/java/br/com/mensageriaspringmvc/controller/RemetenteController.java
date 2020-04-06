package br.com.mensageriaspringmvc.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import br.com.mensageriaspringmvc.model.RemetenteEdicaoModel;
import br.com.mensageriaspringmvc.model.RemetenteNovoModel;

@Controller
public class RemetenteController {

	private RestTemplate rest = new RestTemplate();
	private String uri = "http://localhost:8089/v1/api/agendamentos";
	
	@RequestMapping(value="agendamentos/{id}/remetente-novo", method= RequestMethod.GET)
	public String remetenteNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "remetente/remetente-novo";
	}
	
	@RequestMapping(value="agendamentos/{id}/remetente-novo", method= RequestMethod.POST)
	public String remetenteNovoSubmit(RemetenteNovoModel remetenteNovoModel, @PathVariable Integer id) {

		String endPoint = uri +"/" + id +"/remetentes";

		HttpEntity<RemetenteNovoModel> request = new HttpEntity<>(remetenteNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/remetente-novo";		
	}
	
	@RequestMapping(value="agendamentos/remetente-edicao/{id}", method= RequestMethod.GET)
	public String remetenteEdicao(Model model, @PathVariable Integer id) {

		String endPoint = uri + "/remetentes/" + id;
		
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);

		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("remetente", response.getBody());      	
		}
		
		return "remetente/remetente-edicao";	
	}
	
	@RequestMapping(value="agendamentos/remetente-edicao/{id}", method= RequestMethod.POST)
	public String remetenteEdicaoSubmit(@PathVariable Integer id, RemetenteEdicaoModel remetenteEdicaoModel) {
		
		String endPoint = uri + "/remetentes/" + id;
		remetenteEdicaoModel.setId(id);

		HttpEntity<RemetenteEdicaoModel> request = new HttpEntity<>(remetenteEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/remetente-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/remetente-remocao/{id}", method= RequestMethod.GET)
	public String remetenteDeleteSubmit(@PathVariable Integer id) {
		
		String endPoint = uri + "/remetentes/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/remetente-remocao/"+id;		
	}
}
