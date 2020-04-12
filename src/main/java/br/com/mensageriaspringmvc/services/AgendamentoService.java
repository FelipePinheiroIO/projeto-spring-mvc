package br.com.mensageriaspringmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import br.com.mensageriaspringmvc.model.AgendamentoEdicaoModel;
import br.com.mensageriaspringmvc.model.AgendamentoNovoModel;

@Service
public class AgendamentoService {

	@Autowired
	private RestTemplate rest;
	private String uri = "http://localhost:8089/v1/api/";

	public ResponseEntity<String> adicionar(AgendamentoNovoModel agendamentoNovoModel) {
		
		String endPoint = uri + "agendamentos";

		HttpEntity<AgendamentoNovoModel> request = new HttpEntity<>(agendamentoNovoModel);
		ResponseEntity<String> result = rest.postForEntity(endPoint, request, String.class);
		return result;
	}

	public ResponseEntity<Object> editar(Integer id, AgendamentoEdicaoModel agendamentoEdicaoModel) {
		
		String endPoint = uri + "agendamentos/" + id;
		agendamentoEdicaoModel.setId(id);

		HttpEntity<AgendamentoEdicaoModel> request = new HttpEntity<>(agendamentoEdicaoModel);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.PUT, request, Object.class);	
		return result;
	}

	public ResponseEntity<Object> remover(Integer id) {
		String endPoint = uri + "agendamentos/" + id;

		HttpEntity<Object> request = new HttpEntity<>(Object.class);
		ResponseEntity<Object> result = rest.exchange(endPoint, HttpMethod.DELETE, request, Object.class);
		return result;
	}

	public ResponseEntity<Object> obterUm(Integer id) {
		
		String endPoint = uri + "agendamentos/" + id;	
		ResponseEntity<Object> response = rest.getForEntity(endPoint, Object.class);
		return response;
	}
	
	public ResponseEntity<Object[]> obterTodos() {
		
		String endPoint = uri + "agendamentos";
		ResponseEntity<Object[]> response =  rest.getForEntity(endPoint, Object[].class);
		return response;
	}
}
