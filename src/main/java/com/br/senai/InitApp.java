package com.br.senai;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.br.senai.view.TelaPrincipalGestorForm;
import com.br.senai.view.TelaListagemCargo;
import com.br.senai.view.TelaListagemColaborador;
import com.br.senai.view.TelaLogin;

@SpringBootApplication
public class InitApp {
	
	@Autowired
	private TelaListagemCargo listagemCargo;
	
	@Autowired
	private TelaListagemColaborador listagemColaborador;
	
	@Autowired
	private TelaLogin login;
	
	@Autowired
	private TelaPrincipalGestorForm telinha;

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
							//Apresentar tela principal aqui
							//listagemCargo.setVisible(true);
							//login.setVisible(true);
							//listagemColaborador.setVisible(true);
							telinha.setVisible(true);
							
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
