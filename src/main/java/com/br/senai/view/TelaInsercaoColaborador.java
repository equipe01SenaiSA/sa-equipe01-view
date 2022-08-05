package com.br.senai.view;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaInsercaoColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInsercaoColaborador frame = new TelaInsercaoColaborador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInsercaoColaborador() {
		setTitle("Gerenciar Colaborador(Acesso Gestor) (INSERCAO/EDICAO)-SA  SYSTEM 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(287, 11, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome Completo\r\n");
		lblNewLabel.setBounds(10, 49, 110, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblAtribuicoes = new JLabel("CPF");
		lblAtribuicoes.setBounds(10, 103, 35, 23);
		contentPane.add(lblAtribuicoes);
		
		textField = new JTextField();
		textField.setBounds(10, 83, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 137, 159, 23);
		contentPane.add(textField_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(312, 381, 117, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(273, 103, 35, 23);
		contentPane.add(lblRg);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(273, 137, 117, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 195, 159, 23);
		contentPane.add(textField_3);
		
		JLabel lblNomeDaMae = new JLabel("Nome da Mae\r\n");
		lblNomeDaMae.setBounds(10, 171, 110, 23);
		contentPane.add(lblNomeDaMae);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 337, 159, 23);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(287, 338, 159, 23);
		contentPane.add(textField_5);
		
		JLabel lblLogin = new JLabel("Login\r\n");
		lblLogin.setBounds(10, 315, 110, 23);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha\r\n");
		lblSenha.setBounds(287, 315, 110, 23);
		contentPane.add(lblSenha);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(270, 207, 159, 23);
		contentPane.add(textField_6);
		
		JLabel lblDataDeAdmissao = new JLabel("Data de Admissao");
		lblDataDeAdmissao.setBounds(273, 171, 110, 23);
		contentPane.add(lblDataDeAdmissao);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 226, 110, 23);
		contentPane.add(lblCargo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 260, 159, 22);
		contentPane.add(comboBox);
	}
}
