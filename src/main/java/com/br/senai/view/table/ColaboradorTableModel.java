package com.br.senai.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.br.senai.dto.Cargo;
import com.br.senai.dto.Colaborador;

public class ColaboradorTableModel extends AbstractTableModel{

private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 2;
	
	private List<Colaborador> colaboradores;
	
	public ColaboradorTableModel(
			List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	@Override
	public int getRowCount() {
		return colaboradores.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		
		if (column == 0) {
			return "ID";
		}else if (column == 1) {		
			return "Nome Completo";
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}
	
	public Cargo getPor(int rowIndex) {
		return cargos.get(rowIndex);
	}
	
	public void removePor(int rowIndex) {
		this.cargos.remove(rowIndex);
	}
	
	public void remover(Cargo cargo) {
		this.cargos.remove(cargo);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return this.cargos.get(rowIndex).getId();
		}else if (columnIndex == 1) {			
			return this.cargos.get(rowIndex).getDescricaoCurta();
		}
		throw new IllegalArgumentException("Índice inválido");
	}

}
