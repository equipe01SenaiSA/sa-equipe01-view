package com.br.senai.view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants.ConstantException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.br.senai.client.CargoClient;
import com.br.senai.dto.Cargo;

@Component
public class TelaInsercaoCargo extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField edtDescricaoCurta;
	private JTextField edtAtribuicoes;
	
	@Autowired
	private CargoClient client;
	
	private Cargo cargoSalvo;
	
	@Autowired
	private TelaListagemCargo telaListagemCargo;
	
	public void colocarEmEdicao(
			Cargo cargoSalvo) {
		this.edtDescricaoCurta.setText(
				cargoSalvo.getDescricaoCurta());
		this.edtAtribuicoes.setText(
				cargoSalvo.getAtribuicoes());
		this.cargoSalvo = cargoSalvo;
		setVisible(true);
	}
	
	public void colocarEmInclusao() {
		this.cargoSalvo = null;
		this.edtDescricaoCurta.setText("");
		this.edtAtribuicoes.setText("");
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TelaInsercaoCargo() {
		setTitle("Cargo (INSERÇÃO/EDIÇÃO) - SA System 1.1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 233);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Descrição Curta");
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Atribuições");
		
		edtAtribuicoes = new JTextField();
		edtAtribuicoes.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.desktop);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (cargoSalvo != null) {
						cargoSalvo.setDescricaoCurta(
								edtDescricaoCurta.getText());
						cargoSalvo.setAtribuicoes(
								edtAtribuicoes.getText());
						client.alterar(cargoSalvo);
						JOptionPane.showMessageDialog(contentPane, 
								"Cargo alterado com sucesso");
					}else {
						Cargo novoCargo = new Cargo();
						novoCargo.setDescricaoCurta(edtDescricaoCurta.getText());
						novoCargo.setAtribuicoes(edtAtribuicoes.getText());
						client.inserir(novoCargo);
						JOptionPane.showMessageDialog(contentPane, 
								"Cargo inserido com sucesso");
					}
				}catch (HttpClientErrorException ex) {
					JOptionPane.showMessageDialog(contentPane, "A descrição curta é obrigatória");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
				
			}
		});
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					setVisible(false);
					telaListagemCargo.setVisible(true);
				}
			});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(355, Short.MAX_VALUE)
							.addComponent(btnSalvar))
						.addComponent(edtAtribuicoes, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(edtDescricaoCurta, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtDescricaoCurta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtAtribuicoes, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar))
		);
		contentPane.setLayout(gl_contentPane);
	}
}