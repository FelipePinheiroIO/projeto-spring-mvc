package br.com.mensageriaspringmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mensageriaspringmvc.model.MensagemEmailEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemEmailNovoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoNovoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsNovoModel;
import br.com.mensageriaspringmvc.services.MensagemService;

@Controller
public class MensagemController {

	@Autowired
	private MensagemService mensagemService;
	
	@RequestMapping(value="agendamentos/{id}/mensagem-email-novo", method= RequestMethod.GET)
	public String mensagemEmailNovo(Model model, @PathVariable Integer id) {   
		
		model.addAttribute("idAgendamento", id); 
		return "mensagem/mensagem-email-novo";
	}
	
	@RequestMapping(value="agendamentos/{id}/mensagem-email-novo", method= RequestMethod.POST)
	public String mensagemEmailNovoSubmit(MensagemEmailNovoModel mensagemEmailNovoModel, @PathVariable Integer id) {

		var result= mensagemService.adicionarMensagemEmail(mensagemEmailNovoModel, id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-email-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-edicao/{id}", method= RequestMethod.GET)
	public String mensagemEmailEdicao(Model model, @PathVariable Integer id) {

		var response = mensagemService.obterUmMensagem(id);
		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-email-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-edicao/{id}", method= RequestMethod.POST)
	public String mensagemEmailEdicaoSubmit(@PathVariable Integer id, MensagemEmailEdicaoModel mensagemEmailEdicaoModel) {
			
		var result = mensagemService.editarMensagemEmail(id, mensagemEmailEdicaoModel);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-email-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-email-remocao/{id}", method= RequestMethod.GET)
	public String mensagemEmailDeleteSubmit(@PathVariable Integer id) {
			
		var result= mensagemService.removerMensagem(id);
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

		var result= mensagemService.adicionarMensagemSms(mensagemSmsNovoModel, id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-sms-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-edicao/{id}", method= RequestMethod.GET)
	public String mensagemSmsEdicao(Model model, @PathVariable Integer id) {

		var response= mensagemService.obterUmMensagem(id);
		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-sms-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-edicao/{id}", method= RequestMethod.POST)
	public String mensagemSmsEdicaoSubmit(@PathVariable Integer id, MensagemSmsEdicaoModel mensagemSmsEdicaoModel) {
		
		var result= mensagemService.editarMensagemSms(id, mensagemSmsEdicaoModel);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-sms-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-sms-remocao/{id}", method= RequestMethod.GET)
	public String mensagemSmsDeleteSubmit(@PathVariable Integer id) {
		
		var result= mensagemService.removerMensagem(id);
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
		
		var result= mensagemService.adicionarMensagemNotificacao(mensagemNotificacaoNovoModel, id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/" + id +"/mensagem-notificacao-novo";		
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-edicao/{id}", method= RequestMethod.GET)
	public String mensagemNotificacaoEdicao(Model model, @PathVariable Integer id) {

		var response= mensagemService.obterUmMensagem(id);
		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("mensagem", response.getBody());      	
		}
		
		return "mensagem/mensagem-notificacao-edicao";	
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-edicao/{id}", method= RequestMethod.POST)
	public String mensagemNotificacaoEdicaoSubmit(@PathVariable Integer id, MensagemNotificacaoEdicaoModel mensagemNotificacaoEdicaoModel) {
		
		var result= mensagemService.editarMensagemNotificacao(id, mensagemNotificacaoEdicaoModel);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-notificacao-edicao/"+id;		
	}
	
	@RequestMapping(value="agendamentos/mensagem-notificacao-remocao/{id}", method= RequestMethod.GET)
	public String mensagemNotificacaoDeleteSubmit(@PathVariable Integer id) {
		
		var result= mensagemService.removerMensagem(id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamentos/mensagem-notificacao-remocao/"+id;		
	}
}
