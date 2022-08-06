package com.br.senai;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.br.senai.view.Tela8;
import com.br.senai.view.TelaCadastroColaborador;
import com.br.senai.view.TelaLogin;
import com.br.senai.view.TelaPrincipalGestorForm;

@SpringBootApplication
public class InitApp {
	
	@Autowired
	private TelaLogin login;
	
	@Autowired
	private TelaPrincipalGestorForm telinha;
	
	@Autowired
	private TelaCadastroColaborador tela;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = 
				new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {				
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {							
							//login.setVisible(true);
							//telinha.setVisible(true);
							tela.apresentarTela();
						} catch (Exception e) {							
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				});
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		};
	}

}
