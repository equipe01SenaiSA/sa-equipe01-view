package com.br.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.beans.JavaBean;
import java.io.Serializable;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.senai.client.CargoClient;
import com.br.senai.dto.Cargo;
import com.br.senai.dto.Colaborador;

@Component
public class Tela8 extends Tela8Form implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void btnSalvarAction(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void comboBoxChange(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	//@Autowired
//	Tela8Form tela8Form;
//	
//	@Autowired
//	private Colaborador colaborador;
//	
//	@Autowired
//	private CargoClient client;
//	
//	public Tela8() {
//		//this.client = new CargoClient();
//		//List<Cargo> listAllCargos = this.client.listAllCargos();
//	}
//	
//	@Override
//	protected void btnSalvarAction(ActionEvent ev) {
//		try {
//			String nomeCompleto = this.fdNomeCompleto.getText();
//			String cpf = this.fdNomeCompleto.getText();
//			String rg = this.fdNomeCompleto.getText();
//			String nomeDaMae = this.fdNomeCompleto.getText();
//			String dataAdmissao = this.fdDataAdmissisao.getText();
//			String login = this.fdLogin.getText();
//			String senha = this.fdSenha.getText();
//			String cargo = (String) this.cargosComboBox.getSelectedItem();
//
//			//colaborador = new Colaborador(nomeCompleto, cpf, dataAdmissao, cargo, nomeDaMae);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
//	
//	@Override
//	protected void comboBoxChange(ActionEvent ev) {
//		System.out.println(this.cargosComboBox.getSelectedItem());
//	}


}
