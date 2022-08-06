package com.br.senai.view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.senai.client.CargoClient;
import com.br.senai.dto.Cargo;

public abstract class Tela8Form extends JFrame {

	//@Autowired
	//private CargoClient client;

	private static final long serialVersionUID = 4675274612481183222L;
	private JPanel contentPane;
	protected JTextField fdNomeCompleto;
	protected JTextField fdCPF;
	protected JTextField fdRG;
	protected JTextField fdLogin;
	protected JLabel lblSenha;
	protected JTextField fdSenha;
	protected JTextField fdNomeDaMae;
	protected JLabel lbCargo;
	protected JLabel lblDataDeAdmisso;
	protected JLabel lblNomeCompleto;
	protected JComboBox cargosComboBox;
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	protected JFormattedTextField fdDataAdmissisao = new JFormattedTextField(df);
	
	protected abstract void btnSalvarAction(ActionEvent ev);
	protected abstract void comboBoxChange(ActionEvent ev);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
//	private String[] getCargosDescricao() {
//		
//		//this.client = new CargoClient();
//		
//		List<Cargo> allCargos = client.listAllCargos();
//		String[] descricaoCargos = new String[allCargos.size()];
//		
//		for (int i = 0; i < descricaoCargos.length; i++) {
//			descricaoCargos[i]=allCargos.get(i).getDescricaoCurta();
//		}
//		
//		return descricaoCargos;
//	}
	
	public Tela8Form() {
		//this.client = new CargoClient();
		setTitle("Colaborador(EDIÇÃO)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(UIManager.getColor("Button.darkShadow"));
		btnSalvar.setBounds(321, 238, 117, 25);
		contentPane.add(btnSalvar);
		Object
		lblNomeCompleto = new JLabel("Nome Completo");
//		lblNomeCompleto.setBounds(23, 12, 372, 15);
//		contentPane.add(lblNomeCompleto);
		
		fdNomeCompleto = new JTextField();
		fdNomeCompleto.setBounds(23, 31, 405, 19);
		contentPane.add(fdNomeCompleto);
		fdNomeCompleto.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(23, 61, 70, 15);
		contentPane.add(lblCpf);
		
		fdCPF = new JTextField();
		fdCPF.setBounds(23, 81, 161, 19);
		contentPane.add(fdCPF);
		fdCPF.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(196, 61, 70, 15);
		contentPane.add(lblRg);
		
		fdRG = new JTextField();
		fdRG.setBounds(196, 81, 232, 19);
		contentPane.add(fdRG);
		fdRG.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome Da Mãe");
		lblNomeDaMe.setBounds(23, 99, 405, 25);
		contentPane.add(lblNomeDaMe);
		
		fdLogin = new JTextField();
		fdLogin.setBounds(23, 232, 144, 19);
		contentPane.add(fdLogin);
		fdLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(23, 205, 70, 15);
		contentPane.add(lblNewLabel);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(174, 205, 70, 15);
		contentPane.add(lblSenha);
		
		fdSenha = new JTextField();
		fdSenha.setBounds(174, 232, 135, 19);
		contentPane.add(fdSenha);
		fdSenha.setColumns(10);
		
		fdNomeDaMae = new JTextField();
		fdNomeDaMae.setBounds(23, 125, 405, 19);
		contentPane.add(fdNomeDaMae);
		fdNomeDaMae.setColumns(10);
		
		lbCargo = new JLabel("Cargo");
		lbCargo.setBounds(23, 156, 70, 15);
		//contentPane.add(lbCargo);()
		
		lblDataDeAdmisso = new JLabel("Data de Admissão");
		lblDataDeAdmisso.setBounds(174, 156, 208, 15);
		contentPane.add(lblDataDeAdmisso);
		
		fdDataAdmissisao = new JFormattedTextField();
		fdDataAdmissisao.setBounds(174, 174, 264, 19);
		contentPane.add(fdDataAdmissisao);
		
		JLabel lbCargos = new JLabel("Cargos");
		lbCargos.setBounds(23, 156, 70, 15);
		contentPane.add(lbCargos);
		
		String[] animals = {"Cargo1","Cargo2","Cargo3"};
		
//		String[] animals = getCargosDescricao();
		cargosComboBox = new JComboBox(animals);
		cargosComboBox.setBounds(23, 174, 133, 19);
		contentPane.add(cargosComboBox);
		
		fdDataAdmissisao.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
		      {
		        JOptionPane.showMessageDialog(null, "Please Enter Valid");
		        e.consume();
		      }
		    }
		  });
		
		btnSalvar.addActionListener(this::btnSalvarAction);
		cargosComboBox.addActionListener(this::comboBoxChange);
	}
}
