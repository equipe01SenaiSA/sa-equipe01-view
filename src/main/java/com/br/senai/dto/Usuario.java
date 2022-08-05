package com.br.senai.dto;

import com.br.senai.enuns.EnumPerfil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Usuario {
	
	@EqualsAndHashCode.Include
	private Integer id;

	private String nomeCompleto;

	private String login;

	private String senha;

	private EnumPerfil perfil;
}
