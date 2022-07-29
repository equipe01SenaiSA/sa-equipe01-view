package com.br.senai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo {

	    @EqualsAndHashCode.Include
	    private Integer id;

	    private String descricaoCurta;

}
