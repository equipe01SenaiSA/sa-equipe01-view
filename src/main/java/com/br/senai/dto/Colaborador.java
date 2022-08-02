package com.br.senai.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Colaborador {
	
	@EqualsAndHashCode.Include
    private Integer id;

    private String nomeCompleto;

    private String cpf;

    private LocalDate dataDeAdmissao;

    private String rg;

    private String nomeDaMae;

    private Usuario usuario;
}
