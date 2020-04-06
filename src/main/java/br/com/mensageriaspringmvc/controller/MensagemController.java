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

import br.com.mensageriaspringmvc.model.MensagemEmailEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemEmailNovoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoNovoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsNovoModel;

@Controller
public class MensagemController {

	private RestTemplate rest = new RestTemplate();
	private String uri = "http://localhost:8089/v1/api/agendamentos";
	
	@RequestMapping(value="agendamentos/{id}/mensagem-email-novo", method= RequestMethod.GET)
	public String mensagemEmailNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "mensagem/mensagem-email-novo";
	}
	
	@RequestMapping(value="agendamentos/{id}/mensagem-email-novo", method= RequestMethod.POST)
	public String mensagemEmailNovoSubmit(MensagemEmailNovoModel mensagemEmailNovoModel, @PathVariable Integer id) {

		String endPoint = uri +"/" + id +"/mensagens";

		HttpEntity<MensagemEmailNovoModel> request = new HttpEntity<>(mensagemEmailNovoModel);
		ResponseEntity<Object> result = rest.postForEntity(endPoint, request, Object.class);
	
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-email-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-edicao/{id}", method= RequestMethod.GET)
	public String mensagemEmailEdicao(Model model, @PathVariable Integer id) {

		String endPoint = uri + "/mensagens/" + id;
		
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);

		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-email-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-edicao/{id}", method= RequestMethod.POST)
	public String mensagemEmailEdicaoSubmit(@PathVariable Integer id, MensagemEmailEdicaoModel mensagemEmailEdicaoModel) {
		
		String endPoint = uri + "/mensagens/" + id;
		mensagemEmailEdicaoModel.setId(id);

		HttpEntity<MensagemEmailEdicaoModel> request = new HttpEntity<>(mensagemEmailEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-email-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-remocao/{id}", method= RequestMethod.GET)
	public String mensagemEmailDeleteSubmit(@PathVariable Integer id) {
		
		String endPoint = uri + "/mensagens/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-email-remocao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/{id}/mensagem-sms-novo", method= RequestMethod.GET)
	public String mensagemSmsNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "mensagem/mensagem-sms-novo";
	}
	
	@RequestMapping(value="/agendamentos/{id}/mensagem-sms-novo", method= RequestMethod.POST)
	public String mensagemSmsNovoSubmit(MensagemSmsNovoModel mensagemSmsNovoModel, @PathVariable Integer id) {

		String endPoint = uri +"/" + id +"/mensagens";

		HttpEntity<MensagemSmsNovoModel> request = new HttpEntity<>(mensagemSmsNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);
		System.out.println(result);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-sms-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-edicao/{id}", method= RequestMethod.GET)
	public String mensagemSmsEdicao(Model model, @PathVariable Integer id) {

		String endPoint = uri + "/mensagens/" + id;
		
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);

		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-sms-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-edicao/{id}", method= RequestMethod.POST)
	public String mensagemSmsEdicaoSubmit(@PathVariable Integer id, MensagemSmsEdicaoModel mensagemSmsEdicaoModel) {
		
		String endPoint = uri + "/mensagens/" + id;
		mensagemSmsEdicaoModel.setId(id);

		HttpEntity<MensagemSmsEdicaoModel> request = new HttpEntity<>(mensagemSmsEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-sms-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-remocao/{id}", method= RequestMethod.GET)
	public String mensagemSmsDeleteSubmit(@PathVariable Integer id) {
		
		String endPoint = uri + "/mensagens/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-sms-remocao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/{id}/mensagem-notificacao-novo", method= RequestMethod.GET)
	public String mensagemNotificacaoNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "mensagem/mensagem-notificacao-novo";
	}
	
	@RequestMapping(value="agendamentos/{id}/mensagem-notificacao-novo", method= RequestMethod.POST)
	public String mensagemNotificacaoNovoSubmit(MensagemNotificacaoNovoModel mensagemNotificacaoNovoModel, @PathVariable Integer id) {

		String endPoint = uri +"/" + id +"/mensagens";

		HttpEntity<MensagemNotificacaoNovoModel> request = new HttpEntity<>(mensagemNotificacaoNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-notificacao-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-edicao/{id}", method= RequestMethod.GET)
	public String mensagemNotificacaoEdicao(Model model, @PathVariable Integer id) {

		String endPoint = uri + "/mensagens/" + id;
		
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);

		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-notificacao-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-edicao/{id}", method= RequestMethod.POST)
	public String mensagemNotificacaoEdicaoSubmit(@PathVariable Integer id, MensagemNotificacaoEdicaoModel mensagemNotificacaoEdicaoModel) {
		
		String endPoint = uri + "/mensagens/" + id;
		mensagemNotificacaoEdicaoModel.setId(id);

		HttpEntity<MensagemNotificacaoEdicaoModel> request = new HttpEntity<>(mensagemNotificacaoEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-notificacao-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-remocao/{id}", method= RequestMethod.GET)
	public String mensagemNotificacaoDeleteSubmit(@PathVariable Integer id) {
		
		String endPoint = uri + "/mensagens/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-notificacao-remocao/"+id;		
	}
}
