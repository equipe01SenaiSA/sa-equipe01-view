package com.br.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TelaPrincipalGestor extends TelaPrincipalGestorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	TelaListagemCargo telaListagemCargo;

	@Autowired
	TelaListagemColaborador telaListagemColaborador;

	@Autowired
	@Lazy
	TelaLogin telaLogin;

	@Override
	public void setNomeUsuario(String nomeCompleto) {
		this.txtNomeUsuarioLogado.setText(nomeCompleto);
	}

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
		telaLogin.setVisible(true);
		this.setVisible(false);
		this.dispose();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaLogin.setVisible(true);
			}
		});
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
