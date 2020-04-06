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

import br.com.mensageriaspringmvc.model.AgendamentoEdicaoModel;
import br.com.mensageriaspringmvc.model.AgendamentoNovoModel;


@Controller
public class AgendamentoController {

	private RestTemplate rest = new RestTemplate();
	private String uri = "http://localhost:8089/v1/api/";
	
	@RequestMapping(value="/agendamento-novo", method= RequestMethod.GET)
	public String agendamentoNovo() {        
		return "agendamento/agendamento-novo";
	}
	
	@RequestMapping(value="/agendamento-novo", method= RequestMethod.POST)
	public String agendamentoNovoSubmit(AgendamentoNovoModel agendamentoNovoModel) {

		String endPoint = uri + "agendamentos";

		HttpEntity<AgendamentoNovoModel> request = new HttpEntity<>(agendamentoNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-novo";		
	}
	
	@RequestMapping(value="/agendamentos", method= RequestMethod.GET)
	public String agendamentos(Model model) {   
		
		String endPoint = uri + "agendamentos";
		
		ResponseEntity<Object[]> response =  rest.getForEntity(endPoint, Object[].class);
		
		if(response.getStatusCodeValue() == 200)
		{
			if(response.getBody().length > 0)
				model.addAttribute("agendamentos", response.getBody());   
			else
				model.addAttribute("agendamentos", null);
		}

		return "agendamento/agendamentos";
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String agendamentosRaiz(Model model) {   
		
		String endPoint = uri + "agendamentos";
		
		ResponseEntity<Object[]> response =  rest.getForEntity(endPoint, Object[].class);
		
		if(response.getStatusCodeValue() == 200)
		{
			if(response.getBody().length > 0)
				model.addAttribute("agendamentos", response.getBody());   
			else
				model.addAttribute("agendamentos", null);
		}

		return "agendamento/agendamentos";
	}
	
	
	@RequestMapping(value="/agendamento-edicao/{id}", method= RequestMethod.GET)
	public String agendamentoEdicao(Model model, @PathVariable Integer id) {

		String endPoint = uri + "agendamentos/" + id;
		
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);

		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("agendamento", response.getBody());      	
		}
		
		return "agendamento/agendamento-edicao";	
	}
	
	@RequestMapping(value="/agendamento-edicao/{id}", method= RequestMethod.POST)
	public String agendamentoEdicaoSubmit(@PathVariable Integer id, AgendamentoEdicaoModel agendamentoEdicaoModel) {
		
		String endPoint = uri + "agendamentos/" + id;
		agendamentoEdicaoModel.setId(id);

		HttpEntity<AgendamentoEdicaoModel> request = new HttpEntity<>(agendamentoEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-edicao/"+id;		
	}
	
	@RequestMapping(value="/agendamento-remocao/{id}", method= RequestMethod.GET)
	public String agendamentoDeleteSubmit(@PathVariable Integer id) {
		
		String endPoint = uri + "agendamentos/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-remocao/"+id;		
	}
}
