package com.br.senai.dto;

import java.time.LocalDate;

import com.br.senai.enuns.EnumPerfil;

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
    private Cargo cargo;
    
    public Colaborador() {}
    
	public Colaborador(Integer id, String nomeCompleto, String cpf, LocalDate dataDeAdmissao, String rg,
			String nomeDaMae, String login,String Senha , String cargo) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataDeAdmissao = dataDeAdmissao;
		this.rg = rg;
		this.nomeDaMae = nomeDaMae;
		this.usuario = new Usuario(nomeCompleto, login, Senha, EnumPerfil.COLABORADOR);
		this.cargo = new Cargo();
	}
    
	public void setDataAdmissao(String data) throws Exception {
		String[] ddMMyyy = data.split("/");
		this.dataDeAdmissao=LocalDate.of(Integer.parseInt(ddMMyyy[2]), Integer.parseInt(ddMMyyy[1]), Integer.parseInt(ddMMyyy[0]));
	}
    
}
