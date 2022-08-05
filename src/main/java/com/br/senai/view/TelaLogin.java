package com.br.senai.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.senai.client.LoginClient;
import com.br.senai.dto.Login;
import com.br.senai.dto.Usuario;
import com.br.senai.enuns.EnumPerfil;

@Component
public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtLogin;
	private JPasswordField edtSenha;

	/**
	 * Launch the application.
	 */

	@Autowired
	private LoginClient loginClient;
	
	@Autowired
	private TelaPrincipalGestor telaPrincipalGestor;
	
	@Autowired
	//private TelaPrincipalColaborador telaPrincipalColaborador;

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Login - SA System 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));

		edtLogin = new JTextField();
		edtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));

		edtSenha = new JPasswordField();

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String login = edtLogin.getText();
					String senha = new String(edtSenha.getPassword());

					Usuario loginEfetuado = null;
					if (login == null || login.isBlank()) {
						throw new IllegalArgumentException("Login  inválidos");
					} else if (senha == null || senha.isBlank()) {
						throw new IllegalArgumentException("senha  inválidos");
					}
					
					loginEfetuado = loginClient.efetuarPor(login, senha);
					
					if (loginEfetuado == null) {
						throw new IllegalArgumentException("errado");
					}else if (loginEfetuado.getPerfil() == EnumPerfil.GESTOR) {
						telaPrincipalGestor.setVisible(true);
					}else if (loginEfetuado.getPerfil() == EnumPerfil.COLABORADOR) {
						//telaPrincipalColaborador.setVisible(true);
					}	

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, e2.getMessage());
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(edtLogin,
								GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(edtSenha, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblLogin).addComponent(lblSenha))
												.addGap(156))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(146).addComponent(btnLogar,
								GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblLogin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(edtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblSenha)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(edtSenha, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnLogar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
