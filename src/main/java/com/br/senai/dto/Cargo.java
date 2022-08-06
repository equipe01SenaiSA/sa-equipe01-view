package com.br.senai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(onlyExplicitlyIncluded = true)
public class Cargo {

	    @EqualsAndHashCode.Include
	    private Integer id;
	    
	    @ToString.Include
	    private String descricaoCurta;

}
