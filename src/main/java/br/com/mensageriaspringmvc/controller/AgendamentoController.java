package br.com.mensageriaspringmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.mensageriaspringmvc.model.AgendamentoEdicaoModel;
import br.com.mensageriaspringmvc.model.AgendamentoNovoModel;
import br.com.mensageriaspringmvc.services.AgendamentoService;


@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@RequestMapping(value="/agendamento-novo", method= RequestMethod.GET)
	public String agendamentoNovo() {        
		return "agendamento/agendamento-novo";
	}
	
	@RequestMapping(value="/agendamento-novo", method= RequestMethod.POST)
	public String agendamentoNovoSubmit(AgendamentoNovoModel agendamentoNovoModel) {

		var result= agendamentoService.adicionar(agendamentoNovoModel);
		
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-novo";		
	}
	
	@RequestMapping(value="/agendamentos", method= RequestMethod.GET)
	public String agendamentos(Model model) {   
		
		var response= agendamentoService.obterTodos();	
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
		
		var response= agendamentoService.obterTodos();		
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
		
		var response= agendamentoService.obterUm(id);
		if(response.getStatusCodeValue() == 200)
		{
			model.addAttribute("agendamento", response.getBody());      	
		}
		
		return "agendamento/agendamento-edicao";	
	}
	
	@RequestMapping(value="/agendamento-edicao/{id}", method= RequestMethod.POST)
	public String agendamentoEdicaoSubmit(@PathVariable Integer id, AgendamentoEdicaoModel agendamentoEdicaoModel) {
			
		var result= agendamentoService.editar(id, agendamentoEdicaoModel);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-edicao/"+id;		
	}
	
	@RequestMapping(value="/agendamento-remocao/{id}", method= RequestMethod.GET)
	public String agendamentoDeleteSubmit(@PathVariable Integer id) {
		
		var result= agendamentoService.remover(id);
		if(result.getStatusCodeValue() == 200)
			return "redirect:/agendamentos";
		else
			return "redirect:/agendamento-remocao/"+id;		
	}
}
