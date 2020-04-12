package br.com.mensageriaspringmvc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mensageriaspringmvc.model.MensagemEmailEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemEmailNovoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemNotificacaoNovoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsEdicaoModel;
import br.com.mensageriaspringmvc.model.MensagemSmsNovoModel;

@Service
public class MensagemService {

	@Autowired
	private RestTemplate rest;
	private String uri = "http://localhost:8089/v1/api/";

	public ResponseEntity<Object> adicionarMensagemEmail(MensagemEmailNovoModel mensagemEmailNovoModel, Integer id) {
		
		String endPoint = uri +"agendamentos/" + id +"/mensagens";
		HttpEntity<MensagemEmailNovoModel> request = new HttpEntity<>(mensagemEmailNovoModel);
		ResponseEntity<Object> result = rest.postForEntity(endPoint, request, Object.class);	
		return result;
	}

	public ResponseEntity<Object> editarMensagemEmail(Integer id, MensagemEmailEdicaoModel mensagemEmailEdicaoModel) {

		String endPoint = uri + "agendamentos/mensagens/" + id;
		mensagemEmailEdicaoModel.setId(id);

		HttpEntity<MensagemEmailEdicaoModel> request = new HttpEntity<>(mensagemEmailEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		return result;
	}
	
	public ResponseEntity<Object> adicionarMensagemSms(MensagemSmsNovoModel mensagemSmsNovoModel, Integer id) {
		
		String endPoint = uri +"agendamentos/" + id +"/mensagens";
		HttpEntity<MensagemSmsNovoModel> request = new HttpEntity<>(mensagemSmsNovoModel);
		ResponseEntity<Object> result = rest.postForEntity(endPoint, request, Object.class);	
		return result;
	}

	public ResponseEntity<Object> editarMensagemSms(Integer id, MensagemSmsEdicaoModel mensagemSmsEdicaoModel) {

		String endPoint = uri + "agendamentos/mensagens/" + id;
		mensagemSmsEdicaoModel.setId(id);

		HttpEntity<MensagemSmsEdicaoModel> request = new HttpEntity<>(mensagemSmsEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		return result;
	}
	
	public ResponseEntity<Object> adicionarMensagemNotificacao(MensagemNotificacaoNovoModel mensagemNotificacaoNovoModel, Integer id) {
		
		String endPoint = uri +"agendamentos/" + id +"/mensagens";
		HttpEntity<MensagemNotificacaoNovoModel> request = new HttpEntity<>(mensagemNotificacaoNovoModel);
		ResponseEntity<Object> result = rest.postForEntity(endPoint, request, Object.class);	
		return result;
	}

	public ResponseEntity<Object> editarMensagemNotificacao(Integer id, MensagemNotificacaoEdicaoModel mensagemNotificacaoEdicaoModel) {

		String endPoint = uri + "agendamentos/mensagens/" + id;
		mensagemNotificacaoEdicaoModel.setId(id);

		HttpEntity<MensagemNotificacaoEdicaoModel> request = new HttpEntity<>(mensagemNotificacaoEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		return result;
	}

	public ResponseEntity<Object> removerMensagem(Integer id) {
		
		String endPoint = uri + "agendamentos/mensagens/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);	
		return result;
	}

	public ResponseEntity<Object> obterUmMensagem(Integer id) {
		String endPoint = uri + "agendamentos/mensagens/" + id;
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);
		return response;
	}
	
}
