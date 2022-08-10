package com.br.senai.view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.br.senai.client.CargoClient;
import com.br.senai.client.ColaboradorClient;
import com.br.senai.dto.Cargo;
import com.br.senai.dto.Colaborador;
import com.br.senai.dto.Usuario;
import com.br.senai.enuns.EnumPerfil;

@Component
public class TelaCadastroColaborador extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;

	private Colaborador colaboradorEditar;

	private JPanel contentPane;

	@Autowired
	private CargoClient client;

	@Autowired
	private ColaboradorClient colaboradorClient;

	@Autowired
	private TelaInsercaoCargo telaInsercaoCargo;

	@Autowired
	private TelaListagemColaborador telaListagemColaborador;

	@Autowired
	@Lazy
	private TelaPrincipalColaborador telaPrincipalColaborador;

	private JTextField edtDescricaoCurta;

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
	private JPasswordField fdSenha2;
	private JLabel lblNewLabel_2;

//	protected abstract void btnSalvarAction(ActionEvent ev);
//	protected abstract void comboBoxChange(ActionEvent ev);

	public void apresentarTela() {
		client.listAllCargos().forEach(cargo -> {
			cargosComboBox.addItem(cargo);
		});
		this.setVisible(true);
		carregarCamposColaboradorEditar();
	}

	private void carregarCamposColaboradorEditar() {
		if (colaboradorEditar != null && colaboradorEditar.getId() != null && colaboradorEditar.getId() > 0) {
			fdNomeCompleto.setText(this.colaboradorEditar.getNomeCompleto());
			fdCPF.setText(this.colaboradorEditar.getCpf());
			fdRG.setText(this.colaboradorEditar.getRg());
			fdLogin.setText(
					this.colaboradorEditar.getUsuario() != null ? this.colaboradorEditar.getUsuario().getLogin() : "");
			fdSenha.setText(
					this.colaboradorEditar.getUsuario() != null ? this.colaboradorEditar.getUsuario().getSenha() : "");
			fdNomeDaMae.setText(this.colaboradorEditar.getNomeDaMae());
		}
	}

	private void limparCampos() {
		fdNomeCompleto.setText("");
		fdCPF.setText("");
		fdRG.setText("");
		fdLogin.setText("");
		fdSenha.setText("");
		fdNomeDaMae.setText("");
	}

	private void salvarColaborador(Colaborador colaborador) {

		// editar
		if (colaboradorEditar != null && colaboradorEditar.getId() != null && colaboradorEditar.getId() > 0) {
			colaborador.setId(colaboradorEditar.getId());
		}

		this.colaboradorClient.inserir(colaborador);
		limparCampos();
	}

	private String[] getCargosDescricao() {
		List<Cargo> allCargos = client.listAllCargos();
		String[] descricaoCargos = new String[allCargos.size()];

		for (int i = 0; i < descricaoCargos.length; i++) {
			descricaoCargos[i] = allCargos.get(i).getDescricaoCurta();
		}

		return descricaoCargos;
	}

	public TelaCadastroColaborador() {
		setTitle("Colaborador(EDIÇÃO)");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaPrincipalColaborador.setVisible(true);
			}
		});

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(SystemColor.activeCaption);
		btnSalvar.setForeground(UIManager.getColor("Button.darkShadow"));
		btnSalvar.setBounds(319, 229, 94, 25);
		contentPane.add(btnSalvar);
		Object lblNomeCompleto = new JLabel("Nome Completo");
//		lblNomeCompleto.setBounds(23, 12, 372, 15);
//		contentPane.add(lblNomeCompleto);

		fdNomeCompleto = new JTextField();
		fdNomeCompleto.setBounds(23, 31, 405, 19);
		contentPane.add(fdNomeCompleto);
		fdNomeCompleto.setColumns(10);

		JLabel lblCpf = new JLabel("CPF (123.123.123-56)");
		lblCpf.setBounds(23, 61, 144, 15);
		contentPane.add(lblCpf);

		fdCPF = new JTextField();
		fdCPF.setBounds(23, 81, 161, 19);
		contentPane.add(fdCPF);
		fdCPF.setColumns(10);

		JLabel lblRg = new JLabel("RG (12.123.123)");
		lblRg.setBounds(196, 61, 126, 15);
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

		fdSenha = new JPasswordField();
		fdSenha.setBounds(174, 232, 135, 19);
		contentPane.add(fdSenha);
		fdSenha.setColumns(10);

		fdNomeDaMae = new JTextField();
		fdNomeDaMae.setBounds(23, 125, 405, 19);
		contentPane.add(fdNomeDaMae);
		fdNomeDaMae.setColumns(10);

		lbCargo = new JLabel("Cargo");
		lbCargo.setBounds(23, 156, 70, 15);
		// contentPane.add(lbCargo);()

		lblDataDeAdmisso = new JLabel("Data de Admissão (dd/MM/yyyy)");
		lblDataDeAdmisso.setBounds(174, 156, 208, 15);
		contentPane.add(lblDataDeAdmisso);

		fdDataAdmissisao = new JFormattedTextField();
		fdDataAdmissisao.setBounds(174, 174, 252, 19);
		contentPane.add(fdDataAdmissisao);

		JLabel lbCargos = new JLabel("Cargos");
		lbCargos.setBounds(23, 156, 70, 15);
		contentPane.add(lbCargos);

		String[] animals = { "Cargo1", "Cargo2", "Cargo3" };

		cargosComboBox = new JComboBox();
		cargosComboBox.setBounds(23, 174, 133, 19);
		contentPane.add(cargosComboBox);

		JLabel lblNewLabel_1 = new JLabel("Nome Completo");
		lblNewLabel_1.setBounds(23, 10, 208, 13);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(277, 10, 45, 13);
		contentPane.add(lblNewLabel_2);

		fdDataAdmissisao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
						|| (c == KeyEvent.VK_SLASH))) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid");
					e.consume();
				}
			}
		});

		fdDataAdmissisao.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Colaborador colaborador = new Colaborador();

				colaborador.setCpf(fdCPF.getText());
				colaborador.setNomeDaMae(fdNomeDaMae.getText());
				colaborador.setNomeCompleto(fdNomeCompleto.getText());
				colaborador.setRg(fdRG.getText());

				String login = fdLogin.getText();
				String senha = fdSenha.getText();

				colaborador
						.setUsuario(new Usuario(colaborador.getNomeCompleto(), login, senha, EnumPerfil.COLABORADOR));
				colaborador.setCargo((Cargo) cargosComboBox.getSelectedItem());
				try {
					colaborador.setDataAdmissao(fdDataAdmissisao.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Formato da data está incorreto ");
					e1.printStackTrace();
					fdDataAdmissisao.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				}
				salvarColaborador(colaborador);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso !");
			}
		});
//		cargosComboBox.addActionListener(this::comboBoxChange);
	}

	public void setColaboradorEditar(Colaborador registroSelecionado) {
		// TODO Auto-generated method stub
		this.colaboradorEditar = new Colaborador();
		this.colaboradorEditar = registroSelecionado;
	}
}
