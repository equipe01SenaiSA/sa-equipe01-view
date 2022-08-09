package com.br.senai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.senai.dto.Login;
import com.br.senai.dto.Usuario;

@Component
public class LoginClient {

	@Value("${endpoint}")
	private String urlEndpoint;

	private final String resouce = "/usuarios";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Usuario efetuarPor(String login, String senha) {
		RestTemplate httpClient = builder.build();
		Usuario loginEfetuado = httpClient.getForObject(urlEndpoint + resouce
				+ "?login=" + login
				+ "&senha=" + senha, Usuario.class); 
		
		return loginEfetuado;	
	}
	
}
