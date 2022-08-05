package com.br.senai.view;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class TelaInsercaoColaborador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNomeCompleto;
	private JTextField edtCPF;
	private JTextField edtRG;
	private JTextField edtNomeDaMae;
	private JTextField edtLogin;
	private JTextField edtSenha;
	private JTextField edtDataDeAdmissao;
	
	public TelaInsercaoColaborador() {
		setTitle("Gerenciar Colaborador(Acesso Gestor) (INSERCAO/EDICAO)-SA  SYSTEM 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(287, 11, 117, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo\r\n");
		lblNomeCompleto.setBounds(10, 49, 110, 23);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 103, 35, 23);
		contentPane.add(lblCPF);
		
		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setBounds(10, 83, 215, 20);
		contentPane.add(edtNomeCompleto);
		edtNomeCompleto.setColumns(10);
		
		edtCPF = new JTextField();
		edtCPF.setColumns(10);
		edtCPF.setBounds(10, 137, 159, 23);
		contentPane.add(edtCPF);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(312, 381, 117, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(273, 103, 35, 23);
		contentPane.add(lblRg);
		
		edtRG = new JTextField();
		edtRG.setColumns(10);
		edtRG.setBounds(273, 137, 117, 23);
		contentPane.add(edtRG);
		
		edtNomeDaMae = new JTextField();
		edtNomeDaMae.setColumns(10);
		edtNomeDaMae.setBounds(10, 195, 159, 23);
		contentPane.add(edtNomeDaMae);
		
		JLabel lblNomeDaMae = new JLabel("Nome da Mae\r\n");
		lblNomeDaMae.setBounds(10, 171, 110, 23);
		contentPane.add(lblNomeDaMae);
		
		edtLogin = new JTextField();
		edtLogin.setColumns(10);
		edtLogin.setBounds(10, 337, 159, 23);
		contentPane.add(edtLogin);
		
		edtSenha = new JTextField();
		edtSenha.setColumns(10);
		edtSenha.setBounds(287, 338, 159, 23);
		contentPane.add(edtSenha);
		
		JLabel lblLogin = new JLabel("Login\r\n");
		lblLogin.setBounds(10, 315, 110, 23);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha\r\n");
		lblSenha.setBounds(287, 315, 110, 23);
		contentPane.add(lblSenha);
		
		edtDataDeAdmissao = new JTextField();
		edtDataDeAdmissao.setColumns(10);
		edtDataDeAdmissao.setBounds(270, 207, 159, 23);
		contentPane.add(edtDataDeAdmissao);
		
		JLabel lblDataDeAdmissao = new JLabel("Data de Admissao");
		lblDataDeAdmissao.setBounds(273, 171, 110, 23);
		contentPane.add(lblDataDeAdmissao);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 226, 110, 23);
		contentPane.add(lblCargo);
		
		JComboBox cbCargo = new JComboBox();
		cbCargo.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		cbCargo.setToolTipText("");
		cbCargo.setBounds(10, 260, 159, 22);
		contentPane.add(cbCargo);
	}
}
