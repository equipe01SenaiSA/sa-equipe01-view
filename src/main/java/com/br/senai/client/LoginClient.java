package com.br.senai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.senai.dto.Login;

@Component
public class LoginClient {

	@Value("${endpoint}")
	private String urlEndpoint;

	private final String resouce = "/login";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Login efetuarPor(String login, String senha) {
		RestTemplate httpClient = builder.build();
		Login loginEfetuado = httpClient.getForObject(urlEndpoint + resouce
				+ "login = " + login
				+ "senha = " + senha, Login.class); 
		return loginEfetuado;
		
	}
	
}
