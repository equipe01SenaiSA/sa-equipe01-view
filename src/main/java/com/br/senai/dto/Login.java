package com.br.senai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Login {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String login;
	
	private String senha;

}
