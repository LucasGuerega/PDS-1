package visao;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.CategoriaEvento;
import modelo.Evento;

public class EventoJTableModel extends AbstractTableModel{

	private ArrayList<Evento> lista;
	private String[] colunas ={"Nome do Evento", "Localização", "Descrição", "Data", "Hora", "Preço do Ingresso(R$)",
			"Categoria", "Avaliação Média", "Site Oficial", "Email de Contato", "Telefone de Contato",
			"Endereço", "Cidade", "Estado", "CEP"};
	
	public EventoJTableModel(ArrayList<Evento > lista) {
		this.lista=lista;
	}
	
	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Evento p = lista.get(rowIndex);
		if(columnIndex == 0) {
			return p.getNomeEvento();
		} else if(columnIndex == 1) {
			return p.getLocalização();
		} else if(columnIndex == 2) {
			return p.getDescrição();
		} else if(columnIndex == 3) {
			return p.getData();
		} else if(columnIndex == 4) {
			return p.getHora();
		} else if(columnIndex == 5) {
			return p.getPreçoIngresso();
		} else if(columnIndex == 6) {
			return p.getCategoria();
		}else if(columnIndex == 7) {
			return p.getAvaliaçãoMédia();
		} else if(columnIndex == 8) {
			return p.getSiteOficial();
		} else if(columnIndex == 9) {
			return p.getEmailContato();
		} else if(columnIndex == 10) {
			return p.getTelefoneContato();
		} else if(columnIndex == 11) {
			return p.getEndereço();
		} else if(columnIndex == 12) {
			return p.getCidade();
		} else if(columnIndex == 13) {
			return p.getEstado();
		} else if(columnIndex == 14) {
			return p.getCEP();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}


}
