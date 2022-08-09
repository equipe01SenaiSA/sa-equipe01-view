package com.br.senai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(onlyExplicitlyIncluded = true)
public class Cargo {

	@EqualsAndHashCode.Include
	private Integer id;

	// @ToString.Include
	private String descricaoCurta;

	@Override
	public String toString() {
		return descricaoCurta;
	}
	
	private String atribuicoes;
}
