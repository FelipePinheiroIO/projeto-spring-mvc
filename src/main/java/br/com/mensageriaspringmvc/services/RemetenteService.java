package br.com.mensageriaspringmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mensageriaspringmvc.model.RemetenteEdicaoModel;
import br.com.mensageriaspringmvc.model.RemetenteNovoModel;

@Service
public class RemetenteService {

	@Autowired
	private RestTemplate rest;
	private String uri = "http://localhost:8089/v1/api/";

	public ResponseEntity<String> adicionar(RemetenteNovoModel remetenteNovoModel, Integer id) {
		
		String endPoint = uri +"agendamentos/" + id +"/remetentes";
		HttpEntity<RemetenteNovoModel> request = new HttpEntity<>(remetenteNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);	
		return result;
	}

	public ResponseEntity<Object> editar(Integer id, RemetenteEdicaoModel remetenteEdicaoModel) {
		String endPoint = uri + "agendamentos/remetentes/" + id;
		remetenteEdicaoModel.setId(id);

		HttpEntity<RemetenteEdicaoModel> request = new HttpEntity<>(remetenteEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);
		return result;
	}

	public ResponseEntity<Object> remover(Integer idAgendamento, Integer id) {
		
		String endPoint = uri + "agendamentos/"+idAgendamento+"/remetentes/" + id;
		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		return result;
	}

	public ResponseEntity<Object> obterUm(Integer id) {
		
		String endPoint = uri + "agendamentos/remetentes/" + id;	
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);
		return response;
	}
}
