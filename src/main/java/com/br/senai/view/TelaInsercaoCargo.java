package com.br.senai.view;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class TelaInsercaoCargo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInsercaoCargo frame = new TelaInsercaoCargo();
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
	public TelaInsercaoCargo() {
		setTitle("Cargo(INSERCAO/EDICAO)-SA  SYSTEM 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(312, 5, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Descricao Curta");
		lblNewLabel.setBounds(10, 49, 110, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblAtribuicoes = new JLabel("Atribuicoes\r\n");
		lblAtribuicoes.setBounds(10, 103, 110, 23);
		contentPane.add(lblAtribuicoes);
		
		textField = new JTextField();
		textField.setBounds(10, 83, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 137, 242, 83);
		contentPane.add(textField_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(307, 211, 117, 23);
		contentPane.add(btnSalvar);
	}
}

