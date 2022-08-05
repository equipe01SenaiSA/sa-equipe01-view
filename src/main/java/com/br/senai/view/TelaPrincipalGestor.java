package com.br.senai.view;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TelaPrincipalGestor extends TelaPrincipalGestorForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	TelaListagemCargo telaListagemCargo;
	
	@Autowired
	TelaListagemColaborador telaListagemColaborador;

	@Override
	protected void btnCargosClick(ActionEvent ev) {
		this.telaListagemCargo.setVisible(true);
		this.setVisible(false);
	}

	@Override
	protected void btnColaboradoresClick(ActionEvent ev) {
		this.telaListagemColaborador.setVisible(true);
		this.setVisible(false);
	}

	@Override
	protected void btnSairClick(ActionEvent ev) {
		this.setVisible(false);
		this.dispose();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalGestor frame = new TelaPrincipalGestor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
