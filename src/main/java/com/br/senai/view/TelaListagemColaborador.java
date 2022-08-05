package com.br.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.senai.client.ColaboradorClient;
import com.br.senai.dto.Colaborador;
import com.br.senai.view.table.ColaboradorTableModel;



@Component
public class TelaListagemColaborador extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	@Autowired
	private ColaboradorClient client;
	
	@Autowired
	private TelaInsercaoColaborador telaInsercaoColaborador;	
	
	private JTextField edtNomeCompleto;	
	
	private void atualizar(JTable tabela) {
		try {
			String teste = edtNomeCompleto.getText();
			if (teste == null || teste.isBlank()) {
				throw new IllegalArgumentException("O filtro é obrigatório.");
			}
			List<Colaborador> colaboradores = client.listarPor(edtNomeCompleto.getText());	
			ColaboradorTableModel model = new ColaboradorTableModel(colaboradores);
			tabela.setModel(model);
			TableColumnModel cm = tabela.getColumnModel();
			cm.getColumn(0).setPreferredWidth(50);
			cm.getColumn(1).setPreferredWidth(352);
			tabela.updateUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}
	
	private Colaborador getColaboradorSelecionadoNa(JTable tabela, String msgErro) {
		int linhaSelecionada = tabela.getSelectedRow();
		if (linhaSelecionada < 0) {
			throw new IllegalArgumentException(msgErro);
		}
		ColaboradorTableModel model = (ColaboradorTableModel)tabela.getModel();
		Colaborador itemSelecionado = model.getPor(linhaSelecionada);
		return itemSelecionado;
	}
	
	private void removerRegistroDa(JTable tabela) {
		try {
			
			Colaborador colaboradorSelecionado = getColaboradorSelecionadoNa(tabela, "Selecione um registro na tabela para remoção.");
			
			int opcaoSelecionada = JOptionPane.showConfirmDialog(
					contentPane, "Deseja realmente remover?", "Remoção", JOptionPane.YES_NO_OPTION);
			
			if (opcaoSelecionada == JOptionPane.YES_OPTION) {			
				this.client.excluir(colaboradorSelecionado);
				((ColaboradorTableModel)tabela.getModel()).remover(colaboradorSelecionado);
				tabela.updateUI();
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}
	
	private void editarRegistroDa(JTable tabela) {
		try {		
			Colaborador registroSelecionado = getColaboradorSelecionadoNa(tabela, "Selecione um registro na tabela para edição.");
			setVisible(false);
			telaInsercaoColaborador.setVisible(true);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemColaborador() {
		setTitle("Listagem de Colaborador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		
		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setColumns(10);
		
		JTable tabela = new JTable();
		tabela.setFillsViewportHeight(true);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizar(tabela);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarRegistroDa(tabela);
			}
		});
		
		JButton btnExcluir = new JButton("Remover");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerRegistroDa(tabela);
			}
		});
	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaInsercaoColaborador.setVisible(true);
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
							.addComponent(edtNomeCompleto, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
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
					.addComponent(edtNomeCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
