package com.br.senai.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.senai.dto.Colaborador;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ColaboradorClient {

	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/colaboradores";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Colaborador inserir(
			Colaborador novoColaborador) {
		
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoColaborador);
		
		Colaborador colaboradorSalvo =  httpClient
				.getForObject(urlEndpoint + uri.getPath(), 
						Colaborador.class);
		
		return colaboradorSalvo;
		
	}
	
	public void alterar(Colaborador colaboradorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				colaboradorSalvo);
	}
	
	public void excluir(Colaborador colaboradorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + colaboradorSalvo.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Colaborador> listarPor(String nomeCompleto){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/nome-completo/" + nomeCompleto, List.class);
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Colaborador colaborador = mapper.convertValue(item, Colaborador.class);
			colaboradores.add(colaborador);
		}
		
		return colaboradores;
	}
}
