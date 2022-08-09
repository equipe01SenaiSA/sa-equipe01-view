package com.br.senai.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.br.senai.client.CargoClient;
import com.br.senai.dto.Cargo;
import com.br.senai.view.table.CargoTableModel;

@Component
public class TelaListagemCargo extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	@Autowired
	private CargoClient client;
	
	@Autowired
	@Lazy
	private TelaInsercaoCargo telaInsercaoCargo;	
	
	@Autowired
	@Lazy
	private TelaPrincipalGestor telaPrincipalGestor;
	
	private JTextField edtDescricaoCurta;	
	
	private void atualizar(JTable tabela) {
		try {
			String teste = edtDescricaoCurta.getText();
			if (teste == null || teste.isBlank()) {
				throw new IllegalArgumentException("O filtro é obrigatório.");
			}
			List<Cargo> cargos = client.listarPor(edtDescricaoCurta.getText());	
			CargoTableModel model = new CargoTableModel(cargos);
			tabela.setModel(model);
			TableColumnModel cm = tabela.getColumnModel();
			cm.getColumn(0).setPreferredWidth(50);
			cm.getColumn(1).setPreferredWidth(352);
			tabela.updateUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}
	
	private Cargo getCargoSelecionadoNa(JTable tabela, String msg) {
		int linhaSelecionada = tabela.getSelectedRow();
		if (linhaSelecionada < 0) {
			throw new IllegalArgumentException(msg);
		}
		CargoTableModel model = (CargoTableModel)tabela.getModel();
		Cargo itemSelecionado = model.getPor(linhaSelecionada);
		return itemSelecionado;
	}
	
	private void removerRegistroDa(JTable tabela) {
		try {
			
			Cargo cargoSelecionado = getCargoSelecionadoNa(tabela, "Selecione um registro na tabela para remoção");
			
			int opcaoSelecionada = JOptionPane.showConfirmDialog(
					contentPane, "Deseja realmente remover?", "Remoção", JOptionPane.YES_NO_OPTION);
			
			if (opcaoSelecionada == JOptionPane.YES_OPTION) {			
				this.client.excluir(cargoSelecionado);
				((CargoTableModel)tabela.getModel()).remover(cargoSelecionado);
				tabela.updateUI();
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}
	
	private void editarRegistroDa(JTable tabela) {
		try {		
			Cargo registroSelecionado = getCargoSelecionadoNa(tabela, "Selecione um registro na tabela para edição");
			this.telaInsercaoCargo.colocarEmEdicao(registroSelecionado);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemCargo() {
		setTitle("Listagem de Cargo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaPrincipalGestor.setVisible(true);
			}
		});
		
		setBounds(100, 100, 450, 377);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setColumns(10);
		
		JTable tabela = new JTable();
		tabela.setFillsViewportHeight(true);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(SystemColor.desktop);
		btnListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizar(tabela);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(SystemColor.desktop);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarRegistroDa(tabela);
			}
		});
		
		JButton btnExcluir = new JButton("Remover");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(SystemColor.desktop);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerRegistroDa(tabela);
			}
		});
	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(SystemColor.desktop);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaInsercaoCargo.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnListar)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
							.addComponent(btnAdicionar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(edtDescricaoCurta, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnAdicionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(edtDescricaoCurta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
