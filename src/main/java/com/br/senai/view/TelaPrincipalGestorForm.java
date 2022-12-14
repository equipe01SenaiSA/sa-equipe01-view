package com.br.senai.view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@Component
//PRINCIPAL ACESSO GESTOR
public abstract class TelaPrincipalGestorForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4715605324666831252L;
	private JPanel contentPane;
	
	protected abstract void btnCargosClick(ActionEvent ev);
	protected abstract void btnColaboradoresClick(ActionEvent ev);
	protected abstract void btnSairClick(ActionEvent ev);

	protected JTextPane txtNomeUsuarioLogado = new JTextPane();
	
	public void setNomeUsuario(String nomeCompleto) {
		this.txtNomeUsuarioLogado.setText(nomeCompleto);
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalGestorForm() {
		setTitle("Principal (Acesso Gestor) - SA System 1.1");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargos = new JButton("Cargos");
		btnCargos.setForeground(Color.WHITE);
		btnCargos.setBackground(SystemColor.desktop);
		btnCargos.setBounds(127, 36, 196, 25);
		contentPane.add(btnCargos);
		
		JButton btnColaborador = new JButton("Colaboradores");
		btnColaborador.setForeground(Color.WHITE);
		btnColaborador.setBackground(SystemColor.desktop);
		btnColaborador.setBounds(127, 92, 196, 25);
		contentPane.add(btnColaborador);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(SystemColor.text);
		btnSair.setBackground(SystemColor.desktop);
		btnSair.setBounds(127, 155, 196, 25);
		contentPane.add(btnSair);
		
		
		JLabel lblNewLabel = new JLabel("Usuário Logado");
		lblNewLabel.setBounds(10, 226, 89, 25);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuarioLogado.setBounds(109, 226, 315, 25);
		contentPane.add(txtNomeUsuarioLogado);

		btnSair.addActionListener(this::btnSairClick);
		btnColaborador.addActionListener(this::btnColaboradoresClick);
		btnCargos.addActionListener(this::btnCargosClick);
	}
}
