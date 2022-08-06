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

import com.br.senai.dto.Cargo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CargoClient {

	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/cargos";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Cargo inserir(
			Cargo novoCargo) {
		
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoCargo);
		
		Cargo cargoSalvo =  httpClient
				.getForObject(urlEndpoint + uri.getPath(), 
						Cargo.class);
		
		return cargoSalvo;
		
	}
	
	public void alterar(Cargo cargoSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				cargoSalvo);
	}
	
	public void excluir(Cargo cargoSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + cargoSalvo.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> listarPor(String descricaoCurta){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/descricao-curta/" + descricaoCurta, List.class);
		
		List<Cargo> cargos = new ArrayList<Cargo>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Cargo cargo = mapper.convertValue(item, Cargo.class);
			cargos.add(cargo);
		}
		
		return cargos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> listAllCargos(){
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/findAll", List.class);
		
		List<Cargo> cargos = new ArrayList<Cargo>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Cargo cargo = mapper.convertValue(item, Cargo.class);
			cargos.add(cargo);
		}
		
		return cargos;
	}
}
